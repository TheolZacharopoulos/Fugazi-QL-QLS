package org.uva.ql.view.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.uva.ql.ast.value.BoolValue;
import org.uva.ql.view.widgit.CheckBox;

public class CheckBoxListener implements ItemListener {

	private final WidgetListener widgetListener;
	private final String identifier;
	private final CheckBox checkBox;

	public CheckBoxListener(WidgetListener widgetListener, String identifier, CheckBox checkbox) {
		super();
		this.checkBox = checkbox;
		this.widgetListener = widgetListener;
		this.identifier = identifier;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (checkBox.getWidget().isSelected()) {
			widgetListener.widgetValueChanged(identifier, new BoolValue(checkBox.getValue()));
		} else {
			widgetListener.widgetValueChanged(identifier, new BoolValue(checkBox.getValue()));
		}
	}
}
