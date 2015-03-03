package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxWidget implements IWidget {
    private JCheckBox checkbox;

    @Override
    public Component getWidget() {
        return checkbox;
    }

    public CheckboxWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter) {
        this.checkbox = new JCheckBox();

        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                headlessFormInterpreter.setField(question.getFieldName(), new BoolValue(checkbox.isSelected()));
                headlessFormInterpreter.interpret();
            }
        });
    }
}
