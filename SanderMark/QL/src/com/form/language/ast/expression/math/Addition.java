package com.form.language.ast.expression.math;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.IntValue;
import com.form.language.error.Error;
import com.form.language.memory.Context;

public class Addition extends BinaryExpression implements Expression {
	
	public Addition(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}

	@Override
	public IntValue evaluate(Context context) {
		return new IntValue(((IntValue)super.left.evaluate(context)).getValue() + ((IntValue)super.right.evaluate(context)).getValue());
	}

	@Override
	public Type getType(Context context) {
		Type leftType = left.getType(context);
		Type rightType = right.getType(context);
		if(leftType.isIntType() && rightType.isIntType()){
			return new IntType();
		}
		else{
			if(!(leftType.isErrorType() || rightType.isErrorType())){
				context.addError(new Error(tokenInfo, "Expected Int + Int, but found " + leftType + " + " + rightType));
			}
			return new ErrorType();
		}
	}
}
