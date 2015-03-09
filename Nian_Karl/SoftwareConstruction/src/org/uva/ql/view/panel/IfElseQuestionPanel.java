package org.uva.ql.view.panel;

import java.util.ArrayList;

import org.uva.ql.ast.expression.Expression;

public class IfElseQuestionPanel extends IfQuestionPanel {

	private static final long serialVersionUID = -4507161988032536469L;

	private final ArrayList<Panel> elseBlockPanels;

	public IfElseQuestionPanel(ArrayList<Panel> ifBlockPanels, ArrayList<Panel> elseBlockPanels, Expression expr) {
		super(ifBlockPanels, expr);
		this.elseBlockPanels = elseBlockPanels;
		initializeBlock(this.elseBlockPanels);
	}

	@Override
	public void toggleIfBlock(boolean show) {
		super.toggleIfBlock(show);
		if (elseBlockPanels != null) {
			for (Panel panel : elseBlockPanels) {
				panel.setVisible(!show);
			}
		}
	}

	public ArrayList<Panel> getElseBlockPanels() {
		return elseBlockPanels;
	}
}