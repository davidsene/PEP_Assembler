package main.instructionUtils;

import main.exception.AssemblerException;
import main.syntaxe.Categorie;
import main.syntaxe.InstructionLabel;
import main.syntaxe.Register;

public class InstrCategorieA3 extends Instruction {
	
	
	/**
	 * Imm8 value
	 */
	private String imm8;
	
	
	/**
	 * The destination register
	 */
	private Register Rd;
	

	
	/**
	 * Constructor
	 * 
	 * @param concreteOperation
	 * @param rd
	 * @param imm8
	 * @throws AssemblerException
	 */
	public InstrCategorieA3(InstructionLabel concreteOperation,Register rd , String imm8) throws AssemblerException {
		super(Categorie.A3,concreteOperation);
		this.setImm8(imm8);
		this.setRd(rd);	
	}

	
	
	/**
	 * Set Imm8 value
	 * 
	 * @param imm8
	 * @throws AssemblerException
	 */
	private void setImm8(String imm8) throws AssemblerException {
		
		if (imm8 == null ) {
			 throw new RuntimeException("Trying to Set a null value for imm8");
		}
		
		if( ! imm8.trim().startsWith("#") )
			throw new AssemblerException("Syntax Error : Bad Imm8 Syntax : Not Starting with '#' ", AssemblerException.ERR_LAUNCHER_ASM_PROGRAM_FAILED);
		
		try {
			
			
			int val = Integer.parseInt(imm8.substring(1),10);
			
			if (val>127 || val<-128 ) 
				throw new AssemblerException("Syntax Error : Imm8 value Out of Bound ", AssemblerException.ERR_LAUNCHER_ASM_PROGRAM_FAILED);
			 
			String Imm8BinaryOnNededNumberOfBits = Integer.toBinaryString(val);
			Imm8BinaryOnNededNumberOfBits= "00000000"+Imm8BinaryOnNededNumberOfBits;
			String ImmBinaryValueOn8Bits = Imm8BinaryOnNededNumberOfBits.substring(Imm8BinaryOnNededNumberOfBits.length()-8,Imm8BinaryOnNededNumberOfBits.length());
			this.imm8 = Instruction.normaliseTo_N_Bits(ImmBinaryValueOn8Bits,8);
			
		} 
		catch (NumberFormatException e) {
			
			 throw new AssemblerException("Syntax Error : Bad Imm8 value Format ", AssemblerException.ERR_LAUNCHER_ASM_PROGRAM_FAILED);
		}
	
	}
	
	
	
	/**
	 * Set Rd register value
	 * 
	 * @param rd
	 * @throws AssemblerException
	 */
	public void setRd(Register rd) throws AssemblerException {
		if (rd == null ) {
			throw new RuntimeException("Trying to Set a null value in a Rd register");
		}
		Rd = rd;
	}
	
	
	
	/* (non-Javadoc)
	 * @see main.instructionUtils.Instruction#BuildBinaryStringcode()
	 */
	@Override
	public void BuildBinaryStringcode() {
		String binaryCode =  new StringBuilder()
	             .append(this.getCategorie().getCode())
	             .append(this.getConcreteOperation().getCodeOp())
	             .append(this.Rd.toBinaryString())
	             .append(this.imm8)
	             .toString();
        this.setBinaryStringCode(binaryCode);
	}

}
