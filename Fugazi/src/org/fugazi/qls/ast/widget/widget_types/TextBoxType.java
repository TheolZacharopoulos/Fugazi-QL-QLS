package org.fugazi.qls.ast.widget.widget_types;

import org.fugazi.qls.ast.widget.IWidgetsTypeVisitor;

public class TextBoxType implements IWidgetType {

    public <T> T accept(IWidgetsTypeVisitor<T> visitor) {
        return visitor.visitTextBoxType(this);
    }
}
