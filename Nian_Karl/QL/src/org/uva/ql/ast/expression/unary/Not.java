package org.uva.ql.ast.expression.unary;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.visitor.Visitor;

public class Not extends Unary {

	public Not(Expression expr,CodePosition pos) {
		super(expr,pos);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "!" + this.expr.toString();
	}
}
