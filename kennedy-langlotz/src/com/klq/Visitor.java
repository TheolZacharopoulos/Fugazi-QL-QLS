package com.klq;

import com.klq.ast.IVisitor;
import com.klq.ast.ANode;
import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.comp.GreaterThanNode;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import com.klq.logic.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juriaan on 17-2-15.
 */
public class Visitor implements IVisitor {
    List<com.klq.logic.Question> questList = new ArrayList<com.klq.logic.Question>();
    OptionSet currentAnswers = new OptionSet();

    @Override
    public void visit(QuestionnaireNode node) {
//        for(ANode child : node.getChildren()){
//            visit(child);
//        }
    }

    public void visit(ANode node){

    }

    @Override
    public void visit(ConditionalNode node) {

    }

    @Override
    public void visit(GreaterThanNode node) {

    }

    @Override
    public void visit(MultiplyNode node) {

    }

    @Override
    public void visit(AddNode node) {

    }

    @Override
    public void visit(SubtractNode node) {

    }

    @Override
    public void visit(DivideNode node) {

    }

    @Override
    public void visit(QuestionNode node) {
        Id id = new Id(node.getQuestionID());
        Type type = node.getQuestionType();
        Text text = new Text(node.getText());

        com.klq.logic.Question question = new com.klq.logic.Question(type, null, text);
        questList.add(question);

    }

    @Override
    public void visit(ComputedQuestionNode node) {
        Id id = new Id(node.getQuestionID());
        Type type = node.getQuestionType();
        Text text = new Text(node.getText());

        com.klq.logic.Question question = new com.klq.logic.Question(type, currentAnswers, text);
        questList.add(question);
        currentAnswers = new OptionSet(); //reset the currentAnswers since the end of the question is reached
    }

    @Override
    public void visit(StringNode node) {
        currentAnswers.add(new Answer(node.getString()));
    }

    @Override
    public void visit(NumberNode node) {
        currentAnswers.add(new Answer(String.valueOf(node.getNumber())));
    }

    @Override
    public void visit(DateNode node) {
        currentAnswers.add(new Answer(String.valueOf(node.getDate())));
    }

    public List<com.klq.logic.Question> getQuestList() {
        return questList;
    }
}
