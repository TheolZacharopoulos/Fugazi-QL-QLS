package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class OrOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) throws InvalidOperandException {
        if (!(one instanceof BooleanResult) || !(two instanceof BooleanResult)) {
            throw new InvalidOperandException();
        } else {
            BooleanResult intResultOne = (BooleanResult) one;
            BooleanResult intResultTwo = (BooleanResult) two;
            return intResultOne.or(intResultTwo);
        }
    }

    @Override
    public String getOperatorString() {
        return "||";
    }

    @Override
    public Operator getNewOperatorOfThisType() {
        return new OrOperator();
    }
}
