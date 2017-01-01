package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;
import main.Register;

public class InstrCategorieA3 extends Instruction {
	
	private String imm8;
	
	private Register Rd;
	

	public InstrCategorieA3(InstructionLabel concreteOperation,Register rd , String imm8) throws AssemblerException {
		super(Categorie.A3,concreteOperation);
		this.setImm8(imm8);
		this.setRd(rd);
		
		
	}

	
	private void setImm8(String imm8) throws AssemblerException {
		
		if (imm8 == null ) {
			 throw new RuntimeException("Trying to Set a null value for imm8");
		}
		
		if( ! imm8.trim().startsWith("#") )
			throw new AssemblerException("Syntax Error : Bad Imm8 Syntax : Not Starting with '#' ", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		
		try {
			
			
			int val = Integer.parseInt(imm8.substring(1),10);
			
			if (val>127 || val<-128 ) 
				throw new AssemblerException("Syntax Error : Imm8 value Out of Bound ", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
			 
			String Imm8BinaryOnNededNumberOfBits = Integer.toBinaryString(val);
			Imm8BinaryOnNededNumberOfBits= "00000000"+Imm8BinaryOnNededNumberOfBits;
			String ImmBinaryValueOn8Bits = Imm8BinaryOnNededNumberOfBits.substring(Imm8BinaryOnNededNumberOfBits.length()-8,Imm8BinaryOnNededNumberOfBits.length());
			this.imm8 = Instruction.normaliseTo_N_Bits(ImmBinaryValueOn8Bits,8);
			
		} 
		catch (NumberFormatException e) {
			
			 throw new AssemblerException("Syntax Error : Bad Imm8 value Format ", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
	
	}
	
	
	public void setRd(Register rd) throws AssemblerException {
		if (rd == null ) {
			throw new RuntimeException("Trying to Set a null value in a Rd register");
		}
		Rd = rd;
	}
	
	
	
	

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
