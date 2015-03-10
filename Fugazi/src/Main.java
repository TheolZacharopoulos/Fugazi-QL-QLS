import org.fugazi.ql.ast.QLASTBuilder;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.gui.GUIBuilder;
import org.fugazi.ql.type_checker.QLTypeChecker;
import org.fugazi.ql.type_checker.issue.ASTIssuePrinter;
import org.fugazi.qls.ast.DefaultStyleHandler;
import org.fugazi.qls.ast.QLSASTBuilder;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.type_checker.QLSTypeChecker;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws Exception {

        String inputQLFile = null;

        if (args.length > 0)
            inputQLFile = args[0];

        InputStream qlInput = System.in;

        if (inputQLFile != null)
            qlInput = new FileInputStream(inputQLFile);

        /** ---------------------
          * QL
          * --------------------- */
        // Create The AST Builder.
        QLASTBuilder QLAstBuilder = new QLASTBuilder(qlInput);

        // Build the AST.
        Form form = QLAstBuilder.buildForm();
        QLFormDataStorage formDataStorage = new QLFormDataStorage(form);

        // Perform type checking.
        QLTypeChecker qLTypeChecker = new QLTypeChecker();
        boolean isFormTypesCorrect = qLTypeChecker.checkForm(form, formDataStorage);

        // display warnings and errors and if form is not type-correct, exit
        ASTIssuePrinter printer = new ASTIssuePrinter(
                qLTypeChecker.getErrors(), qLTypeChecker.getWarnings()
        );
        printer.displayWarningsAndErrors();

        if (!isFormTypesCorrect) {
            System.err.println("Form is not type correct. Cannot evaluate and render. Please fix the errors.");
            System.exit(-1);
        }

        // Render GUI.
//        GUIBuilder guiBuilder = new GUIBuilder(form);
//        guiBuilder.renderUI();

        /** ---------------------
         * QLS
         * --------------------- */
        String inputQLSFile = null;

        if (args.length > 1)
            inputQLSFile = args[1];

        InputStream qlsInput = System.in;

        if (inputQLFile != null)
            qlsInput = new FileInputStream(inputQLSFile);

         // Create The AST Builder.
        QLSASTBuilder qlsAstBuilder = new QLSASTBuilder(qlsInput);

        // Build the AST.
        StyleSheet styleSheet = qlsAstBuilder.buildStyleSheet();
        QLSStyleSheetDataStorage styleSheetData = new QLSStyleSheetDataStorage(styleSheet);

        DefaultStyleHandler defaultStyleDeclaration = new DefaultStyleHandler(styleSheet);
        StyleSheet styledStyleSheet = defaultStyleDeclaration.getStylesheetWithStyles();

        // Perform QLS type checking.
//        QLSTypeChecker qLSTypeChecker = new QLSTypeChecker();
//        boolean isQLSFormTypesCorrect = qLSTypeChecker.checkStylesheet(
//                styleSheetData, formDataStorage
//        );
//
//        // display warnings and errors and if form is not type-correct, exit
//        printer = new ASTIssuePrinter(
//                qLSTypeChecker.getErrors(), qLSTypeChecker.getWarnings()
//        );
//        printer.displayWarningsAndErrors();
//
//        if (!isQLSFormTypesCorrect) {
//            System.err.println("Stylesheet is not type correct. Cannot evaluate and render. Please fix the errors.");
//            System.exit(-1);
//        }

        // todo: render gui with stylesheet.

    }
}