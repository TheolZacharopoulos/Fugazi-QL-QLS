package cons.ql.ast.statement;

import cons.TypeRegister;
import cons.ql.ast.Statement;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.visitor.Visitor;

public class Question extends Statement {	
	private final Identifier identifier;
	private final QLType type;
	private final StringLiteral questionText;
	
	public Question(Identifier identifier, QLType type, StringLiteral questionText) {
		this.identifier = identifier;
		this.type = type;
		this.questionText = questionText;
		
		TypeRegister.getInstance().store(this.identifier, this.getType());
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
	
	public QLType getType() {
		return this.type;
	}
	
	public StringLiteral getText() {
		return this.questionText;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Question(");
		
		sb.append(getIdentifier().toString() + ", ");
		sb.append(getType().toString() + ", ");
		sb.append(getText().toString());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
