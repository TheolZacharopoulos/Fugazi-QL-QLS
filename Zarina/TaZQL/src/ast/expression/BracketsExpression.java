package ast.expression;

import ast.unary.UnaryExpression;

public class BracketsExpression extends UnaryExpression {

	public BracketsExpression (Expression expression) {
		super(expression);
	}
			
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString(){
		return "(" + this.getUnaryExpression().toString() + ")";
	}
}