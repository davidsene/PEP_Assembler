package main;

public enum InstructionLabel {
	
	LSLI("000",Categorie.A1),
	LSRI("001",Categorie.A1),
	ASRI("010",Categorie.A1),
	ADD("01100",Categorie.A2), 
	SUB("01101",Categorie.A2);
	
	
	private String codeOp;
	
	
	private Categorie categorie;
	
	
	private InstructionLabel(String codeOp, Categorie cat){
		this.codeOp = codeOp;
		this.categorie=cat;
	}
	
	
	public String getCodeOp(){
		return this.codeOp;
	}
	
	
	public Categorie getCategorie() {
		return categorie;
	}

	
	public static InstructionLabel  getInstructionLabel(String label) throws AssemblerException{
		
		switch (label) {
			case "LSLI": return LSLI;
			case "LSRI": return LSRI;
			case "ASRI": return ASRI;
			case "ADD": return ADD;
			case "SUB": return SUB;
			
			default:
				return null;
			}	
	}
	
}
