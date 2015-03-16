package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.ContainsExpression;
import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.NodeVisitor;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Input extends QLNode implements ContainsExpression {
    private Expression expression;

    public Input(int lineNumber) {
        super(lineNumber, Input.class);
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void handleExpressionResult() {

    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
        for(QLNode child: this.getChildren()) {
            child.accept(visitor);
        }
    }
}
