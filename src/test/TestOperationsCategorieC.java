package test;


import org.junit.Assert;
import org.junit.Test;

import main.AssemblerException;
import main.InstructionLabel;
import main.Register;
import main.instructionUtils.*;

public class TestOperationsCategorieC {
	
	
	@Test
	public void InstructionCategorieCtest() throws AssemblerException {
		
		Instruction instruction1 = new InstrCategorieC(InstructionLabel.LDR, Register.R6, "#232");
		Instruction instruction2 = new InstrCategorieC(InstructionLabel.STR, Register.R7, "#23");

		Assert.assertEquals("9ee8", instruction1.toHexCode());
		Assert.assertEquals("9717", instruction2.toHexCode());
		
	}

}
