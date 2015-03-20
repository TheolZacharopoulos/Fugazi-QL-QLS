package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.gui.ModelVisitor;
import ql.semantics.values.BoolValue;
import ql.semantics.values.UndefValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 10-3-15.
 */
public class CheckBox extends ControlElement implements BoolControl
{
    javafx.scene.control.CheckBox checkBox;

    public CheckBox(Boolean visible, Boolean disabled)
    {
        super(visible, disabled);
        this.checkBox = new javafx.scene.control.CheckBox();
        this.setVisible(visible);
        this.setDisabled(disabled);
    }

    @Override
    public Node getControlNode()
    {
        return this.checkBox;
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        this.checkBox.setDisable(disabled);
    }

    @Override
    public void setVisible(Boolean visible)
    {
        this.checkBox.setVisible(visible);
        this.checkBox.setManaged(visible);
    }

    @Override
    public void setValue(Value value)
    {
        value.accept(this);
    }

    @Override
    public Void visit(BoolValue val)
    {
        this.setSelected(val.getValue());
        return null;
    }

    @Override
    public Void visit(UndefValue val)
    {
        this.setSelected(false);
        return null;
    }


    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public void addListener(ChangeListener listener)
    {
        this.checkBox.selectedProperty().addListener(listener);
    }

    private void setSelected(Boolean selected)
    {
        this.checkBox.setSelected(selected);
    }
}