package main;

public enum InstructionLabel {
	
	LSLI("000",Categorie.A1),
	LSRI("001",Categorie.A1),
	ASRI("010",Categorie.A1),
	
	ADD("01100",Categorie.A2), 
	SUB("01101",Categorie.A2),
	
	MOV("100",Categorie.A3),
	
	//B1
	AND("0000",Categorie.B),
	EOR("0001",Categorie.B),
	LSL("0010",Categorie.B),
	LSR("0011",Categorie.B),
	ASR("0100",Categorie.B),
	ADC("0101",Categorie.B),
	SUBC("0110",Categorie.B),
	ROR("0111",Categorie.B),
	ORR("1100",Categorie.B),
	BIC("1110",Categorie.B),
	//B2
	TST("1000",Categorie.B),
	CMP("1010",Categorie.B),
	CMN("1011",Categorie.B),
	//B3
	RSB("1001",Categorie.B),
	MVN("1111",Categorie.B),
	//B
	MUL("1101",Categorie.B),
	
	//C
	LDR("1",Categorie.C),
	STR("0",Categorie.C);
	
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
			case "AND": return AND;
			case "EOR": return EOR;
			case "MOV": return MOV;
			case "LSL": return LSL;
			case "LSR": return LSR;
			case "ASR": return ASR;
			case "ADC": return ADC;
			case "SUBC": return SUBC;
			case "ROR": return ROR;
			case "TST": return TST;
			case "RSB": return RSB;
			case "CMP": return CMP;
			case "CMN": return CMN;
			case "ORR": return ORR;
			case "MUL": return MUL;
			case "BIC": return BIC;
			case "MVN": return MVN;
			case "LDR": return LDR;
			case "STR": return STR;
			
			
			default:
				return null;
			}	
	}
	
}
