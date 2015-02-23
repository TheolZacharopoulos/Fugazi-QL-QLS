package org.uva.sea.ql.AST.expression;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.value.AbstractValue;
import org.uva.sea.ql.AST.visitor.Visitor;


public abstract class Expression extends Node{	
	public abstract AbstractValue<?> interpretExpression();
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}