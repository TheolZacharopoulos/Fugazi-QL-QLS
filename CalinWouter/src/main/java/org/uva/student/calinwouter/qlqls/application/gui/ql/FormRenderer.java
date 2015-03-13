package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.interpreter.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.model.FormField;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;


public class FormRenderer extends AnalysisAdapter {
    private FormInterpreter formInterpreter;
    private FormTypeChecker formTypeChecker;
    private JFrame frame;
    private JPanel framePanel;

    public FormRenderer(FormInterpreter formInterpreter, FormTypeChecker formTypeChecker) {
        this.formInterpreter = formInterpreter;
        this.formTypeChecker = formTypeChecker;
    }

    public void renderStatements(LinkedList<PStmt> statements) {
        for (PStmt stmt : statements) {
            StatementRenderer stmtRenderer = new StatementRenderer(formInterpreter, formTypeChecker);
            stmt.apply(stmtRenderer);
            framePanel.add(stmtRenderer.getWidget());
        }
    }

    public void render() {

        List<FormField> fields = formInterpreter.getFields();
        System.out.println("Current fields: " + fields.size());
        for (FormField f: fields) {
            System.out.println(f.getVariable());
        }
        final AForm form = formInterpreter.getForm();
        frame = new JFrame(form.getIdent().getText());
        frame.setPreferredSize(new Dimension(800, 600));
        framePanel = new JPanel();
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                frame.repaint();
                frame.revalidate();
            }
        });

        renderStatements(form.getStmt());

        frame.getContentPane().add(framePanel);

        frame.pack();
        frame.setVisible(true);
    }
}