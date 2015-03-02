package org.uva.ql.ast.expression.association;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.ql.visitor.Visitor;

public class Parenthese extends Expression{

	private final Expression expr;
	
	public Parenthese(Expression expr, CodePosition pos) {
		super(pos);
		this.expr = expr;
	}

	public Expression getExpression() {
		return expr;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return " ( " + expr.toString() + " ) ";
	}

	@Override
	public Type getType(TypeChecker typeChecker) {
		return expr.getType(typeChecker);
	}

}