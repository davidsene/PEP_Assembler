package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;

public class InstrCategorieD extends Instruction {
	
	

	public InstrCategorieD(InstructionLabel concreteOperation) throws AssemblerException {
		super(Categorie.D,concreteOperation);
		// TODO Auto-generated constructor stub
	}

	protected int categorieCode = 0;

	@Override
	public void BuildBinaryStringcode() {
		// TODO Auto-generated method stub
		
	}

	

}
