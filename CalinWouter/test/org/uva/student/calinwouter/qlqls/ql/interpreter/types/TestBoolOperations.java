package org.uva.student.calinwouter.qlqls.ql.interpreter.types;

import org.junit.Test;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;

import static org.junit.Assert.*;

public class TestBoolOperations {

    @Test
    public void testOr() {
        assertEquals(true, new BoolValue(true).or(new BoolValue(true)).getValue());
        assertEquals(true, new BoolValue(true).or(new BoolValue(false)).getValue());
        assertEquals(true, new BoolValue(false).or(new BoolValue(true)).getValue());
        assertEquals(false, new BoolValue(false).or(new BoolValue(false)).getValue());
    }

    @Test
    public void testAnd() {
        assertEquals(true, new BoolValue(true).and(new BoolValue(true)).getValue());
        assertEquals(false, new BoolValue(true).and(new BoolValue(false)).getValue());
        assertEquals(false, new BoolValue(false).and(new BoolValue(false)).getValue());
        assertEquals(false, new BoolValue(false).and(new BoolValue(false)).getValue());
    }

    @Test
    public void testNot() {
        assertEquals(false, new BoolValue(true).not().getValue());
        assertEquals(true, new BoolValue(false).not().getValue());
    }

}
