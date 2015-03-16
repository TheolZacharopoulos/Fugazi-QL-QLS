package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public class BoolValue extends Value {
    public static final TypeDescriptor BOOL_VALUE_TYPE_DESCRIPTOR = new TypeDescriptor() {
        @Override
        public void callTypeMethod(final TypeCallback typeCallback) {
            typeCallback.usesBoolean();
        }

        @Override
        public BoolValue getDefaultValue() {
            return new BoolValue(false);
        }
    };

    @Override
    public Value or(Value value) {
        return new BoolValue((Boolean) getValue() || (Boolean) value.getValue());
    }

    @Override
    public Value and(Value value) {
        return new BoolValue((Boolean) getValue() && (Boolean) value.getValue());
    }

    @Override
    public Value not() {
        return new BoolValue(!(Boolean) getValue());
    }

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesBoolean();
    }

    @Override
    public Value eq(Value value) {
        return new BoolValue(value.getValue().equals(getValue()));
    }

    public Value neq(Value value) {
        return new BoolValue(!value.getValue().equals(getValue()));
    }

    public boolean isTrue() {
        return (Boolean) getValue();
    }

    public BoolValue(Boolean value) {
        super(value);
    }
}
