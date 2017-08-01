package org.fugazi.ql.evaluator;

import org.fugazi.ql.ast.expression.literal.BOOL;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.expression.literal.INT;
import org.fugazi.ql.ast.expression.literal.STRING;
import org.fugazi.ql.ast.expression.logical.And;
import org.fugazi.ql.ast.expression.logical.Or;
import org.fugazi.ql.ast.expression.numerical.Add;
import org.fugazi.ql.ast.expression.numerical.Div;
import org.fugazi.ql.ast.expression.numerical.Mul;
import org.fugazi.ql.ast.expression.numerical.Sub;
import org.fugazi.ql.ast.expression.unary.Negative;
import org.fugazi.ql.ast.expression.unary.Not;
import org.fugazi.ql.ast.expression.unary.Positive;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;
import org.fugazi.ql.evaluator.expression_value.UndefinedValue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvaluatorTest {

    private Evaluator evaluator;
    
    // Test data
    private ValueStorage valueStorage = new ValueStorage();
    private final INT num5 = new INT(5);
    private final INT num4 = new INT(4);
    private final STRING stringFoo = new STRING("Foo");
    private final STRING stringBar = new STRING("bar");
    private final BOOL boolTrue = new BOOL(true);
    private final BOOL boolFalse = new BOOL(false );

    private final String testString1 = "testString1";

    @Before
    public void setupEnv() {
        evaluator = new Evaluator(valueStorage);
    }
    
    /**
     * Test Add
     */
    @Test
    public void testAddExpressionWithNums() throws Exception {
        // test: 5 + 4 = 9;
        Add expression = new Add(num5, num4 );
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), 9);
    }

    @Test(expected=AssertionError.class)
    public void testAddExpressionWithBools() throws Exception {
        // test: Undefined
        Add expression = new Add(boolTrue, boolFalse );
        ExpressionValue value = evaluator.evaluateExpression(expression);
    }

    /**
     * Test Sub
     */
    @Test
    public void testSubExpressionWithNums() throws Exception {
        Sub expression = new Sub(num5, num4 );
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), 1);
    }

    @Test(expected=AssertionError.class)
    public void testSubExpressionWithStrings() throws Exception {
        // test: Undefined
        Sub expression = new Sub(stringFoo, stringBar );
        ExpressionValue value = evaluator.evaluateExpression(expression);
    }

    @Test(expected=AssertionError.class)
    public void testSubExpressionWithBools() throws Exception {
        // test: Undefined
        Add expression = new Add(boolTrue, boolFalse );
        ExpressionValue value = evaluator.evaluateExpression(expression);
    }

    /**
     * Test Mul
     */
    @Test
    public void testMulExpressionWithNums() throws Exception {
        // test: 5 * 4 = 20;
        Mul expression = new Mul(num5, num4 );
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), 20);
    }

    @Test(expected=AssertionError.class)
    public void testMulExpressionWithStrings() throws Exception {
        // test: Undefined
        Mul expression = new Mul(stringFoo, stringBar );
        ExpressionValue value = evaluator.evaluateExpression(expression);
    }

    @Test(expected=AssertionError.class)
    public void testMulExpressionWithBools() throws Exception {
        // test: Undefined
        Mul expression = new Mul(boolTrue, boolFalse );
        ExpressionValue value = evaluator.evaluateExpression(expression);
    }

    /**
     * Test Div
     */
    @Test
    public void testDivExpressionWithNums() throws Exception {
        // test: 5 / 4 = 1;
        Div expression = new Div(num5, num4 );
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), 1);
    }

    @Test(expected=AssertionError.class)
    public void testDivExpressionWithStrings() throws Exception {
        // test: Undefined
        Div expression = new Div(stringFoo, stringBar );
        ExpressionValue value = evaluator.evaluateExpression(expression);
    }

    @Test(expected=AssertionError.class)
    public void testDivExpressionWithBools() throws Exception {
        // test: Undefined
        Div expression = new Div(boolTrue, boolFalse );
        ExpressionValue value = evaluator.evaluateExpression(expression);
    }

    /**
     * Test Literals
     */
    @Test
    public void testIDExpression() throws Exception {
        ID id = new ID(testString1);
        valueStorage.saveValue(testString1, new IntValue(5));
        ExpressionValue value = evaluator.evaluateExpression(id);
        assertEquals(value.getValue(), 5);
    }

    @Test
    public void testBOOLExpression() throws Exception {
        BOOL bool = new BOOL(true );
        ExpressionValue value = evaluator.evaluateExpression(bool);
        assertEquals(value.getValue(), bool.getValue());
    }

    @Test
    public void testINTExpression() throws Exception {
        INT num = num5;
        ExpressionValue value = evaluator.evaluateExpression(num);
        assertEquals(value.getValue(), num.getValue());
    }

    @Test
    public void testSTRINGExpression() throws Exception {
        STRING str = new STRING(testString1 );
        ExpressionValue value = evaluator.evaluateExpression(str);
        assertEquals(value.getValue(), str.getValue());
    }

    /**
     * Test And
     */
    @Test(expected=AssertionError.class)
    public void testAndExpressionWithNums() throws Exception {
        // test: Undefined
        And expression = new And(num5, num4 );
        ExpressionValue value = evaluator.evaluateExpression(expression);
        
    }

    @Test(expected=AssertionError.class)
    public void testAndExpressionWithStrings() throws Exception {
        // test: Undefined
        And expression = new And(stringFoo, stringBar );
        ExpressionValue value = evaluator.evaluateExpression(expression);
        
    }

    @Test
    public void testAndExpressionWithBools() throws Exception {
        // test: True && False = False
        And expression = new And(boolTrue, boolFalse );
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), false);
    }

    /**
     * Test Or
     */
    @Test(expected=AssertionError.class)
    public void testOrExpressionWithNums() throws Exception {
        // test: Undefined
        Or expression = new Or(num5, num4 );
        ExpressionValue value = evaluator.evaluateExpression(expression);
    }

    @Test(expected=AssertionError.class)
    public void testOrExpressionWithStrings() throws Exception {
        // test: Undefined
        Or expression = new Or(stringFoo, stringBar );
        ExpressionValue value = evaluator.evaluateExpression(expression);
    }

    @Test
    public void testOrExpressionWithBools() throws Exception {
        // test: True || False = True
        Or expression = new Or(boolTrue, boolFalse );
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), true);
    }

    /**
     * Test Not
     */
    @Test
    public void testNotExpressionWithBools() throws Exception {
        // test: !False = True
        Not expression1 = new Not(boolFalse );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), true);

        // test: !True = False
        Not expression2 = new Not(boolTrue );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), false);
    }

    /**
     * Test Positive
     */
    @Test
    public void testPosExpressionWithNums() throws Exception {
        // test: (+)5 = 5
        Positive expression = new Positive(num5 );
        ExpressionValue value1 = evaluator.evaluateExpression(expression);
        assertEquals(value1.getValue(), num5.getValue());
    }

    /**
     * Test Negative
     */
    @Test
    public void testNegExpressionWithNums() throws Exception {
        // test: (-)5 = -5
        Negative expression = new Negative(num5 );
        ExpressionValue value1 = evaluator.evaluateExpression(expression);
        assertEquals(value1.getValue(), -num5.getValue());
    }

    /**
     * Test equals
     */
    @Test
    public void testEqualsExpressionWithNums() throws Exception {
        // test: 5 == 4 = false
        org.fugazi.ql.ast.expression.comparison.equality.EQ expression1 = new org.fugazi.ql.ast.expression.comparison.equality.EQ(num5, num4 );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), false);

        // test: 5 == 5 = true
        org.fugazi.ql.ast.expression.comparison.equality.EQ expression2 = new org.fugazi.ql.ast.expression.comparison.equality.EQ(num5, num5 );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), true);
    }

    @Test
    public void testEqualsExpressionWithStrings() throws Exception {
        // test: Foo == bar = false;
        org.fugazi.ql.ast.expression.comparison.equality.EQ expression1 = new org.fugazi.ql.ast.expression.comparison.equality.EQ(stringFoo, stringBar );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), false);

        // test: Foo == Foo = true;
        org.fugazi.ql.ast.expression.comparison.equality.EQ expression2 = new org.fugazi.ql.ast.expression.comparison.equality.EQ(stringFoo, stringFoo );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), true);
    }

    @Test
    public void testEqualsExpressionWithBools() throws Exception {
        // test: true == false = false;
        org.fugazi.ql.ast.expression.comparison.equality.EQ expression1 = new org.fugazi.ql.ast.expression.comparison.equality.EQ(boolTrue, boolFalse );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), false);

        // test: true == true = true;
        org.fugazi.ql.ast.expression.comparison.equality.EQ expression2 = new org.fugazi.ql.ast.expression.comparison.equality.EQ(boolTrue, boolTrue );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), true);
    }

    /**
     * Test not equals
     */
    @Test
    public void testNotEqualsExpressionWithNums() throws Exception {
        // test: 5 != 4 = true
        org.fugazi.ql.ast.expression.comparison.equality.NotEq expression1 = new org.fugazi.ql.ast.expression.comparison.equality.NotEq(num5, num4 );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), true);

        // test: 5 != 5 = false
        org.fugazi.ql.ast.expression.comparison.equality.NotEq expression2 = new org.fugazi.ql.ast.expression.comparison.equality.NotEq(num5, num5 );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), false);
    }

    @Test
    public void testNotEqualsExpressionWithStrings() throws Exception {
        // test: Foo != bar = true;
        org.fugazi.ql.ast.expression.comparison.equality.NotEq expression1 = new org.fugazi.ql.ast.expression.comparison.equality.NotEq(stringFoo, stringBar );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), true);

        // test: Foo != Foo = false;
        org.fugazi.ql.ast.expression.comparison.equality.NotEq expression2 = new org.fugazi.ql.ast.expression.comparison.equality.NotEq(stringFoo, stringFoo );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), false);
    }

    @Test
    public void testNotEqualsExpressionWithBools() throws Exception {
        // test: true != false = true;
        org.fugazi.ql.ast.expression.comparison.equality.NotEq expression1 = new org.fugazi.ql.ast.expression.comparison.equality.NotEq(boolTrue, boolFalse );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), true);

        // test: true != true = false;
        org.fugazi.ql.ast.expression.comparison.equality.NotEq expression2 = new org.fugazi.ql.ast.expression.comparison.equality.NotEq(boolTrue, boolTrue );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), false);
    }

    /**
     * Test Greater
     */
    @Test
    public void testGreaterExpressionWithNums() throws Exception {
        // test: 5 > 4 = true
        org.fugazi.ql.ast.expression.comparison.ordering.Greater expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.Greater(num5, num4 );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), true);

        // test: 5 > 5 = false
        org.fugazi.ql.ast.expression.comparison.ordering.Greater expression2 = new org.fugazi.ql.ast.expression.comparison.ordering.Greater(num5, num5 );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), false);

        // test: 4 > 5 = false
        org.fugazi.ql.ast.expression.comparison.ordering.Greater expression3 = new org.fugazi.ql.ast.expression.comparison.ordering.Greater(num4, num5 );
        ExpressionValue value3 = evaluator.evaluateExpression(expression3);
        assertEquals(value3.getValue(), false);
    }

    @Test(expected=AssertionError.class)
    public void testGreaterExpressionWithStrings() throws Exception {
        // test: Undefined
        org.fugazi.ql.ast.expression.comparison.ordering.Greater expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.Greater(stringFoo, stringBar );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
    }

    @Test(expected=AssertionError.class)
    public void testGreaterExpressionWithBools() throws Exception {
        // test: Undefined
        org.fugazi.ql.ast.expression.comparison.ordering.Greater expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.Greater(boolTrue, boolFalse );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
    }

    /**
     * Test Lesser
     */
    @Test
    public void testLesserExpressionWithNums() throws Exception {
        // test: 5 < 4 = false
        org.fugazi.ql.ast.expression.comparison.ordering.Less expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.Less(num5, num4 );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), false);

        // test: 5 < 5 = false
        org.fugazi.ql.ast.expression.comparison.ordering.Less expression2 = new org.fugazi.ql.ast.expression.comparison.ordering.Less(num5, num5 );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), false);

        // test: 4 < 5 = true
        org.fugazi.ql.ast.expression.comparison.ordering.Less expression3 = new org.fugazi.ql.ast.expression.comparison.ordering.Less(num4, num5 );
        ExpressionValue value3 = evaluator.evaluateExpression(expression3);
        assertEquals(value3.getValue(), true);
    }

    @Test(expected=AssertionError.class)
    public void testLesserExpressionWithStrings() throws Exception {
        // test: Undefined
        org.fugazi.ql.ast.expression.comparison.ordering.Less expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.Less(stringFoo, stringBar );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
    }

    @Test(expected=AssertionError.class)
    public void testLesserExpressionWithBools() throws Exception {
        // test: Undefined
        org.fugazi.ql.ast.expression.comparison.ordering.Less expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.Less(boolTrue, boolFalse );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        Assert.assertEquals(value1.getValue(), new UndefinedValue().getValue());
    }

    /**
     * Test Greater Equal
     */
    @Test
    public void testGreaterEqualExpressionWithNums() throws Exception {
        // test: 5 >= 4 = true
        org.fugazi.ql.ast.expression.comparison.ordering.GE expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.GE(num5, num4 );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), true);

        // test: 5 >= 5 = true
        org.fugazi.ql.ast.expression.comparison.ordering.GE expression2 = new org.fugazi.ql.ast.expression.comparison.ordering.GE(num5, num5 );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), true);

        // test: 4 >= 5 = false
        org.fugazi.ql.ast.expression.comparison.ordering.GE expression3 = new org.fugazi.ql.ast.expression.comparison.ordering.GE(num4, num5 );
        ExpressionValue value3 = evaluator.evaluateExpression(expression3);
        assertEquals(value3.getValue(), false);
    }

    @Test(expected=AssertionError.class)
    public void testGreaterEqualExpressionWithStrings() throws Exception {
        // test: Undefined
        org.fugazi.ql.ast.expression.comparison.ordering.GE expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.GE(stringFoo, stringBar );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
    }

    @Test(expected=AssertionError.class)
    public void testGreaterEqualExpressionWithBools() throws Exception {
        // test: Undefined
        org.fugazi.ql.ast.expression.comparison.ordering.GE expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.GE(boolTrue, boolFalse );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
    }

    /**
     * Test Less Equal
     */
    @Test
    public void testLessEqualExpressionWithNums() throws Exception {
        // test: 5 <= 4 = false
        org.fugazi.ql.ast.expression.comparison.ordering.LE expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.LE(num5, num4 );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), false);

        // test: 5 <= 5 = true
        org.fugazi.ql.ast.expression.comparison.ordering.LE expression2 = new org.fugazi.ql.ast.expression.comparison.ordering.LE(num5, num5 );
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), true);

        // test: 4 <= 5 = true
        org.fugazi.ql.ast.expression.comparison.ordering.LE expression3 = new org.fugazi.ql.ast.expression.comparison.ordering.LE(num4, num5 );
        ExpressionValue value3 = evaluator.evaluateExpression(expression3);
        assertEquals(value3.getValue(), true);
    }

    @Test(expected=AssertionError.class)
    public void testLessEqualExpressionWithStrings() throws Exception {
        // test: Undefined
        org.fugazi.ql.ast.expression.comparison.ordering.LE expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.LE(stringFoo, stringBar );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
    }

    @Test(expected=AssertionError.class)
    public void testLessEqualExpressionWithBools() throws Exception {
        // test: Undefined
        org.fugazi.ql.ast.expression.comparison.ordering.LE expression1 = new org.fugazi.ql.ast.expression.comparison.ordering.LE(boolTrue, boolFalse );
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
    }
}