package org.uva.student.calinwouter.qlqls.qls;

import org.junit.Test;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.helper.InterpreterHelper;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.components.Radio;
import org.uva.student.calinwouter.qlqls.qls.model.components.Slider;
import org.uva.student.calinwouter.qlqls.qls.model.components.Spinbox;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestQLSInterpreter {

    private StyleSheet parseStyleSheetString(String styleSheetStr)
            throws ParserException, IOException, LexerException {
        QLSInterpreter qlsInterpreter = InterpreterHelper.interpetStylesheetString(styleSheetStr);
        return (StyleSheet) qlsInterpreter.getValue().getValue();
    }

    @Test
    public void testSpinbox() throws ParserException, IOException, LexerException {
        String styleSheetStr = "styleSheet(S, default(int, { widget: spinbox() }) )";
        StyleSheet styleSheet = parseStyleSheetString(styleSheetStr);
        AbstractWidget<?> abstractWidget = styleSheet.getTypeToWidgetSettingsModel()
                .getWidgetSettingsModel("int").getWidget();
        assertTrue(abstractWidget instanceof Spinbox);
    }

    @Test
    public void testRadio() throws ParserException, IOException, LexerException {
        String styleSheetStr = "styleSheet(S, default(int, { widget: radio(\"yes\", \"no\") }) )";
        StyleSheet styleSheet = parseStyleSheetString(styleSheetStr);
        AbstractWidget<?> abstractWidget = styleSheet.getTypeToWidgetSettingsModel()
                .getWidgetSettingsModel("int").getWidget();
        assertTrue(abstractWidget instanceof Radio);
        // TODO remove " in texts.
        assertEquals(((Radio) abstractWidget).getYesLbl(), "\"yes\"");
        assertEquals(((Radio) abstractWidget).getNoLbl(), "\"no\"");
    }

    @Test
    public void testSlider() throws ParserException, IOException, LexerException {
        String styleSheetStr = "styleSheet(S, default(int, { widget: slider(5, 10) }) )";
        StyleSheet styleSheet = parseStyleSheetString(styleSheetStr);
        AbstractWidget<?> abstractWidget = styleSheet.getTypeToWidgetSettingsModel()
                .getWidgetSettingsModel("int").getWidget();
        assertTrue(abstractWidget instanceof Slider);
        assertTrue(((Slider) abstractWidget).getMin().equals(5));
        assertTrue(((Slider) abstractWidget).getMax().equals(10));
    }

}