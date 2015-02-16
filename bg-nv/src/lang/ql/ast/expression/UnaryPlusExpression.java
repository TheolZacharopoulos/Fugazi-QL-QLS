package lang.ql.ast.expression;

import lang.ql.ast.visitor.Visitor;

/**
 * Created by bore on 14/02/15.
 */
public class UnaryPlusExpression extends UnaryOperatorExpression
{
    public UnaryPlusExpression(Expression operand)
    {
        super(operand);
    }

    public void visit(Visitor visitor)
    {
        visitor.visit(this);
    }
}
