package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class Sub extends BinaryExpr
{
    public Sub(Expr left, Expr right)
    {
        super(left, right);
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
