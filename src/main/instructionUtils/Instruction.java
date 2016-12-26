package main.instructionUtils;

import main.AssemblerException;

public abstract class Instruction {
	
	public static final String CAT_A_CODE="00";
	public static final String CAT_B_CODE="010000";
	public static final String CAT_C_CODE="0101";
	public static final String CAT_D_CODE="1001"; //To not modify
	
	public static final String LABEL_AND_OPER_SEPARATOR = " ";
	public static final String MULTI_OPER_SEPARATOR = ",";
	
	
	
	
	
	private String categorieCode;
	
	
	private String operationCode;
	
	
	private String binaryStringCode;
	
	
	public Instruction(String opCode) throws AssemblerException{
		this.setOperationCode(opCode);
	}
	
	
	public abstract void BuildBinaryStringcode();
	
	public String toBinCode() {
		this.BuildBinaryStringcode();
		return this.getBinaryStringCode(); 
		
	}
	
	
	public String toHexCode() {
		this.BuildBinaryStringcode();
		String val;
		StringBuilder builder = new StringBuilder("0x");
		for (int i = 0; i <= 12; i=i+4) {
			val = binaryStringCode.substring(i,i+4);
			builder.append(Integer.toHexString(Integer.parseInt(val,2)));
		}
		return builder.toString(); 
		
	}

	
	public String getCategorieCode() {
		return categorieCode;
	}
	
	
	public String getOperationCode() {
		return operationCode;
	}
	
	
	public String getBinaryStringCode() {
		return binaryStringCode;
	}
	
	

	protected void setCategorieCode(String categorieCode) throws AssemblerException {
		if( categorieCode== null || categorieCode.isEmpty() )
			 throw new RuntimeException("Categorie Code setting Error");
		this.categorieCode = categorieCode;
	}

	

	protected void setOperationCode(String operationCode) {
		if( operationCode== null || operationCode.isEmpty() )
			throw new RuntimeException("Operation Code setting Error");
		this.operationCode = operationCode;
	}

	

	protected void setBinaryStringCode(String binaryStringCode) {
		
		if (binaryStringCode == null || binaryStringCode.length()!=16) {
			throw new RuntimeException("binary String Code setting Error");
		}
		this.binaryStringCode = binaryStringCode;
	}
	
	public static String normaliseTo_N_Bits(String word, int nbBits){
		
		if ( word == null || word.length()> nbBits || nbBits>16)
			throw new RuntimeException("Normalizing Error");
		
		word = "0000000000000000" + word;
		return word.substring(word.length()-nbBits);
	}
	
	
}
