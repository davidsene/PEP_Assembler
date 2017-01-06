package main.syntaxe;

import main.exception.AssemblerException;

/**
 * Define the supported instructions and link them to a categorie
 */
public enum InstructionLabel {
	
	//Cat A1
	LSLI("000",Categorie.A1),
	LSRI("001",Categorie.A1),
	ASRI("010",Categorie.A1),
	
	//Cat A2
	ADD("01100",Categorie.A2), 
	SUB("01101",Categorie.A2),
	
	//Cat A3
	MOV("100",Categorie.A3),
	
	////Cat B
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
	TST("1000",Categorie.B),
	CMP("1010",Categorie.B),
	CMN("1011",Categorie.B),
	RSB("1001",Categorie.B),
	MVN("1111",Categorie.B),
	MUL("1101",Categorie.B),
	
	//Cat C
	LDR("1",Categorie.C),
	STR("0",Categorie.C),
	
	//Cat D
	BE("0000",Categorie.D),
	BNE("0001",Categorie.D),
	B("1110",Categorie.D),
	MI("0100",Categorie.D),
	PL("0101",Categorie.D),
	
	//LABEL
	LABEL("",Categorie.LABEL);
	
	
	/**
	 * The String operation code
	 */
	private String codeOp;
	
	
	/**
	 * the associated categorie of an operation
	 */
	private Categorie categorie;
	
	
	/**
	 * Constructor
	 * 
	 * @param codeOp
	 * @param cat
	 */
	private InstructionLabel(String codeOp, Categorie cat){
		this.codeOp = codeOp;
		this.categorie=cat;
	}
	
	
	/**
	 * @return Get the codeOp of an operation
	 */
	public String getCodeOp(){
		return this.codeOp;
	}
	
	
	/**
	 * @return Get the categorie of an operation
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	
	/**
	 * @param label
	 * @return A operation object form a string code | null if the operation is not defined
	 * @throws AssemblerException
	 */
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
			case "BE": return BE;
			case "BNE": return BNE;
			case "B": return B;
			case "BMI": return MI;
			case "BPL": return PL;
			
			default:
				if(label.endsWith(Syntax.LABEL_DECLARATION_SUFFIX)) return LABEL;
				return null;
			}	
	}
	
}
