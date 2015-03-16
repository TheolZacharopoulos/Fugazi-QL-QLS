package ql.gui.widgets

import ql.ast.{Expression, Question, StringValue}
import types._

import scalafx.collections.ObservableMap.{Add, Replace}
import scalafx.scene.control.TextField

class StringQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  // Initialize TextField
  val value = eval
  val textField = new TextField {
    text = value
    text.onChange((_, _, newValue) => updateEnvironment(StringValue(newValue)))
  }
  updateEnvironment(StringValue(value))
  children.add(textField)

  // Observer for environment
  env.onChange((map, change) => change match {
    case Add(addedName, _) => updateProperties(textField, addedName)
    case Replace(replacedName, _, _) => updateProperties(textField, replacedName)
  })

  // Methods
  def updateProperties(field: TextField, name: VariableName): Unit = {
    updateVisibility(name)
    if (isVisible) {
      updateValue(field, name, eval)
    }
  }

  def updateValue(field: TextField, name: VariableName, value: String): Unit = {
    if (valueDependencies contains name) {
      field.text = value
    }
  }

  def eval: String = q.expression match {
    case Some(e) => evaluator.eval(e, env) match {
      case StringValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type String.")
    }
    case None => ""
  }
}
