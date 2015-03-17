package nl.uva.bromance.ast;


import nl.uva.bromance.ast.conditionals.CanContainConditionals;
import nl.uva.bromance.ast.conditionals.ElseIfStatement;
import nl.uva.bromance.ast.conditionals.ElseStatement;
import nl.uva.bromance.ast.conditionals.IfStatement;
import nl.uva.bromance.ast.visitors.NodeVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Label extends QLNode implements CanContainConditionals {
    private String identifier;

    private IfStatement ifStatement;
    private List<ElseIfStatement> elseIfStatements = new ArrayList<>();
    private ElseStatement elseStatement;

    public Label(int lineNumber, String id) {
        super(lineNumber, Label.class);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1); // Remove double brackets around id
        } else {
            //TODO: Consider putting this in the typechecker.
            System.err.println("Label Error: No identifier specified");
        }
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Label] { Name : " + this.identifier + " }\n");
        for (QLNode n : getChildren()) {
            n.printDebug(i + 1);
        }
    }

    @Override
    public Optional<IfStatement> getIfsStatement() {
        return Optional.of(ifStatement);
    }

    public void setIfStatement(IfStatement ifStatement) {
        this.ifStatement = ifStatement;
    }

    @Override
    public Optional<List<ElseIfStatement>> getElseIfStatement() {
        return Optional.of(elseIfStatements);
    }

    @Override
    public void setElseIfStatement(ElseIfStatement eifs) {
        elseIfStatements.addAll(Arrays.asList(eifs));
    }

    @Override
    public Optional<ElseStatement> getElseStatement() {
        return Optional.of(elseStatement);
    }

    @Override
    public void setElseStatement(ElseStatement es) {
        elseStatement = es;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
        for(QLNode child: this.getChildren()) {
            child.accept(visitor);
        }
    }
}
