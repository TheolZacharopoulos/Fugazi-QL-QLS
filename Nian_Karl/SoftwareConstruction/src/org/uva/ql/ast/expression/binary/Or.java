package org.uva.ql.ast.expression.binary;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class Or extends Binary {

	public Or(Expression left, Expression right, CodePosition pos) {
		super(left, right, pos);
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.left.toString() + " || " + this.right.toString();
	}

	@Override
	public Type getType(TypeChecker typeChecker) {
		return new BoolType(getPosition());
	}
	
}
