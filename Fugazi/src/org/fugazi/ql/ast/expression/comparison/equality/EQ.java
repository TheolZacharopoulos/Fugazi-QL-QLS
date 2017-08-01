package org.fugazi.ql.ast.expression.comparison.equality;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.IExpressionVisitor;

public class EQ extends Equality {

    public EQ(Expression _left, Expression _right) {
        super(_left, _right);
    }
    
    @Override
    public String toString() {
        return this.getLeft().toString() + "==" + this.getRight().toString();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitEQ(this);
    }
}