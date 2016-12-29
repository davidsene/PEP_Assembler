package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;
import main.Register;
import main.Variable;

public class InstrCategorieC extends Instruction {
	
	private Variable variable;
	
	private Register rt;
	

	

	public InstrCategorieC(InstructionLabel concreteOperation, Variable variable, Register rt)throws AssemblerException {
		super(Categorie.C, concreteOperation);
		this.variable = variable;
		this.rt = rt;
	}

	protected int categorieCode = 0;

	
	@Override
	public void BuildBinaryStringcode() {
		String binaryCode =  new StringBuilder()
	             .append(this.getCategorie().getCode())
	             .append(this.getConcreteOperation().getCodeOp())
	             .append(this.rt.toBinaryString())
	             .append(this.variable.getAdressAsBinaryString())
	             .toString();
      this.setBinaryStringCode(binaryCode);
		
	}
	

	public void setVariable(Variable var) {
		
		if (var == null ) {
			throw new RuntimeException("Trying to Set a null value as variable");
		}
		this.variable = var;
	}

	public void setRt(Register r) {
		
		if (r == null ) {
			throw new RuntimeException("Trying to Set a null value in a register ");
		}
		
		this.rt = r;
	}

	
	

}
