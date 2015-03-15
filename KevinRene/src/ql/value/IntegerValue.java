package ql.value;

import ql.Value;

public class IntegerValue extends Value {
	private final int value;
	
	public IntegerValue(int value) {
		this.value = value;
	}
	
	@Override
	public boolean isNumeric() {
		return true;
	}

	@Override
	public Value add(Value argument) {
		return argument.addInteger(this);
	}
	
	@Override
	public Value addInteger(IntegerValue argument) {
		return new IntegerValue(argument.getValue() + getValue());
	}
	
	@Override
	public Value addFloat(FloatValue argument) {
		return new FloatValue(argument.getValue() + getValue());
	}

	@Override
	public Value addString(StringValue argument) {
		return new StringValue(argument.getValue() + getValue());
	}

	@Override
	public Value divide(Value argument) {
		return argument.divideInteger(this);
	}

	@Override
	public Value divideInteger(IntegerValue argument) {
		return new IntegerValue(argument.getValue() / getValue());
	}

	@Override
	public Value divideFloat(FloatValue argument) {
		return new FloatValue(argument.getValue() / getValue());
	}

	@Override
	public Value multiply(Value argument) {
		return argument.multiplyInteger(this);
	}

	@Override
	public Value multiplyInteger(IntegerValue argument) {
		return new IntegerValue(argument.getValue() * getValue());
	}

	@Override
	public Value multiplyFloat(FloatValue argument) {
		return new FloatValue(argument.getValue() * getValue());
	}

	@Override
	public Value subtract(Value argument) {
		return argument.subtractInteger(this);
	}

	@Override
	public Value subtractInteger(IntegerValue argument) {
		return new IntegerValue(argument.getValue() - getValue());
	}

	@Override
	public Value subtractFloat(FloatValue argument) {
		return new FloatValue(argument.getValue() - getValue());
	}

	@Override
	public Value not() {
		throw new UnsupportedOperationException("Cannot negate an IntegerValue.");
	}

	@Override
	public Value positive() {
		return new IntegerValue(getValue() < 0.0 ? getValue() * -1 : getValue());
	}

	@Override
	public Value negative() {
		return new IntegerValue(getValue() * -1);
	}

	@Override
	public Value or(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value orBoolean(BooleanValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualTo(Value argument) {
		return argument.notEqualToInteger(this);
	}

	@Override
	public Value notEqualToBoolean(BooleanValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualToInteger(IntegerValue argument) {
		return new BooleanValue(argument.getValue() != getValue());
	}

	@Override
	public Value notEqualToFloat(FloatValue argument) {
		return new BooleanValue(argument.getValue() != (float)getValue());
	}

	@Override
	public Value notEqualToString(StringValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerThan(Value argument) {
		return argument.lowerThanInteger(this);
	}

	@Override
	public Value lowerThanInteger(IntegerValue argument) {
		return new BooleanValue(argument.getValue() < getValue());
	}

	@Override
	public Value lowerThanFloat(FloatValue argument) {
		return new BooleanValue(argument.getValue() < getValue());
	}

	@Override
	public Value lowerOrEqual(Value argument) {
		return argument.lowerOrEqualInteger(this);
	}

	@Override
	public Value lowerOrEqualInteger(IntegerValue argument) {
		return new BooleanValue(argument.getValue() <= getValue());
	}

	@Override
	public Value lowerOrEqualFloat(FloatValue argument) {
		return new BooleanValue(argument.getValue() <= getValue());
	}

	@Override
	public Value greaterThan(Value argument) {
		return argument.greaterThanInteger(this);
	}

	@Override
	public Value greaterThanInteger(IntegerValue argument) {
		return new BooleanValue(argument.getValue() > getValue());
	}

	@Override
	public Value greaterThanFloat(FloatValue argument) {
		return new BooleanValue(argument.getValue() > getValue());
	}

	@Override
	public Value greaterOrEqual(Value argument) {
		return argument.greaterOrEqualThanInteger(this);
	}

	@Override
	public Value greaterOrEqualThanInteger(IntegerValue argument) {
		return new BooleanValue(argument.getValue() >= getValue());
	}

	@Override
	public Value greaterOrEqualThanFloat(FloatValue argument) {
		return new BooleanValue(argument.getValue() >= getValue());
	}

	@Override
	public Value equalTo(Value argument) {
		return argument.equalToInteger(this);
	}

	@Override
	public Value equalToBoolean(BooleanValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value equalToInteger(IntegerValue argument) {
		return new BooleanValue(argument.getValue() == getValue());
	}

	@Override
	public Value equalToFloat(FloatValue argument) {
		return new BooleanValue(argument.getValue() == (float)getValue());
	}

	@Override
	public Value equalToString(StringValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value and(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value andBoolean(BooleanValue argument) {
		throw new UnsupportedOperationException();
	}
	
	
	public Integer getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IntegerValue) {
			return getValue().equals(((IntegerValue) obj).getValue());
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return getValue().toString();
	}
}
