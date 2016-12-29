package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;
import main.Register;

public class InstrCategorieA2 extends Instruction {
	
	private Register Rm;
	
	private Register Rn;
	
	private Register Rd;
	
	
	public InstrCategorieA2(InstructionLabel concreteOperation,  Register rd, Register rn, Register rm) throws AssemblerException {
		super(Categorie.A2,concreteOperation);
		this.setRm(rm);
		this.setRn(rn);
		this.setRd(rd);
		this.setConcreteOperation(concreteOperation);
	}



	public void setRm(Register rm) throws AssemblerException {
		if (rm == null ) {
			throw new RuntimeException("Trying to Set a null value in a Rm register");
		}
		
		Rm = rm;
	}


	public void setRn(Register rn) throws AssemblerException {
		
		if (rn == null ) {
			throw new RuntimeException("Trying to Set a null value in a Rn register");
		}
		Rn = rn;
	}



	public void setRd(Register rd) throws AssemblerException {
		if (rd == null ) {
			throw new RuntimeException("Trying to Set a null value in a Rd register");
		}
		Rd = rd;
	}



	@Override
	public void BuildBinaryStringcode() {
		String binaryCode = new StringBuilder()
								.append(this.getCategorie().getCode())
								.append(this.getConcreteOperation().getCodeOp())
								.append(this.Rm.toBinaryString())
								.append(this.Rn.toBinaryString())
								.append(this.Rd.toBinaryString())
								.toString();
		this.setBinaryStringCode(binaryCode);
	}
	
	

}
