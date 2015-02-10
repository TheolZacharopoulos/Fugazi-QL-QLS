/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;
import org.sablecc.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class AIgnTokens extends PIgnTokens
{
    private final LinkedList<TId> _listId_ = new LinkedList<TId>();

    public AIgnTokens()
    {
        // Constructor
    }

    public AIgnTokens(
        @SuppressWarnings("hiding") List<?> _listId_)
    {
        // Constructor
        setListId(_listId_);

    }

    @Override
    public Object clone()
    {
        return new AIgnTokens(
            cloneList(this._listId_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIgnTokens(this);
    }

    public LinkedList<TId> getListId()
    {
        return this._listId_;
    }

    public void setListId(List<?> list)
    {
        for(TId e : this._listId_)
        {
            e.parent(null);
        }
        this._listId_.clear();

        for(Object obj_e : list)
        {
            TId e = (TId) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._listId_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._listId_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._listId_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<TId> i = this._listId_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((TId) newChild);
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
