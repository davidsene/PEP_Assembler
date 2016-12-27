package main.instructionUtils;

import main.AssemblerException;
import main.InstructionLabel;
import main.Register;

public class InstrCategorieA1 extends Instruction {
	
	private String imm5;
	
	private Register  Rm;
	
	private Register   Rd;
	
	
	public InstrCategorieA1( InstructionLabel concreteOperation, Register rd, Register rm, String imm5) throws AssemblerException{
		super(concreteOperation);
		this.setCategorieCode(CAT_A_CODE);
		this.setImm5(imm5);
		this.setRd(rd);
		this.setRm(rm);
	}

	
	private void setImm5(String imm5) throws AssemblerException {
		
		if(imm5==null || ! imm5.trim().startsWith("#") )
			throw new AssemblerException("Syntax Error on a imm5 syntax", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		
		try {
			int val = Integer.parseUnsignedInt(imm5.substring(1));
			
			if (val>31 ) 
				throw new AssemblerException("Syntax Error on a imm5 syntax", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
			 
			this.imm5 = Instruction.normaliseTo_N_Bits(Integer.toBinaryString(val),5);
			
		} 
		catch (NumberFormatException e) {
			
			 throw new AssemblerException("Syntax Error on a imm5 syntax", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
	}


	private void setRm(Register rm) throws AssemblerException {
		if (rm == null ) {
			 throw new AssemblerException("Syntax Error on a rm syntax", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
		
		Rm = rm;
	}


	private void setRd(Register rd) throws AssemblerException {
		if (rd == null ) {
			 throw new AssemblerException("Syntax Error on a rd syntax", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
		
		Rd =  rd;
	}


	@Override
	public void BuildBinaryStringcode() {
		
		String binaryCode =  new StringBuilder()
				             .append(this.getCategorieCode())
				             .append(this.getConcreteOperation().getCodeOp())
				             .append(this.imm5)
				             .append(this.Rm.toBinaryString())
				             .append(this.Rd.toBinaryString())
				              .toString();
	   this.setBinaryStringCode(binaryCode);
	}
	
	
	

	

}
