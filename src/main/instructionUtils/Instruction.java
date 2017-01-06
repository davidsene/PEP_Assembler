package main.instructionUtils;

import main.exception.AssemblerException;
import main.syntaxe.Categorie;
import main.syntaxe.InstructionLabel;

public abstract class Instruction {
	
	
	/**
	 * The categorie of the instruction
	 */
	private Categorie categorie;
	
	
	
	/**The concrete operation in the instruction
	 * 
	 */
	private InstructionLabel concreteOperation;
	
	
	
	/**
	 * The binary string representation of the instruction
	 */
	private String binaryStringCode;
	
	
	
	/**
	 * Constructor 
	 * 
	 * @param categorie
	 * @param concreteOperation
	 * @throws AssemblerException
	 */
	public Instruction(Categorie categorie, InstructionLabel concreteOperation) throws AssemblerException{
		
		if( concreteOperation != null && concreteOperation.getCategorie() != categorie)
			throw new RuntimeException("Unmatiching instruction et Categorie");
		this.setCategorie(categorie);
		this.setConcreteOperation(concreteOperation);
	}
	
	
	
	/**
	 * Build the binary string representation of the instruction
	 */
	public abstract void BuildBinaryStringcode();
	
	
	
	/**
	 * @return The binary string representation of the instruction
	 */
	public String toBinCode() {
		
		this.BuildBinaryStringcode();
		return this.getBinaryStringCode(); 
	}
	
	
	
	/**
	 * @return the hexadecimal string representation of the instruction
	 */
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

	
	
	/**
	 * @return The categorie of the instruction
	 */
	public Categorie getCategorie() {
		return this.categorie;
	}
	
	
	
	/**
	 * @return the binary string code value
	 */
	public String getBinaryStringCode() {
		return binaryStringCode;
	}
	
	

	/**
	 * Set the categorie
	 * 
	 * @param categorie
	 * @throws AssemblerException
	 */
	protected void setCategorie(Categorie categorie) throws AssemblerException {
		if( categorie == null )
			 throw new RuntimeException("Categorie Code setting Error");
		this.categorie = categorie;
	}

	

	/**
	 * @return Get the concrete operation of the instruction
	 */
	protected InstructionLabel getConcreteOperation() {
		return concreteOperation;
	}


	
	/**
	 * Set the concrete operation of the instruction
	 * 
	 * @param concreteOperation
	 */
	protected void setConcreteOperation(InstructionLabel concreteOperation) {
		if( concreteOperation == null )
			 throw new RuntimeException("Concrete Operation setting Error");
		this.concreteOperation = concreteOperation;
	}


	
	/**
	 * Set the binary String Code value
	 * 
	 * @param binaryStringCode
	 */
	protected void setBinaryStringCode(String binaryStringCode) {
		
		if (binaryStringCode == null || binaryStringCode.length()!=16) {
			throw new RuntimeException("binary String Code setting Error");
		}
		this.binaryStringCode = binaryStringCode;
	}
	
	
	
	/**
	 * Normalize a binary string code to a given number of bits
	 * 
	 * @param word
	 * @param nbBits
	 * @return
	 */
	public static String normaliseTo_N_Bits(String word, int nbBits){
		if ( word == null || word.length()> nbBits || nbBits>16)
			throw new RuntimeException("Normalizing Error");
		
		word = "0000000000000000" + word;
		return word.substring(word.length()-nbBits);
	}
	
	
}