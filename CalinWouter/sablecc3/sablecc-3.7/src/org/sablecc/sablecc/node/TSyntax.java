/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TSyntax extends Token {
    public TSyntax() {
        super.setText("Syntax");
    }

    public TSyntax(int line, int pos) {
        super.setText("Syntax");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone() {
        return new TSyntax(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw) {
        ((Analysis) sw).caseTSyntax(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text) {
        throw new RuntimeException("Cannot change TSyntax text.");
    }
}
