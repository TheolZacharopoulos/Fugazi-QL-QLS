package lang.ql.gui.segment;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.Refreshable;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.Value;

import java.util.List;

/**
 * Created by bore on 09/03/15.
 */
public class Page extends Segment<GridPane> implements Refreshable
{
    private Integer pageNumber;

    public Page(List<Segment> subsegments, Boolean visible)
    {
        super(new GridPane(), subsegments, visible);

        this.container.setAlignment(Pos.CENTER);
        this.container.setHgap(10);
        this.container.setVgap(10);
        this.container.setStyle("-fx-background-color: white;");

        for (Segment s : subsegments)
        {
            this.container.add(s.getContainer(), 0, this.container.getChildren().size() + 1);
        }
    }

    @Override
    public void refreshElement(ValueTable valueTable)
    {
        //TODO
    }

    @Override
    public Value evaluate(ValueTable valueTable)
    {
        //TODO
        return null;
    }

    @Override
    public Boolean isRefreshPrerequisite()
    {
        return false;
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}
