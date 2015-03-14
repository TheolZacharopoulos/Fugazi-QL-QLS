package org.fugazi.qls.gui;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.widgets.*;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.ast.widget.AbstractQLSWidget;

import java.util.List;


public class QLSWidgetsFactory extends WidgetsFactory {
    
    private final QLSStyleSheetDataStorage styleSheetDataStorage;
    
    public QLSWidgetsFactory(QLSStyleSheetDataStorage _styleSheetDataStorage) {
        this.styleSheetDataStorage = _styleSheetDataStorage;
    }
    
    @Override
    public IWidget getDefaultWidgetForQuestion(Question _question) {
        String label = _question.getLabel();
        AbstractQLSWidget widget = (AbstractQLSWidget) getQlsWidget(_question.getIdName());
        widget.setLabel(label);

        return widget;
    }

    @Override
    public IWidget getDefaultWidgetForQuestion(Question _question, ExpressionValue _value) {
        String label = _question.getLabel();
        AbstractQLSWidget widget = (AbstractQLSWidget) getQlsWidget(_question.getIdName());
        widget.setLabel(label);
        widget.setValue(_value.getValue());
        widget.setReadOnly(true);

        return widget;
    }

    private IWidget getQlsWidget(String _qlQuestionId) {
        List<QLSQuestion> qlsQuestions = styleSheetDataStorage.getQuestions();
        for (QLSQuestion qlsQuestion : qlsQuestions) {
            if (qlsQuestion.getIdName().equals(qlsQuestion)) {
                return qlsQuestion.getWidget();
            }
        }
        return null;
    }
}