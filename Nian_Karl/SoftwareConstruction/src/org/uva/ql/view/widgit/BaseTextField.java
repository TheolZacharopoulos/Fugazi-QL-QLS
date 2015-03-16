package org.uva.ql.view.widgit;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.text.DocumentFilter;

import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.type.UndefinedType;
import org.uva.ql.ast.value.Value;
import org.uva.ql.view.listener.WidgetListener;

public abstract class BaseTextField extends Widget {

	protected final JTextField textField;
	protected DocumentFilter documentFilter;

	public BaseTextField(WidgetListener listener) {
		this.documentFilter = new DocumentFilter();
		this.textField = new JTextField();
		textField.setPreferredSize(new Dimension(100, 25));
		textField.setVisible(true);
	}

	@Override
	public JTextField getWidget() {
		return textField;
	}

	@Override
	public void setWidgetValue(Value value, Type type) {
		if (!type.isEqual(new UndefinedType())) {
			getWidget().setText(value.toString());
		}
	}

	public void setForegroundColor(Color color) {
		getWidget().setForeground(color);

	}
}