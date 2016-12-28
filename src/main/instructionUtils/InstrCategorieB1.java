package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;

public class InstrCategorieB1 extends Instruction {
	
	

	public InstrCategorieB1(InstructionLabel concreteOperation) throws AssemblerException {
		super(Categorie.B1,concreteOperation);
		// TODO Auto-generated constructor stub
	}

	protected int categorieCode = 0;

	@Override
	public void BuildBinaryStringcode() {
		// TODO Auto-generated method stub
		
	}

}
