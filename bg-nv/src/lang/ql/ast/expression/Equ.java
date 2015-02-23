package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 17/02/15.
 */
public class Equ extends BinaryExpr
{
    public Equ(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}