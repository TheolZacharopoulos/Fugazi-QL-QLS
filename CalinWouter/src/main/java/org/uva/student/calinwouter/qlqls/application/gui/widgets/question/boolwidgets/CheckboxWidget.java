package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxWidget implements IWidget {
    private JCheckBox checkbox;

    @Override
    public Component getWidgetComponent() {
        return checkbox;
    }

    public CheckboxWidget(final String questionIdentifier, final QLInterpreter qlIntepreter, final VariableTableWrapper variableTableWrapper) {
        this.checkbox = new JCheckBox();

        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                variableTableWrapper.getVariableTable().setVariable(questionIdentifier, new BoolValue(checkbox.isSelected()));
                VariableTable newVariableTable = qlIntepreter.interpret(variableTableWrapper.getVariableTable());
                variableTableWrapper.setVariableTable(newVariableTable);
            }
        });
    }
}