package nl.uva.se.ql.gui.builders;

import javafx.scene.Node;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.type.BooleanType;
import nl.uva.se.ql.ast.type.DecimalType;
import nl.uva.se.ql.ast.type.IntegerType;
import nl.uva.se.ql.ast.type.StringType;
import nl.uva.se.ql.ast.type.TypeVisitor;
import nl.uva.se.ql.ast.type.UndefinedType;
import nl.uva.se.ql.gui.widgets.questions.BooleanQuestion;
import nl.uva.se.ql.gui.widgets.questions.DecimalQuestion;
import nl.uva.se.ql.gui.widgets.questions.IntegerQuestion;
import nl.uva.se.ql.gui.widgets.questions.TextQuestion;
import nl.uva.se.ql.gui.widgets.questions.UndefinedQuestion;

public class QuestionBuilder implements TypeVisitor<Node> {

	private final Question question;

	public QuestionBuilder(Question question) {
		this.question = question;
	}

	@Override
	public Node visit(BooleanType booleanType) {
		return new BooleanQuestion(this.question);
	}

	@Override
	public Node visit(DecimalType decimalType) {
		return new DecimalQuestion(this.question);
	}

	@Override
	public Node visit(IntegerType integerType) {
		return new IntegerQuestion(this.question);
	}

	@Override
	public Node visit(StringType stringType) {
		return new TextQuestion(this.question);
	}

	@Override
	public Node visit(UndefinedType undefinedType) {
		return new UndefinedQuestion(this.question);
	}
}