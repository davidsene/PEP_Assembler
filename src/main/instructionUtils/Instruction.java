package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;

public abstract class Instruction {
	
	public static final String LABEL_AND_OPER_SEPARATOR = " ";
	
	public static final String MULTI_OPER_SEPARATOR = ",";
	
	private Categorie categorie;
	
	
	private InstructionLabel concreteOperation;
	
	
	private String binaryStringCode;
	
	
	public Instruction(Categorie categorie, InstructionLabel concreteOperation) throws AssemblerException{
		
		if( concreteOperation != null && concreteOperation.getCategorie() != categorie)
			throw new RuntimeException("Unmatiching instruction et Categorie");
		this.setCategorie(categorie);
		this.setConcreteOperation(concreteOperation);
	}
	
	
	public abstract void BuildBinaryStringcode();
	
	
	public String toBinCode() {
		
		this.BuildBinaryStringcode();
		return this.getBinaryStringCode(); 
		
	}
	
	
	public String toHexCode() {
		
		this.BuildBinaryStringcode();
		
		String val;
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i <= 12; i=i+4) {
			val = binaryStringCode.substring(i,i+4);
			builder.append(Integer.toHexString(Integer.parseInt(val,2)));
		}
		
		return builder.toString(); 
		
	}

	
	public Categorie getCategorie() {
		return this.categorie;
	}
	
	
	public String getBinaryStringCode() {
		return binaryStringCode;
	}
	
	

	protected void setCategorie(Categorie categorie) throws AssemblerException {
		if( categorie == null )
			 throw new RuntimeException("Categorie Code setting Error");
		this.categorie = categorie;
	}

	

	protected InstructionLabel getConcreteOperation() {
		return concreteOperation;
	}


	protected void setConcreteOperation(InstructionLabel concreteOperation) {
		if( concreteOperation == null )
			 throw new RuntimeException("Concrete Operation setting Error");
		this.concreteOperation = concreteOperation;
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
