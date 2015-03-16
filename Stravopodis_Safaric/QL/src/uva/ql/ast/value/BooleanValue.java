package uva.ql.ast.value;

import uva.ql.ast.type.TypeBoolean;


public class BooleanValue extends GenericValue<Boolean> {

	private boolean value;
	
	public BooleanValue(boolean _value){
		this.value = _value;
	}
	
	public BooleanValue and(BooleanValue value){
		return new BooleanValue(this.value && value.value);
	}
	public BooleanValue or(BooleanValue value){
		return new BooleanValue(this.value || value.value);
	}
	
	@Override
	public Boolean getValue() {
		return this.value;
	}

	@Override
	public TypeBoolean getValueType() {
		return new TypeBoolean();
	}

	@Override
	public boolean equalsTo(GenericValue<?> value) {
		if (value == null){
			return false;
		}
		return value.getValue() == this.getValue();
	}

}
