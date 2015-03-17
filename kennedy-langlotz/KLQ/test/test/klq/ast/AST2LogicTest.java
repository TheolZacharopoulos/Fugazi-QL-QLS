package test.klq.ast;

import com.klq.gui.AST2GUIConverter;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.stmt.QuestionnaireNode;
import com.klq.gui.control.ARenderedQuestion;
import com.klq.controller.Store;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by juriaan on 24-2-15.
 */
public class AST2LogicTest {
    private Store store;
    private QuestionnaireNode ast;
    @Before
    public void setUp() throws Exception {
        store = new Store();
        ast = new QuestionnaireNode();
    }

    @Test
    public void testBasicQuestion() throws Exception {
        ast.getChildren().add(new QuestionNode("question1", "string", "This is a test question"));
        ast.getChildren().add(new QuestionNode("question2", "numeral", "This is a test question with a numeral answer"));

        fillStore();

        assertEquals(store.getOrderedQuestions().size(), 2);

        ArrayList<String> storeTextList = new ArrayList<String>();
        for(ARenderedQuestion question : store.getOrderedQuestions()){
            storeTextList.add(question.getText());
        }

        ArrayList<String> textList = new ArrayList<String>();
        textList.add("This is a test question");
        textList.add("This is a test question with a numeral answer");
        assertThat(storeTextList, is(textList));
    }

/*    @Test
    public void testComputedQuestion() throws Exception {
        AddNode add = new AddNode(new NumberNode(13), new NumberNode(17));
        ast.getComputedAnswer().add(new ComputedQuestionNode("question1", "string", "This is a test question", add));

        fillStore();

        System.out.println("lol");
    }*/

    private void fillStore(){
        AST2GUIConverter AST2GUIConverter = new AST2GUIConverter();
        store = (Store) ast.accept(AST2GUIConverter);
    }
}
