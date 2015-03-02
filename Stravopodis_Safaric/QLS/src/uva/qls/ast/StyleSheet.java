package uva.qls.ast;

public class StyleSheet extends ASTNode {
	
	private Identifier identifier;
	private List<Page> page; 
	
	public StyleSheet (Identifier _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier=_identifier;
	}
	
	public StyleSheet (Identifier _identifier, List<Page> _page CodeLines _codeLines) {
		super(_codeLines);
		this.identifier=_identifier;
		this.page=_page;
	}
	
	public Identifier getIdentifier(){
		return this.identifier;
	}
	public List<Page> getPage(){
		return this.page;
	}
	public CodeLines getCodeLines(){
		return this.codeLines;
	}

	@Override
	public GenericValue<?> evaluate() {
		return null;
	}
	@Override
	public String toString(){
		return "StyleSheet(" + this.identifier.toString() + "," + page.toString() + ")";
	}
}
