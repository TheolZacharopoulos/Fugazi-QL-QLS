package ql.gui.screen;

import javax.swing.JComponent;

import ql.gui.UIComponent;
import ql.gui.structure.Panel;

public abstract class Screen extends UIComponent {
	private Panel screen;
	
	public Screen() {
		screen = new Panel(this);
	}
	
	public void addScreenSection(Panel screenSection) {		
		screen.addComponent(screenSection);
		screenSection.setHandler(this);
	}
	
	public Panel getScreen() {
		return screen;
	}
	
	public void hideScreen() {
		screen.getComponent().setVisible(false);
	}
	
	public void showScreen() {
		screen.getComponent().setVisible(true);
	}
	
	@Override
	public void updateComponent() {
		screen.updateComponent();
	}

	@Override
	public JComponent getComponent() {
		return screen.getComponent();
	}
}
