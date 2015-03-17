package org.fugazi.ql.ast.form.form_data;

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.form.form_data.visitor.ComputedQuestionsVisitor;
import org.fugazi.ql.ast.form.form_data.visitor.IfStatementsVisitor;
import org.fugazi.ql.ast.form.form_data.visitor.QuestionsVisitor;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.ast.type.UndefinedType;

import java.util.*;

public class QLFormDataStorage {
    private final Form form;
    private final Map<String, Type> idTypes;

    private final QuestionsVisitor questionsVisitor;
    private final ComputedQuestionsVisitor computedQuestionsVisitor;
    private final IfStatementsVisitor ifStatementsVisitor;

    public QLFormDataStorage(Form _form) {
        this.form = _form;
        this.idTypes = _form.getIdentifierTypes();

        this.questionsVisitor = new QuestionsVisitor(this.form);
        this.computedQuestionsVisitor = new ComputedQuestionsVisitor(this.form);
        this.ifStatementsVisitor = new IfStatementsVisitor(this.form);
    }

    /**
     * =====================
     * Public exposed getters
     * =====================
     */

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        Iterator<Question> iterator = this.questionsVisitor.getQuestions();

        // convert back to list
        // this way internal lists will not be modified by clients
        iterator.forEachRemaining(questions::add);
        return questions;
    }

    public List<ComputedQuestion> getComputedQuestions() {
        List<ComputedQuestion> computedQuestions = new ArrayList<>();
        Iterator<ComputedQuestion> iterator = this.computedQuestionsVisitor.getComputedQuestions();

        // convert back to list
        // this way internal lists will not be modified by clients
        iterator.forEachRemaining(computedQuestions::add);
        return computedQuestions;
    }

    public List<Question> getAllQuestions() {
        List<Question> allQuestions = this.getQuestions();
        List<ComputedQuestion> computedQuestions = this.getComputedQuestions();
        allQuestions.addAll(computedQuestions);

        return allQuestions;
    }

    public List<IfStatement> getIfStatements() {
        return this.ifStatementsVisitor.getIfStatement();
    }

    public HashMap<String, Type> getallQuestionTypes() {
        HashMap<String, Type> questionTypes = this.questionsVisitor.getQuestionTypes();
        HashMap<String, Type> computedQuestionTypes = this.computedQuestionsVisitor.getComputedQuestionTypes();
        questionTypes.putAll(computedQuestionTypes);
        return questionTypes;
    }

    public Type getIdType(ID _id) {
        String idName = _id.getName();
        Type idType = this.idTypes.get(idName);
        if (idType == null) {
            idType = new UndefinedType();
        }
        return idType;
    }
}
