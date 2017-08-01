package org.fugazi.ql.ast.expression.comparison.ordering;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.IExpressionVisitor;

public class Less extends Ordering {

    public Less(Expression _left, Expression _right) {
        super(_left, _right);
    }

    @Override
    public String toString() {
        return this.getLeft().toString() + " < " + this.getRight().toString();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitLesser(this);
    }
}