package org.fugazi.ql.ast.expression.comparison.ordering;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.comparison.Comparison;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.Type;

import java.util.Collections;
import java.util.List;

abstract class Ordering extends Comparison {

    Ordering(Expression _left, Expression _right) {
        super(_left, _right);
    }

    public List<Type> getSupportedTypes() {
        return Collections.singletonList(new IntType());
    }
}
