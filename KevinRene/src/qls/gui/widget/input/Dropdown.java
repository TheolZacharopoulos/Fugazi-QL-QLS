package qls.gui.widget.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import ql.gui.DefaultChangeHandler;
import ql.value.BooleanValue;
import ql.value.StringValue;
import qls.ast.statement.styling.StyleProperties;
import qls.ast.statement.styling.property.Font;
import qls.gui.widget.InputWidget;

public class Dropdown extends DefaultChangeHandler implements InputWidget<BooleanValue>, ActionListener {
	protected JComboBox<String> comboBox;
	private String[] labels;
	
	public Dropdown(StringValue tru, StringValue fls) {
		labels = new String[]{tru.getValue(), fls.getValue()};
		
		comboBox = new JComboBox<String>(labels);
		comboBox.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		handleChange(getValue(), this);
	}

	@Override
	public void disable() {
		comboBox.setEnabled(false);
	}

	@Override
	public void setValue(BooleanValue value) {
		comboBox.setSelectedItem(value.toString());
	}

	@Override
	public BooleanValue getValue() {
		switch (comboBox.getSelectedIndex()) {
			case 0 : return new BooleanValue(true);
			default : return new BooleanValue(false);
		}
	}

	@Override
	public void updateComponent() {
		comboBox.repaint();
	}

	@Override
	public JComponent getComponent() {
		return comboBox;
	}

	@Override
	public void setStyle(StyleProperties properties) {
		
	}

	@Override
	public void setFont(Font font) {
		
	}
}