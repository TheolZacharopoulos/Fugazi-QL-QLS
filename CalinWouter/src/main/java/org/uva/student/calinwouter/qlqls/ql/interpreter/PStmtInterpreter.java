package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.LinkedList;

public class PStmtInterpreter extends AnalysisAdapter {
    private final VariableTable oldVariableTable;
    private final VariableTable newVariableTable;
    private final PExpInterpreter expInterpreter;
    private final StaticFields staticFields;

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        String nodeIdent = node.getIdent().getText();
        if(oldVariableTable.isSet(nodeIdent))
            newVariableTable.setVariable(nodeIdent, oldVariableTable.getVariable(nodeIdent));
        else {
            Value value = staticFields.getTypeOfField(nodeIdent).getDefaultValue();
            newVariableTable.setVariable(nodeIdent, value);
        }
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        String nodeIdent = node.getIdent().getText();
        if(oldVariableTable.isSet(nodeIdent)) {
            node.getExp().apply(expInterpreter);
            newVariableTable.setVariable(nodeIdent, expInterpreter.popValue());
        } else {
            Value value = staticFields.getTypeOfField(node.getIdent().getText()).getDefaultValue();
            newVariableTable.setVariable(node.getIdent().getText(), value);
        }
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        node.getExp().apply(expInterpreter);
        if (((BoolValue) expInterpreter.popValue()).isTrue()) {
            executeStatements(node.getThenStmtList());
            return;
        }
        executeStatements(node.getElseStmtList());
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        node.getExp().apply(expInterpreter);
        if (expInterpreter.popValue().getValue() == Boolean.TRUE) {
            executeStatements(node.getThenStmtList());
        }
    }

    private void executeStatements(LinkedList<PStmt> stmtList) {
        for (PStmt s : stmtList) {
            s.apply(this);
        }
    }

    public PStmtInterpreter(VariableTable oldVariableTable, VariableTable newVariableTable, StaticFields staticFields) {
        this.expInterpreter = new PExpInterpreter(oldVariableTable, newVariableTable);
        this.oldVariableTable = oldVariableTable;
        this.newVariableTable = newVariableTable;
        this.staticFields = staticFields;
    }
}