package org.fugazi.ql.ast.expression.comparison;

import org.fugazi.ql.ast.expression.Binary;
import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.Type;

import java.util.List;

public abstract class Comparison extends Binary {

    public Comparison(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public Type getReturnedType(QLFormDataStorage _formData) {
        return new BoolType();
    }

    public abstract List<Type> getSupportedTypes();
}