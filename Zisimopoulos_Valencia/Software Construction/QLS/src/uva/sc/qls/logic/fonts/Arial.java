package uva.sc.qls.logic.fonts;

import uva.sc.qls.ast.INodeVisitor;

public class Arial implements FontType{

	public java.lang.String toString() {
		return "[FontType]: Arial";
	}

	public boolean equals(FontType type) {
		if(type == null) {
			return false;
		}
		if(type instanceof Arial) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
