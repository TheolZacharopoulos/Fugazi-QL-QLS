package org.fugazi.qls.ast;

import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.question.Question;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.segment.Segment;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor.FullQLSFormVisitor;

import java.util.List;

public class DefaultStyleHandler extends FullQLSFormVisitor {

    private final StyleSheet styledStyleSheet;
    private Segment currentSegment;

    public DefaultStyleHandler(StyleSheet styleSheet) {
        styledStyleSheet = styleSheet;
        styledStyleSheet.accept(this);
    }

    public StyleSheet getStylesheetWithStyles() {
        return styledStyleSheet;
    }

    public Void visitStyleSheet(StyleSheet styleSheet){
        List<Page> pages = styleSheet.getPages();
        for (Page page : pages) {
            page.accept(this);
        }
        return null;
    }

    public Void visitPage(Page page){

        // set current segment
        currentSegment = page;

        for (Section section : page.getSections()) {
            section.accept(this);
        }
        return null;
    }

    public Void visitSection(Section section) {

        // CurrentSegment is the parent.
        List<DefaultStyleDeclaration> parentSegmentDefaultStyles = currentSegment.getDefaultStyleDeclarations();

        // Change current segment
        currentSegment = section;
        List<DefaultStyleDeclaration> currentSegmentDefaultStyles = currentSegment.getDefaultStyleDeclarations();

        // Check if the base declaration for a type exists in the current declarations.
        //         - if yes, inherit style.
        //         - if not, add parent declaration on current.

        // for every base declaration.
        for (DefaultStyleDeclaration baseDeclaration : parentSegmentDefaultStyles) {
            Type baseDeclarationType = baseDeclaration.getQuestionType();
            Style baseDeclarationStyle = baseDeclaration.getStyle();

            // for every current declaration.
            for (DefaultStyleDeclaration currentDeclaration : currentSegmentDefaultStyles) {
                Type currentDeclarationType = currentDeclaration.getQuestionType();
                Style currentDeclarationStyle = currentDeclaration.getStyle();

                // if the base declaration for a type exists in the current declarations.
                // then inherit style from parent.
                if (baseDeclarationType.equals(currentDeclarationType)) {
                    currentDeclarationStyle.inheriteFromStyle(baseDeclarationStyle);
                }
            }
        }

        // for every base declaration.
        for (DefaultStyleDeclaration baseDeclaration : parentSegmentDefaultStyles) {

            // if there is no such declaration on current segment,
            // add it from the parent.
            if (!currentSegmentDefaultStyles.contains(baseDeclaration)) {
                currentSegment.addDefaultStyleDeclaration(baseDeclaration);
            }
        }

        for (Section subsection : section.getSections()) {
            subsection.accept(this);
        }

        for (Question question : section.getQuestions()) {
            // todo check if there is a declared style for the question's type.
            // todo     - if yes, check if there is style for this widget.
            // todo         - if yes, apply the style to the widget and the widget to the question.
            // todo         - if no, apply the default style to the widget and the widget to the question.
            // todo     - if no, if no apply the default widget to the question.
        }

        return null;
    }
}
