package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;
import main.Register;

public class InstrCategorieC extends Instruction {
	
	private String imm8;
	
	private Register Rd;
	

	public InstrCategorieC(InstructionLabel concreteOperation,Register rd , String imm8) throws AssemblerException {
		super(Categorie.C,concreteOperation);
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
			
			int val = Integer.parseUnsignedInt(imm8.substring(1));
			
			if (val>255 ) 
				throw new AssemblerException("Syntax Error : Imm8 value Out of Bound ", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
			 
			this.imm8 = Instruction.normaliseTo_N_Bits(Integer.toBinaryString(val),8);
			
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
