package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.Literal;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.visitor.Visitor;
import cons.value.FloatValue;

public class FloatLiteral extends Literal<FloatValue> {	

	public FloatLiteral(float value) {
		super(new FloatValue(value));
	}
	
	@Override
	public QLType getType() {
		return new QLFloat();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}

	
}
