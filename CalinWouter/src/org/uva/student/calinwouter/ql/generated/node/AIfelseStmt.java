/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.ql.generated.node;

import java.util.*;
import org.uva.student.calinwouter.ql.generated.analysis.*;

@SuppressWarnings("nls")
public final class AIfelseStmt extends PStmt
{
    private PExp _exp_;
    private final LinkedList<PStmt> _thenStmtList_ = new LinkedList<PStmt>();
    private final LinkedList<PStmt> _elseStmtList_ = new LinkedList<PStmt>();

    public AIfelseStmt()
    {
        // Constructor
    }

    public AIfelseStmt(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") List<?> _thenStmtList_,
        @SuppressWarnings("hiding") List<?> _elseStmtList_)
    {
        // Constructor
        setExp(_exp_);

        setThenStmtList(_thenStmtList_);

        setElseStmtList(_elseStmtList_);

    }

    @Override
    public Object clone()
    {
        return new AIfelseStmt(
            cloneNode(this._exp_),
            cloneList(this._thenStmtList_),
            cloneList(this._elseStmtList_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIfelseStmt(this);
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public LinkedList<PStmt> getThenStmtList()
    {
        return this._thenStmtList_;
    }

    public void setThenStmtList(List<?> list)
    {
        for(PStmt e : this._thenStmtList_)
        {
            e.parent(null);
        }
        this._thenStmtList_.clear();

        for(Object obj_e : list)
        {
            PStmt e = (PStmt) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._thenStmtList_.add(e);
        }
    }

    public LinkedList<PStmt> getElseStmtList()
    {
        return this._elseStmtList_;
    }

    public void setElseStmtList(List<?> list)
    {
        for(PStmt e : this._elseStmtList_)
        {
            e.parent(null);
        }
        this._elseStmtList_.clear();

        for(Object obj_e : list)
        {
            PStmt e = (PStmt) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._elseStmtList_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._thenStmtList_)
            + toString(this._elseStmtList_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._thenStmtList_.remove(child))
        {
            return;
        }

        if(this._elseStmtList_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        for(ListIterator<PStmt> i = this._thenStmtList_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStmt) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PStmt> i = this._elseStmtList_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStmt) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
