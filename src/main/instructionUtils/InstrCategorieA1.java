package main.instructionUtils;

import main.exception.AssemblerException;
import main.syntaxe.Categorie;
import main.syntaxe.InstructionLabel;
import main.syntaxe.Register;

public class InstrCategorieA1 extends Instruction {
	
	
	/**
	 * The immediate on 5 bits
	 */
	private String imm5;
	
	
	
	/**
	 * The Rm register 
	 */
	private Register Rm;
	
	
	
	/**
	 * The Rn register
	 */
	private Register Rd;
	
	
	
	/**
	 * Constructor
	 * 
	 * @param concreteOperation
	 * @param rd
	 * @param rm
	 * @param imm5
	 * @throws AssemblerException
	 */
	public InstrCategorieA1( InstructionLabel concreteOperation, Register rd, Register rm, String imm5) throws AssemblerException{
		super(Categorie.A1, concreteOperation);
		this.setImm5(imm5);
		this.setRd(rd);
		this.setRm(rm);
	}

	
	
	/**
	 * Set imm5 value
	 * 
	 * @param imm5
	 * @throws AssemblerException
	 */
	private void setImm5(String imm5) throws AssemblerException {
		
		if (imm5 == null ) {
			 throw new RuntimeException("Trying to Set a null value for imm5");
		}
		
		if( ! imm5.trim().startsWith("#") )
			throw new AssemblerException("Syntax Error : Bad Imm5 Syntax : Not Starting with '#' ", AssemblerException.ERR_LAUNCHER_ASM_PROGRAM_FAILED);
		
		try {
			
			int val = Integer.parseUnsignedInt(imm5.substring(1));
			
			if (val>31 ) 
				throw new AssemblerException("Syntax Error : Imm5 value Out of Bound ", AssemblerException.ERR_LAUNCHER_ASM_PROGRAM_FAILED);
			 
			this.imm5 = Instruction.normaliseTo_N_Bits(Integer.toBinaryString(val),5);
			
		} 
		catch (NumberFormatException e) {
			
			 throw new AssemblerException("Syntax Error : Bad Imm5 value Format ", AssemblerException.ERR_LAUNCHER_ASM_PROGRAM_FAILED);
		}
	
	}


	
	/**
	 * Set Rm register Value
	 * 
	 * @param rm
	 * @throws AssemblerException
	 */
	private void setRm(Register rm) throws AssemblerException {
		if (rm == null ) {
			 throw new RuntimeException("Trying to Set a null value in a Rm register");
		}
		
		Rm = rm;
	}


	
	/**
	 * Set rn register Value
	 * 
	 * @param rd
	 * @throws AssemblerException
	 */
	private void setRd(Register rd) throws AssemblerException {
		if (rd == null ) {
			 throw new RuntimeException("Trying to Set a null value in a Rd register");
		}
		
		Rd =  rd;
	}


	
	
	/* (non-Javadoc)
	 * @see main.instructionUtils.Instruction#BuildBinaryStringcode()
	 */
	@Override
	public void BuildBinaryStringcode() {
		
		String binaryCode =  new StringBuilder()
				             .append(this.getCategorie().getCode())
				             .append(this.getConcreteOperation().getCodeOp())
				             .append(this.imm5)
				             .append(this.Rm.toBinaryString())
				             .append(this.Rd.toBinaryString())
				              .toString();
	   this.setBinaryStringCode(binaryCode);
	}
	
	
	

	

}
