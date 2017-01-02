package test;


import org.junit.Assert;
import org.junit.Test;

import main.AssemblerException;
import main.InstructionLabel;
import main.Register;
import main.instructionUtils.*;
import main.variableUtils.Type;
import main.variableUtils.Variable;

public class TestOperationsCategorieC {
	
	
	@Test
	public void InstructionCategorieCtest() throws AssemblerException {
		
		Instruction instruction1 = new InstrCategorieC(InstructionLabel.LDR, Register.R6, "#232");
		Variable variable = new Variable("test", 2, Type.WORD, 2);
		Instruction instruction11 = new InstrCategorieC(InstructionLabel.LDR, Register.R6, variable.getAdressAsImm8());
		Instruction instruction2 = new InstrCategorieC(InstructionLabel.STR, Register.R7, "#23");
		Assert.assertEquals("9ee8", instruction1.toHexCode());
		Assert.assertEquals("9e02", instruction11.toHexCode());
		Assert.assertEquals("9717", instruction2.toHexCode());
		System.out.println(String.valueOf((short)Integer.parseInt("ffff",16)));
	}

}
