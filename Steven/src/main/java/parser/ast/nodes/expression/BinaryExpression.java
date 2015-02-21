package parser.ast.nodes.expression;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class BinaryExpression extends Expression {

    private final Expression left;
    private final Expression right;

    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}