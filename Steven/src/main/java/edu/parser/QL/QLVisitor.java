package edu.parser.QL;

import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.expression.Identifier;
import edu.parser.QL.nodes.question.Label;
import edu.parser.QL.nodes.question.QLQuestion;
import edu.parser.QL.nodes.statement.ElseClause;
import edu.parser.QL.nodes.statement.IfStatement;
import edu.parser.QL.nodes.statement.Statement;
import edu.parser.QL.nodes.type.Boolean;
import edu.parser.QL.nodes.type.Number;
import edu.nodes.QuestionType;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public interface QLVisitor {

    AbstractNode visit(Form form);

    AbstractNode visit(IfStatement ifStatement);

    AbstractNode visit(QLQuestion question);

    AbstractNode visit(edu.parser.QL.nodes.expression.Addition addition);

    AbstractNode visit(edu.parser.QL.nodes.expression.And and);

    AbstractNode visit(edu.parser.QL.nodes.expression.Equal equal);

    AbstractNode visit(edu.parser.QL.nodes.expression.GreaterOrEqual greaterOrEqual);

    AbstractNode visit(edu.parser.QL.nodes.expression.GreaterThan greaterThan);

    AbstractNode visit(Identifier identifier);

    AbstractNode visit(edu.parser.QL.nodes.expression.LessOrEqual lessOrEqual);

    AbstractNode visit(edu.parser.QL.nodes.expression.LessThan lessThan);

    AbstractNode visit(edu.parser.QL.nodes.expression.Multiplication multiplication);

    AbstractNode visit(edu.parser.QL.nodes.expression.Not not);

    AbstractNode visit(edu.parser.QL.nodes.expression.NotEqual notEqual);

    AbstractNode visit(edu.parser.QL.nodes.expression.Or or);

    AbstractNode visit(Statement statement);

    AbstractNode visit(Boolean aBoolean);

    AbstractNode visit(Number number);

    AbstractNode visit(Label label);

    AbstractNode visit(ElseClause elseClause);

    AbstractNode visit(edu.parser.QL.nodes.expression.Division division);

    AbstractNode visit(QuestionType questionType);
}