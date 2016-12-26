package main;

public enum InstructionLabel {
	
	LSL("000",Categorie.A1),
	LSR("001",Categorie.A1),
	ASR("010",Categorie.A1);
	
	//TODO Essaie d'implementer ces trois instructions en te basant sur l'implementation des in struction de la catgorieA1 et sur le documents DataSheetARM_v7 sur Jalon
	
	//ADD("01100",Categorie.A2), 
	//SUB("01101",Categorie.A2),
	//MOV("100",Categorie.A3),
	
	
	
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
			case "LSL": return LSL;
			case "LSR": return LSR;
			case "ASR": return ASR;
			default:
				throw new AssemblerException("Syntax Error Unknow Instruction", AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
			}	
	}
	
	

}
