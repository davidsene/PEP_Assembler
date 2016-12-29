package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;
import main.Register;

public class InstrCategorieB extends Instruction {
	
	
	private Register regPos0;
	
	private Register regPos1;
	

	public InstrCategorieB(InstructionLabel concreteOperation, Register regPos0 ,Register regPos1) throws AssemblerException {
		super(Categorie.B, concreteOperation);
		this.setRegPos0(regPos0);
		this.setRegPos1(regPos1);
	}


	@Override
	public void BuildBinaryStringcode() {
		String binaryCode =  new StringBuilder()
	             .append(this.getCategorie().getCode())
	             .append(this.getConcreteOperation().getCodeOp())
	             .append(this.regPos1.toBinaryString())
	             .append(this.regPos0.toBinaryString())
	             .toString();
       this.setBinaryStringCode(binaryCode);
		
	}

	
	public void setRegPos0(Register r0) throws AssemblerException {
		
		if (r0 == null ) {
			throw new RuntimeException("Trying to Set a null value in a register");
		}
		this.regPos0 = r0;
	}

	
	public void setRegPos1(Register r1) throws AssemblerException {
		
		if (r1 == null ) {
			throw new RuntimeException("Trying to Set a null value in a register");
		}
		
		this.regPos1 = r1;
	}
	
}
