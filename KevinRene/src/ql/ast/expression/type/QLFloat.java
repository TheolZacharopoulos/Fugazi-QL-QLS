package ql.ast.expression.type;

import ql.ast.expression.QLType;
import ql.ast.visitor.ExpressionVisitor;

public class QLFloat extends QLNumeric {
	public QLFloat() {}
	
	@Override
	public QLType getType() {
		return new QLFloat();
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}