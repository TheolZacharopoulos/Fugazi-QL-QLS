package org.uva.student.calinwouter.qlqls.ql.staticfieldscollector;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;

public class PFormStaticFieldsCollector extends AnalysisAdapter {
    private final PStmtStaticFieldsCollector pStmtStaticFieldsCollector;

    @Override
    public void caseAForm(final AForm node) {
        for (PStmt stmt : node.getStmt()) {
            stmt.apply(pStmtStaticFieldsCollector);
        }
    }

    public PFormStaticFieldsCollector(StaticFields staticFields) {
        this.pStmtStaticFieldsCollector = new PStmtStaticFieldsCollector(staticFields);
    }
}
