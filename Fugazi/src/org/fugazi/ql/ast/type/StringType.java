package org.fugazi.ql.ast.type;

public class StringType extends Type {

    public StringType() {
        super();
    }
    public StringType(int _lineNum) {
        super(_lineNum);
    }

    @Override
    public String toString() {
        return "String";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visitStringType(this);
    }
}