package test.evaluator;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.visitor.evaluator.Evaluator;
import cons.ql.parser.Parser;
import cons.value.FloatValue;
import cons.value.IntegerValue;

@SuppressWarnings("rawtypes")
public abstract class BaseTest {
     public static String header = "";

     private ASTNode inputNode;
     private Value expected;
     
     private Parser formParser = new Parser();
     private static ValueEnvironment register = new ValueEnvironment();

     public BaseTest(String input, Value expected) {
    	 System.out.println("Testing: " + input);
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void setupEnvironment() {
    	 System.out.println("========================");
    	 System.out.println("*** Testing " + header + " ***");
    	 System.out.println("========================");
    	 
    	 register.store(new Identifier("integerQuestion"), new IntegerValue(10));
    	 register.store(new Identifier("floatQuestion"), new FloatValue((float) 10.5));
     }
     
     @Test
     public void test() {
    	 assertEquals(expected, Evaluator.check(inputNode, register));
     }
}
