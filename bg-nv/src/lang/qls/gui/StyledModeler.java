package lang.qls.gui;

import lang.ql.ast.statement.CalculatedQuestion;
import lang.ql.ast.statement.IfCondition;
import lang.ql.ast.statement.Question;
import lang.ql.gui.GuiElement;
import lang.ql.gui.SimpleModeler;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.segment.Segment;
import lang.ql.semantics.Flat;
import lang.qls.ast.*;
import lang.qls.ast.statement.*;

import java.util.*;

/**
 * Created by Nik on 10-3-15.
 */
// TODO
public class StyledModeler extends SimpleModeler implements StylesheetVisitor<Segment>, StatementVisitor<Segment>
{
    private Map<String, GuiElement> elems;
    private final Stylesheet stylesheet;

    public StyledModeler(Stylesheet stylesheet)
    {
        super();
        this.stylesheet = stylesheet;
    }

    @Override
    public Canvas model(Flat flat)
    {
        //TODO: get the renderables!
        Collection<Renderable> renderables = Collections.emptyList();

        List<Segment> segments = new ArrayList<>();
        for (Renderable r : renderables)
        {
            // TODO: create a renderable visitor?
            // segments.add(r.accept(this));
        }
        return null;
    }

    @Override
    public Segment visit(Question q)
    {
        return null;
    }

    @Override
    public Segment visit(CalculatedQuestion q)
    {
        return null;
    }

    @Override
    public Segment visit(IfCondition c)
    {
        return null;
    }

    @Override
    public Segment visit(Section s)
    {
        return null;
    }

    private Segment visitRend(RenderableParent r)
    {
        return null;
    }

    @Override
    public Segment visit(lang.qls.ast.statement.Question q)
    {
        return null;
    }

    @Override
    public Segment visit(QuestionWithRules q)
    {
        return null;
    }

    @Override
    public Segment visit(DefaultStat d)
    {
        return null;
    }

    @Override
    public Segment visit(Stylesheet s)
    {
        return null;
    }

    @Override
    public Segment visit(Page p)
    {
        return null;
    }
}