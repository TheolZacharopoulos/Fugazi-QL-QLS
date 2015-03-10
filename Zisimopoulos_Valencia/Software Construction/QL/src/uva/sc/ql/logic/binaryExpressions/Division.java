package uva.sc.ql.logic.binaryExpressions;

import uva.sc.ql.ast.INodeVisitor;
import uva.sc.ql.logic.Expression;

public class Division extends BinaryExpression {

	public Division(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}

	public String toString() {
		return "[op /]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
