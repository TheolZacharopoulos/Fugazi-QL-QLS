package nl.uva.sc.encoders.ql.ast.expression;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.operator.UnaryOperator;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

public class UnaryExpression extends Expression {

	private final UnaryOperator operator;

	private final Expression expression;

	public UnaryExpression(TextLocation textLocation, UnaryOperator operator, Expression expression) {
		super(textLocation);
		this.operator = operator;
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	public UnaryOperator getOperator() {
		return operator;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
