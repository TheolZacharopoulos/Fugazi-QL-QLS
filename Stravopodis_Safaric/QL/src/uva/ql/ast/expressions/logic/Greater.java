package uva.ql.ast.expressions.logic;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class Greater extends BinaryExpressions{

	public Greater(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.GREATER, _codeLines);
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}

	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitGreater(this);
	}
	
	@Override
	public BooleanValue evaluate() {
		return new NumberValue((int)this.getLeftExpr().evaluate().getValue()).greater(new NumberValue((int)this.getRightExpr().evaluate().getValue()));
	}
	
	@Override
	public List<Type> getValueType() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public List<Type> getSupportedType() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override 
	public String toString(){
		return this.getLeftExpr() + Operator.GREATER.getName() + this.getRightExpr();
	}
}
