package edu.parser.QLS.nodes.styles;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Widget extends Style {

    public Widget(String style) {
        super(style);
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.accept(this);
    }
}