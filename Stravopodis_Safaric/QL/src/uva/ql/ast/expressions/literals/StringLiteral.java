package uva.ql.ast.expressions.literals;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.StringValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class StringLiteral extends Literal{
	
	private String value;
	
	public StringLiteral(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	public StringLiteral(String _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public StringValue evaluate() {
		return new StringValue(this.value);
	}
	
	@Override
	public List<Type> getValueType() {
		return Arrays.asList(new TypeString());
	}
	
	@Override
	public List<Type> getSupportedType() {
		return Arrays.asList(new TypeString());
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitStringLiteral(this);	
	}

	@Override
	public String toString(){
		return "StringLiteral(" + this.value + ")";
	}
}
