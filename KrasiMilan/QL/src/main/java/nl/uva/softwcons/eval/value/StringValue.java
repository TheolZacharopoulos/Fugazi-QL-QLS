package nl.uva.softwcons.eval.value;

public class StringValue extends Value<String> {

    private final String stringValue;

    public StringValue(String value) {
        this.stringValue = value;
    }

    @Override
    public BooleanValue isEqual(Value otherValue) {
        return new BooleanValue(this.stringValue != null && this.stringValue.equals((String) otherValue.getValue()));
    }

    @Override
    public String getValue() {
        return this.stringValue;
    }
}
