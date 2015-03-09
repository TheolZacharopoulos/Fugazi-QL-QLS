package com.klq.ast.impl.expr.math;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.ABinaryExprNode;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class AddNode extends ABinaryExprNode {

    public AddNode(ANode leftChild, ANode rightChild, String location) {
        super(leftChild, rightChild, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}