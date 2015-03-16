package org.fugazi.qls.ast.style;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.widget.AbstractQLSWidget;

public class DefaultStyleDeclaration extends AbstractASTNode {

    private final Style style;
    private final AbstractQLSWidget widget;
    private final Type questionType;

    public DefaultStyleDeclaration(
            Style _style, AbstractQLSWidget _widget, Type _questionType)
    {
        this.style = _style;
        this.widget = _widget;
        this.questionType = _questionType;
    }

    public Style getStyle() {
        return this.style;
    }

    public AbstractQLSWidget getWidget() {
        return widget;
    }

    public Type getQuestionType() {
        return questionType;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitDefaultStyleDeclr(this);
    }

    @Override
    public boolean equals(Object o){
        if (o == null) {
            return false;
        }

        if (!(o instanceof DefaultStyleDeclaration)) {
            return false;
        }

        DefaultStyleDeclaration other = (DefaultStyleDeclaration) o;
        return (this.questionType.toString() == other.questionType.toString());
    }
}