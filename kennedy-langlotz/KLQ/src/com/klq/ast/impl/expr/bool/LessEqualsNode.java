package com.klq.ast.impl.expr.bool;

import com.klq.ast.impl.Location;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.*;

import java.util.Map;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class LessEqualsNode extends ABooleanNode {

    public LessEqualsNode(AExpression leftChild, AExpression rightChild, Location location) {
        super(leftChild, rightChild, location);
    }

    public LessEqualsNode(AExpression leftChild, AExpression rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<String, Value> variables) {
        ComparableValue left = (ComparableValue)(getLeftChild().evaluate(variables));
        ComparableValue right = (ComparableValue)(getRightChild().evaluate(variables));

        if(anyUndefined(left, right))
        {
            return new UndefinedValue();
        }
        else {
            return new BooleanValue(left.compareTo(right) <= 0);
        }
    }
}
