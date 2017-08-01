package org.fugazi.ql.ast.expression.comparison.equality;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.comparison.Comparison;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;

import java.util.Arrays;
import java.util.List;

abstract class Equality extends Comparison {

    Equality(Expression _left, Expression _right) {
        super(_left, _right);
    }

    public List<Type> getSupportedTypes() {
        return Arrays.asList(
            new BoolType(),
            new IntType(),
            new StringType()
        );
    }
}
