/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.qlqls.generated.node;

import org.uva.student.calinwouter.qlqls.generated.analysis.*;

@SuppressWarnings("nls")
public final class TTfalse extends Token
{
    public TTfalse()
    {
        super.setText("false");
    }

    public TTfalse(int line, int pos)
    {
        super.setText("false");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTfalse(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTfalse(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTfalse text.");
    }
}
