package com.klq.ast.impl.expr.literal;

import com.klq.ast.impl.Location;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.BooleanValue;
import com.klq.ast.impl.expr.value.Value;

import java.util.Map;

/**
 * Created by Timon on 03.03.2015.
 */
public class BooleanNode extends AExpression{
    private final boolean value;

    public BooleanNode(boolean value, Location location) {
        super(location);
        this.value = value;
    }

    public BooleanNode(boolean value) {
        this.value = value;
    }

    @Override
    public Value evaluate(Map<String, Value> variables) {
        return new BooleanValue(value);
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    //TODO remove class?!
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BooleanNode){
            return ((BooleanNode)obj).value == this.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean getValue(){
        return value;
    }
}