package ql.typechecker

import ql.ast._
import org.specs2.matcher.{MatchResult, Expectable, Matcher, ExceptionMatchers}
import org.specs2.mutable.Specification

import scala.util.parsing.input.NoPosition

class TypeCheckerSpec extends Specification with ExceptionMatchers {
  val checker = new TypeChecker
  import checker._

  "statement" should {
    "add variable + type to environment, if statement is boolean question" in {
      check(Question(BooleanType(), Variable("X"), "label", None), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> BooleanType())))
    }

    "add variable + type to environment, if statement is number question" in {
      check(Question(NumberType(), Variable("X"), "label", None), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> NumberType())))
    }

    "add variable + type to environment, if statement is string question" in {
      check(Question(StringType(), Variable("X"), "label", None), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> StringType())))
    }

    "add variable + type to environment, if statement is computed boolean question with valid expression" in {
      check(Question(BooleanType(), Variable("X"), "label", Some(Literal(BooleanType(), BooleanValue(true)))), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> BooleanType())))
    }

    "throw exception, if statement is computed boolean question with invalid expression" in {
      check(Question(BooleanType(), Variable("X"), "label", Some(Literal(NumberType(), NumberValue(1)))), new TypeEnvironment()) must beLeft
    }

    "add variable + type to environment, if statement is computed number question with valid expression" in {
      check(Question(NumberType(), Variable("X"), "label", Some(Literal(NumberType(), NumberValue(1)))), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> NumberType())))
    }

    "throw exception, if statement is computed number question with invalid expression" in {
      check(Question(NumberType(), Variable("X"), "label", Some(Literal(BooleanType(), BooleanValue(false)))), new TypeEnvironment()) must beLeft
    }

    "add variable + type to environment, if statement is computed string question with valid expression" in {
      check(Question(StringType(), Variable("X"), "label", Some(Literal(StringType(), StringValue("")))), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> StringType())))
    }

    "throw exception, if statement is computed string question with invalid expression" in {
      check(Question(StringType(), Variable("X"), "label", Some(Literal(NumberType(), NumberValue(1)))), new TypeEnvironment()) must beLeft
    }

    "return empty environment, if valid boolean condition" in {
      check(IfStatement(Literal(BooleanType(), BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), None), new TypeEnvironment()) must beRight(new TypeEnvironment())
    }

    "throw exception, if invalid boolean condition" in {
      check(IfStatement(Literal(NumberType(), NumberValue(0)), Question(BooleanType(), Variable("X"), "label", None), None), new TypeEnvironment()) must beLeft
    }

    "throw exception, if error in if block" in {
      check(IfStatement(Literal(BooleanType(), BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", Some(Literal(NumberType(), NumberValue(1)))), None), new TypeEnvironment()) must beLeft
    }

    "return empty environment, if valid boolean condition (with else block)" in {
      check(IfStatement(Literal(BooleanType(), BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None))), new TypeEnvironment()) must beRight(new TypeEnvironment())
    }

    "throw exception, if invalid boolean condition (with else block)" in {
      check(IfStatement(Literal(NumberType(), NumberValue(0)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None))), new TypeEnvironment()) must beLeft
    }

    "throw exception, if error in if block (with else block)" in {
      check(IfStatement(Literal(BooleanType(), BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", Some(Literal(NumberType(), NumberValue(1)))), Some(Question(BooleanType(), Variable("X"), "label", None))), new TypeEnvironment()) must beLeft
    }

    "throw exception, if error in else block" in {
      check(IfStatement(Literal(BooleanType(), BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", Some(Literal(NumberType(), NumberValue(1)))))), new TypeEnvironment()) must beLeft
    }

    "add variable + type to environment " in {
      check(new Form("Form1", Question(BooleanType(), Variable("X"), "label", None)), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> BooleanType())))
    }

    "add variables + types to environment" in {
      check(Sequence(List(Question(BooleanType(), Variable("X"), "label1", None), Question(NumberType(), Variable("Y"), "label2", None), Question(StringType(), Variable("Z"), "label3", None))), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> BooleanType(), "Y" -> NumberType(), "Z" -> StringType())))
    }
  }

  "expression" should {
    "type check multiple expressions" in {
      check(Not(And(Variable("X"), GreaterThan(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(1))))), new TypeEnvironment(env = Map("X" -> BooleanType()))) must beRight(BooleanType())
    }
  }

  "literals" should {
    "type check on booleans" in {
      check(Literal(BooleanType(), BooleanValue(true)), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on numbers" in {
      check(Literal(NumberType(), NumberValue(10)), new TypeEnvironment()) must beRight(NumberType())
    }

    "type check on strings" in {
      check(Literal(StringType(), StringValue("Test")), new TypeEnvironment()) must beRight(StringType())
    }
  }

  "or expressions" should {
    "type check on booleans" in {
      check(Or(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(Or(Or(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on other types" in {
      check(Or(Literal(StringType(), StringValue("Test")), Literal(NumberType(), NumberValue(100))), new TypeEnvironment()) must beLeft
    }
  }

  "and expressions" should {
    "type check on booleans" in {
      check(And(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(And(And(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on other types" in {
      check(And(Literal(StringType(), StringValue("Test")), Literal(NumberType(), NumberValue(100))), new TypeEnvironment()) must beLeft
    }
  }

  "not expressions" should {
    "type check on booleans" in {
      check(Not(Literal(BooleanType(), BooleanValue(true))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on other types" in {
      check(Not(Literal(StringType(), StringValue(""))), new TypeEnvironment())  must beLeft
    }
  }

  "equal expressions" should {
    "type check on booleans" in {
      check(Equal(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(true))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on numbers" in {
      check(Equal(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on strings" in {
      check(Equal(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      check(Equal(Literal(StringType(), StringValue("")), Literal(BooleanType(), BooleanValue(true))), new TypeEnvironment()) must beLeft
    }
  }

  "not equal expressions" should {
    "type check on booleans" in {
      check(NotEqual(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(true))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on numbers" in {
      check(NotEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on strings" in {
      check(NotEqual(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      check(NotEqual(Literal(StringType(), StringValue("")), Literal(BooleanType(), BooleanValue(true))), new TypeEnvironment()) must beLeft
    }
  }

  "less than expressions" should {
    "type check on numbers" in {
      check(LessThan(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(LessThan(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(LessThan(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "less than or equal expressions" should {
    "type check on numbers" in {
      check(LessThanEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(LessThanEqual(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(LessThanEqual(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "greater than expressions" should {
    "type check on numbers" in {
      check(GreaterThan(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(GreaterThan(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(GreaterThan(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "greater than or equal expressions" should {
    "type check on numbers" in {
      check(GreaterThanEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(GreaterThanEqual(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(GreaterThanEqual(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "addition expressions" should {
    "type check on 1 + 1" in {
      check(Add(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(NumberType())
    }

    "type check on 2 + 2 + 2" in {
      check(Add(Literal(NumberType(), NumberValue(2)), Add(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(2)))), new TypeEnvironment()) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Add(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(Add(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "subtraction expressions" should {
    "type check 1 - 1" in {
      check(Sub(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Sub(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(Sub(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "multiplication expressions" should {
    "type check on 1 * 1" in {
      check(Mul(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Mul(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(Mul(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "division expressions" should {
    "type check on 1 / 1" in {
      check(Div(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), new TypeEnvironment()) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Div(Literal(StringType(), StringValue("")), Literal(StringType(), StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(Div(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "variable expressions" should {
    "lookup integers" in {
      check(Variable("X"), new TypeEnvironment(env = Map("X" -> NumberType()))) must beRight(NumberType())
    }

    "lookup strings" in {
      check(Variable("X"), new TypeEnvironment(env = Map("X" -> StringType()))) must beRight(StringType())
    }

    "lookup booleans" in {
      check(Variable("X"), new TypeEnvironment(env = Map("X" -> BooleanType()))) must beRight(BooleanType())
    }
  }

  "type checker" should {
    "detect duplicate question declarations" in {
      check(Question(BooleanType(), Variable("X"), "label", None), new TypeEnvironment(env = Map("X" -> BooleanType()))) must beLeft
    }
  }
}
