package ql.gui.segment;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import ql.gui.ModelVisitor;

import java.util.List;

/**
 * Created by Nik on 10-3-15.
 */
public class Section extends Segment<Node>
{
    public Section(List<Segment> subsegments, Boolean visible)
    {
        super(new GridPane(), subsegments, visible);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return null;
    }
}
