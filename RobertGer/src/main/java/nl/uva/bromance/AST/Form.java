package nl.uva.bromance.AST;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nl.uva.bromance.typechecking.TypeCheckingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Form extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<Class<? extends Node>>(Arrays.asList(Questionnaire.class));
    private String identifier;

    public Form(int lineNumber, String id) {
        super(lineNumber, Form.class);
        this.setAcceptedParents(parentsAllowed);
        if (id != null) {
            this.identifier = id;
        } else {
            System.err.println("Form Error: No identifier specified");
        }
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Form] { Name : " + this.identifier + " }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }

    }

    @Override
    public Pane visualize(Pane parent) {

        VBox newParent = new VBox();
        Label label = new Label("Form: " + this.identifier);
        label.setStyle("-fx-font-weight: bold;");
        newParent.getChildren().add(label);
        newParent.setStyle("-fx-border-color: #000000; -fx-border-style: solid;");
        parent.getChildren().add(newParent);

        return newParent;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void typeCheck(Map<String, Node> references) throws TypeCheckingException {
        if (references.get(getIdentifier()) == null) {
            references.put(getIdentifier(), this);
        } else {
            throw new TypeCheckingException.AlreadyDefinedTypeCheckingException(this, getIdentifier());
        }
    }
}
