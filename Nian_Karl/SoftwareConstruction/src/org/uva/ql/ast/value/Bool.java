package org.uva.ql.ast.value;

import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.Type;


public class Bool extends Value{
	
	private final Boolean value;
	
	public Bool(Boolean value) {
		this.value = value;
	}

	@Override
	public Boolean getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public Value not() {
		return new Bool(!getValue());
	}
	
	@Override
	public Value and(Value arg) {
		return arg.boolAnd(this);
	}
	
	@Override
	public Value boolAnd(Bool arg) {
		return new Bool(arg.getValue() && getValue());
	}
	
	@Override
	public Value or(Value arg) {
		return arg.boolOr(this);
	}
	
	@Override
	public Value boolOr(Bool arg) {
		return new Bool(arg.getValue() || getValue());
	}
	
	@Override
	public Value equal(Value arg) {
		return arg.boolEqual(this);
	}
	
	@Override
	public Value boolEqual(Bool arg) {
		return new Bool(arg.getValue() == getValue());
	}
	
	@Override
	public Value notEqual(Value arg) {
		return arg.boolNotEqual(this);
	}
	
	@Override
	public Value boolNotEqual(Bool arg) {
		return new Bool(arg.getValue() != getValue());
	}

	@Override
	public Type getType() {
		return new BoolType();
	}

}
