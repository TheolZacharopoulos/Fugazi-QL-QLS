package uva.ql.ast.expressions.logic;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class And extends BinaryExpressions{

	public And(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.AND, _codeLines);
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitAnd(this);
	}
	
	@Override
	public BooleanValue evaluate() {
		return new BooleanValue((boolean)this.getLeftExpr().evaluate().getValue()).and(new BooleanValue((boolean)this.getRightExpr().evaluate().getValue()));
	}
	
	@Override
	public List<Type> getValueType() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public List<Type> getSupportedType() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.AND.getName() + this.getRightExpr();
	}
}
