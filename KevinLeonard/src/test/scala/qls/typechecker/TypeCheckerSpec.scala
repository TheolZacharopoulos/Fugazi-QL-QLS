package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{StringType, NumberType, BooleanType, Variable}
import ql.typechecker.Error
import qls.ast._

import scala.util.parsing.input.NoPosition

class TypeCheckerSpec extends Specification {
  val checker = new TypeChecker
  import checker._

  "type checker for questions" should {
    "return no error if spin box widget is used for a number question" in {
      val question = Question(Variable("x"), SpinBox(List()))
      val environmentWithQuestion = Map("x" -> NumberType())

      check(question, environmentWithQuestion) must beNone
    }

    "return error if spin box widget is used for a non number question" in {
      val question = Question(Variable("x"), SpinBox(List()))
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = new Error("Spin box widget not allowed for question x", Some(NoPosition))

      check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if slider widget is used for a number question" in {
      val question = Question(Variable("x"), Slider(List()))
      val environmentWithQuestion = Map("x" -> NumberType())

      check(question, environmentWithQuestion) must beNone
    }

    "return error if slider widget is used for a non number question" in {
      val question = Question(Variable("x"), Slider(List()))
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = new Error("Slider widget not allowed for question x", Some(NoPosition))

      check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if text widget is used for a string question" in {
      val question = Question(Variable("x"), Text(List()))
      val environmentWithQuestion = Map("x" -> StringType())

      check(question, environmentWithQuestion) must beNone
    }

    "return no error if text widget is used for a number question" in {
      val question = Question(Variable("x"), Text(List()))
      val environmentWithQuestion = Map("x" -> NumberType())

      check(question, environmentWithQuestion) must beNone
    }

    "return error if text widget is used for a non number/text question" in {
      val question = Question(Variable("x"), Text(List()))
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = new Error("Text widget not allowed for question x", Some(NoPosition))

      check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if text block widget is used for a string question" in {
      val question = Question(Variable("x"), TextBlock(List()))
      val environmentWithQuestion = Map("x" -> StringType())

      check(question, environmentWithQuestion) must beNone
    }

    "return error if text block widget is used for a non string question" in {
      val question = Question(Variable("x"), TextBlock(List()))
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = new Error("Text block widget not allowed for question x", Some(NoPosition))

      check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if radio widget is used for a boolean question" in {
      val question = Question(Variable("x"), Radio(List()))
      val environmentWithQuestion = Map("x" -> BooleanType())

      check(question, environmentWithQuestion) must beNone
    }

    "return error if radio widget is used for a non boolean question" in {
      val question = Question(Variable("x"), Radio(List()))
      val environmentWithQuestion = Map("x" -> NumberType())
      val error = new Error("Radio widget not allowed for question x", Some(NoPosition))

      check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if check box widget is used for a boolean question" in {
      val question = Question(Variable("x"), CheckBox(List()))
      val environmentWithQuestion = Map("x" -> BooleanType())

      check(question, environmentWithQuestion) must beNone
    }

    "return error if check box widget is used for a non boolean question" in {
      val question = Question(Variable("x"), CheckBox(List()))
      val environmentWithQuestion = Map("x" -> NumberType())
      val error = new Error("Check box widget not allowed for question x", Some(NoPosition))

      check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if drop down widget is used for a boolean question" in {
      val question = Question(Variable("x"), DropDown(List()))
      val environmentWithQuestion = Map("x" -> BooleanType())

      check(question, environmentWithQuestion) must beNone
    }

    "return error if drop down widget is used for a non boolean question" in {
      val question = Question(Variable("x"), DropDown(List()))
      val environmentWithQuestion = Map("x" -> NumberType())
      val error = new Error("Drop down widget not allowed for question x", Some(NoPosition))

      check(question, environmentWithQuestion) must beSome(error)
    }
  }
}
