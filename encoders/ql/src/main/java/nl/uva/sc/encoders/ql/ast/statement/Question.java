package nl.uva.sc.encoders.ql.ast.statement;

import java.util.Collection;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.type.DataType;

/**
 * Represents a question in the {@link Questionnaire}
 */
public class Question extends Statement {

	private final String name;

	private final DataType type;

	private final String questionLabel;

	private final Expression condition;

	private final Expression computed;

	public Question(TextLocation textLocation, String name, DataType type, String questionLabel, Expression condition,
			Expression computed) {
		super(textLocation);
		this.name = name;
		this.type = type;
		this.questionLabel = questionLabel;
		this.condition = condition;
		this.computed = computed;
	}

	public String getName() {
		return name;
	}

	public DataType getDataType() {
		return type;
	}

	public String getQuestionLabel() {
		return questionLabel;
	}

	public Expression getCondition() {
		return condition;
	}

	public Expression getComputed() {
		return computed;
	}

	@Override
	public String toString() {
		return name.toString();
	}

	@Override
	public void collectQuestions(Collection<Question> questions) {
		questions.add(this);
	}
}
