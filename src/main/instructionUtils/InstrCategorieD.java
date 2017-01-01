package main.instructionUtils;

import main.AssemblerException;
import main.BranchingCondition;
import main.Categorie;
import main.InstructionLabel;

public class InstrCategorieD extends Instruction {
	
	private String imm8;
	
	private BranchingCondition branchingCondition;
	

	public InstrCategorieD(InstructionLabel concreteOperation, BranchingCondition bCondition , String imm8) throws AssemblerException {
		super(Categorie.A3,concreteOperation);
		this.setImm8(imm8);
		this.setBranchingCondition(bCondition);
	
	}

	
	private void setImm8(String imm8) throws AssemblerException {
		
		if (imm8 == null ) {
			 throw new RuntimeException("Trying to Set a null value for imm8");
		}
		
		if( ! imm8.trim().startsWith("#") )
			throw new AssemblerException("Syntax Error : Bad Imm8 Syntax : Not Starting with '#' ", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		
		try {
			
			int val = Integer.parseUnsignedInt(imm8.substring(1),10);
			
			if (val>255 ) 
				throw new AssemblerException("Syntax Error : Imm8 value Out of Bound ", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
			 
			this.imm8 = Instruction.normaliseTo_N_Bits(Integer.toBinaryString(val),8);
			
		} 
		catch (NumberFormatException e) {
			
			 throw new AssemblerException("Syntax Error : Bad Imm8 value Format ", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
	
	}
	
	
	
	public void setBranchingCondition(BranchingCondition branchingCondition) {
		if (branchingCondition== null ) {
			 throw new RuntimeException("Trying to Set a null value for branchingCondition");
		}
		this.branchingCondition = branchingCondition;
	}


	@Override
	public void BuildBinaryStringcode() {
		String binaryCode =  new StringBuilder()
	             .append(this.getCategorie().getCode())
	             .append(this.getConcreteOperation().getCodeOp())
	             .append(this.branchingCondition.getCodeOpCond())
	             .append(this.imm8)
	             .toString();
        this.setBinaryStringCode(binaryCode);
		
	}

}
