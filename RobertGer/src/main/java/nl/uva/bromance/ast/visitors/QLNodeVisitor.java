package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.conditionals.ElseIfStatement;
import nl.uva.bromance.ast.conditionals.ElseStatement;
import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.conditionals.IfStatement;

/**
 * Created by Robert on 16-3-2015.
 */
public interface QLNodeVisitor {

    void visit(Calculation calculation);
    void visit(Form form);
    void visit(Input input);
    void visit(Label label);
    void visit(LabelText labelText);
    void visit(Question question);
    void visit(Questionnaire questionnaire);
    void visit(IfStatement ifStatement);
    void visit(ElseIfStatement elseIfStatement);
    void visit(ElseStatement elseStatement);
    void visit(Expression expression);
}
