package test.typechecker.relational;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cons.TypeEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

@RunWith(value = Parameterized.class)
public class TestNotEqual {
	public static String createTestForm(String questionType, String comparison) {
		return "form myForm { "
				+ "newQuestion : " + questionType + " { \"Something\" }"
				+ "if(newQuestion != " + comparison + ") {}"
				+ "}";
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{ "10 != 100", true },
				{ "10.5 != 10", true }, 
				{ "10.1 != 100.5", true },
				{ "true != false", true }, 
				{ "\"a\" != \"b\"", true },
				// Type mismatch
				{ "10 != true", false }, 
				{ "true != \"string\"", false },
				{ "false != 100.5", false },
				// Forms with identifiers
				{ createTestForm("integer", "5"), true },
				{ createTestForm("integer", "5.0"), true },
				{ createTestForm("integer", "true"), false },
				{ createTestForm("integer", "\"String\""), false },
				{ createTestForm("float", "5"), true },
				{ createTestForm("float", "5.0"), true },
				{ createTestForm("float", "true"), false },
				{ createTestForm("float", "\"String\""), false },
				{ createTestForm("money", "5"), true },
				{ createTestForm("money", "5.0"), true },
				{ createTestForm("money", "true"), false },
				{ createTestForm("money", "\"String\""), false },
				{ createTestForm("string", "5"), false },
				{ createTestForm("string", "5.0"), false },
				{ createTestForm("string", "true"), false },
				{ createTestForm("string", "\"String\""), true },
				{ createTestForm("boolean", "5"), false },
				{ createTestForm("boolean", "5.0"), false },
				{ createTestForm("boolean", "true"), true },
				{ createTestForm("boolean", "\"String\""), false },
			});
	}

	private ASTNode inputNode;
	private boolean expected;

	private Parser formParser = new Parser();
	private TypeEnvironment register = new TypeEnvironment();

	public TestNotEqual(String input, boolean expected) {
		System.out.println("Testing: " + input);

		register = new TypeEnvironment();

		inputNode = formParser.parse(input);
		this.expected = expected;
	}

	@BeforeClass
	public static void printHeader() {
		System.out.println("=========================");
		System.out.println("*** Testing Not Equal ***");
		System.out.println("=========================");
	}

	@Test
	public void test() {
		assertEquals(expected, TypeChecker.check(inputNode, register));
	}
}