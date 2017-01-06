package main.instructionUtils.label;

import main.exception.AssemblerException;
import main.instructionUtils.Instruction;
import main.syntaxe.Categorie;
import main.syntaxe.InstructionLabel;

public class Label extends Instruction {
	
	
	/**
	 * The label name
	 */
	private String name;
	
	
	
	/**
	 * The address of the label
	 */
	private int adress;
		
	
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param adress
	 * @throws AssemblerException
	 */
	public Label(String name, int adress) throws AssemblerException{
		super(Categorie.LABEL, InstructionLabel.LABEL);
		this.setName(name);
		this.setAdress(adress);
	}


	
	/**
	 * @return The label's name
	 */
	public String getName() {
		return name;
	}


	
	/**
	 * Set the label's name
	 * 
	 * @param name
	 * @throws AssemblerException
	 */
	public void setName(String name) throws AssemblerException {
		if (name == null ) {
			throw new RuntimeException("Trying to Set a null value label name ");
		}
		
		if(name.isEmpty()){
			
			throw new AssemblerException("Syntax Error : Label Name can't be empty ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		if(name.contains(":")){
			
			throw new AssemblerException("Syntax Error : Label Name can't contains the character ':' ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		this.name = name;
	}


	
	/**
	 * @return The label's address
	 */
	public int getAdress() {
		return adress;
	}


	
	/**
	 * Set the label's address
	 * 
	 * @param adress
	 */
	public void setAdress(int adress) {
		if(adress<0 || adress>255)
			throw new RuntimeException("Label adress out of bound ");
		this.adress = adress;
	}

	
	
	/**
	 * @return The binary normalized string representation of the label's address
	 */
	public String getAdressAsBinaryString(){
		String addr = Integer.toBinaryString(this.adress);
		addr = Instruction.normaliseTo_N_Bits(addr, 8);
		return addr;
	}

	

	/* (non-Javadoc)
	 * @see main.instructionUtils.Instruction#BuildBinaryStringcode()
	 */
	@Override
	public void BuildBinaryStringcode() {
		return;
	}
	
}
