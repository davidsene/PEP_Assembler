package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;

public class InstrCategorieC extends Instruction {
	
	

	public InstrCategorieC(InstructionLabel concreteOperation) throws AssemblerException {
		super(Categorie.C,concreteOperation);
		// TODO Auto-generated constructor stub
	}

	protected int categorieCode = 0;

	@Override
	public void BuildBinaryStringcode() {
		// TODO Auto-generated method stub
		
	}

	

}
