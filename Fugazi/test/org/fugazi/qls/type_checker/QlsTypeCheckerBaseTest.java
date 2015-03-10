package org.fugazi.qls.type_checker;


import org.fugazi.ql.type_checker.TypeCheckerBaseTest;
import org.fugazi.qls.ast.QLSASTBuilder;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.junit.Before;
import org.junit.Ignore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Ignore("This is a base class.")
public abstract class QlsTypeCheckerBaseTest extends TypeCheckerBaseTest {

    protected QLSTypeChecker qlsChecker;
    protected String qlsInputFile;
    protected InputStream qlsInput;
    protected QLSASTBuilder qlsAstBuilder;

    protected String qlsFileName;

    private final String path = "/test/org/fugazi/qls/type_checker/test_form/";

    /*
    Both ql and qls files need to be loaded here.
     */
    @Before
    public void setUp() {
        // we are only testing qls here
        // correct ql form necessary
        this.fileName = "correctForm.ql";

        super.setUp();

        this.filePath = this.path.concat(this.qlsFileName);
        this.qlsInputFile = new File("").getAbsolutePath().concat(this.filePath);

        try {
            if (qlsInputFile != null)
                qlsInput = new FileInputStream(qlsInputFile);

            // Create The AST Builder.
            qlsAstBuilder = new QLSASTBuilder(qlsInput);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Build the AST.
        StyleSheet styleSheet = qlsAstBuilder.buildStyleSheet();

        // Get the styles.
//        DefaultStyleHandler defaultStyleDeclaration =
//                new DefaultStyleHandler(this.formDataStorage, styleSheet);
//        StyleSheet styledStyleSheet = defaultStyleDeclaration.getStylesheetWithStyles();

        QLSStyleSheetDataStorage styleSheetData = new QLSStyleSheetDataStorage(styleSheet);

        // Perform QLS type checking.
        this.qlsChecker = new QLSTypeChecker();
        qlsChecker.checkStylesheet(
                styleSheetData, this.formDataStorage
        );
    }
}
