package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class QLSCheckBox extends AbstractQLSWidget {

    private JCheckBox component;

    public QLSCheckBox() {
        this.component = new JCheckBox();
    }

    public QLSCheckBox(String _label) {
        this.label = _label;
        this.component = new JCheckBox(label);
    }

    @Override
    public void setLabel(String _label) {
        this.label = _label;
        this.component.setText(label);
    }

    @Override
    public void applyStyle(Style _style) {
        this.style = _style;

        // inherit properties that are not set in the given style from default.
        this.style.inheriteFromStyle(this.getDefaultStyle());

        // todo
    }

    @Override
    public JComponent getJComponent() {
        return component;
    }

    @Override
    public void addEventListener(EventListener _listener) {
        component.addItemListener((ItemListener)_listener);
    }

    @Override
    public BoolValue getValue() {
        return new BoolValue(this.component.isSelected());
    }

    @Override
    public void setValue(ExpressionValue _value) {
        BoolValue value = (BoolValue) _value;
        this.component.setSelected(value.getValue());
    } 
    
    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.component.setEnabled(false);
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitCheckBox(this);
    }
}
