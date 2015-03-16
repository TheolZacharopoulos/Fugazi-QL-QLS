package nl.uva.bromance.visualization;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.QLSNode;
import nl.uva.bromance.ast.QLSPage;
import nl.uva.bromance.util.QLFileReader;
import nl.uva.bromance.util.QLSFileReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Visualizer {
    private Stage stage;
    private Scene scene;
    private VBox rootBox, pages, questions;
    private QLSPage currentPage;
    private Map<String, String> answerMap;
    private AST<QLNode> qlAst;
    private AST<QLSNode> qlsAst;
    private Node focusedNode;
    private String focusId;

    public Visualizer(Stage stage) {
        this.stage = stage;
        this.answerMap = new HashMap<>();
    }

    public void setFocusedNode(Node node) {
        this.focusedNode = node;
    }

    public String getFocusId(){
        return focusId;
    }

    public void render() {
        stage.setScene(scene);
        stage.show();
    }

    public void setBaseView() {
        rootBox = new VBox();

        Optional<? extends Pane> root = Optional.of(rootBox);
        scene = new Scene(root.get());
        // Setup the menuBar
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem filePicker = new MenuItem("Open");

        filePicker.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                String qlPath = file.getAbsolutePath();
                String qlsPath = file.getAbsolutePath().replace(".ql", ".qls");

                qlAst = null;
                qlsAst = null;
                try {
                    qlAst = QLFileReader.readFile(qlPath);
                    // TODO: Re enable evaluator and typechecker
                    //TypeChecker tc = new TypeChecker(ast);
                    //tc.runChecks();
                } catch (IOException e) {
                    System.err.println("Couldn't find file, show error or something");
                }
                try {
                    qlsAst = QLSFileReader.readFile(qlsPath, qlAst);
                } catch (IOException e) {
                    System.err.println("Couldn't find qls file, no biggie.");
                }
                visualize(null);
            }
        });

        menuFile.getItems().add(filePicker);
        menuBar.getMenus().add(menuFile);

        // Setup the split pane

        SplitPane mainPane = new SplitPane();
        mainPane.setDividerPositions(0.2f);
        mainPane.setMinSize(700, 500);
        mainPane.getDividers();

        pages = new VBox();
        questions = new VBox();

        mainPane.getItems().addAll(pages, questions);

        rootBox.getChildren().addAll(menuBar, mainPane);

        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
    }

    public void visualize(String focusId) {
        this.focusId = focusId;
        setBaseView();
        System.out.println("Running visualizer!");
        Optional<? extends Pane> pagePane = Optional.of(pages);
        Optional<? extends Pane> questionPane = Optional.of(questions);
        //ExpressionEvaluator ee = new ExpressionEvaluator(qlAst);
        if (qlsAst != null) {
            for (QLSNode n : qlsAst.getRoot().getChildren()) {
                if (n instanceof QLSPage) {
                    QLSPage page = (QLSPage) n;
                    if (currentPage == null) {
                        currentPage = page;
                    }

                    String identifier = page.getIdentifier();
                    Label label = new Label(identifier);
                    label.setOnMouseClicked((event) -> {
                        currentPage = page;
                        visualize(null);
                    });
                    if (currentPage == page) {
                        label.getStyleClass().add("active");
                        for (QLSNode child : currentPage.getChildren()) {
                            child.visualize(questionPane.get(), answerMap, this);
                        }
                    }
                    label.getStyleClass().add("pageLabel");
                    pagePane.get().getChildren().add(label);
                }
            }
            // Non-QLS Implementation
        } else {
            if (qlAst.getRoot().hasChildren()) {
                visualChildren(qlAst.getRoot(), questionPane);
            }
        }
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        if (focusedNode != null) {
            focusedNode.requestFocus();
            // Fix for the position caret in textfields, had to use instanceof sorry Tijs!
            if (focusedNode instanceof TextField){
                TextField tf = (TextField) focusedNode;
                tf.positionCaret(tf.getLength());
            }
        }
    }

    private void visualChildren(QLNode node, Optional<? extends Pane> parentPane) {
        for (QLNode child : node.getChildren()) {
            if (child.hasChildren()) {
                Optional<? extends Pane> newParent = child.visualize(parentPane.get(), answerMap, this);
                if (newParent.isPresent()) {
                    visualChildren(child, newParent);
                } else {
                    visualChildren(child, parentPane);
                }
            } else {
                child.visualize(parentPane.get(), answerMap, this);
            }
        }
    }
}

