package org.uva.ql.ast.expression.binary;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class Multiply extends Binary {

	public Multiply(Expression left, Expression right, CodePosition pos) {
		super(left, right, pos);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.left.toString() + " * " + this.right.toString();
	}
	
	@Override
	public Type getType(TypeChecker typeChecker) {
		return new IntType();
	}
	
}
