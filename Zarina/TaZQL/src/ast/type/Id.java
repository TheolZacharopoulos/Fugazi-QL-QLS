package ast.type;


public class Id {
//extends Testik {

	private String id;
	
	public Id(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
/*
	@Override
	public String toString() {
		return id;
	}
*/	/*
	@Override
	public <T> T accept(IMainVisitor<T> visitor) {
		return visitor.visit(this);
	}
	*/
}

