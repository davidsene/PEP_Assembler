package test;


import org.junit.Assert;
import org.junit.Test;

import main.AssemblerException;
import main.InstructionLabel;
import main.Register;
import main.instructionUtils.*;

public class TestPrincipal {
	
	
	@Test
	public void InstructionCategorieA1test() throws AssemblerException {
		
		Instruction instruction1 = new InstrCategorieA1(InstructionLabel.LSLI, Register.R2, Register.R4, "#8");
		
		Instruction instruction2 = new InstrCategorieA1(InstructionLabel.LSRI, Register.R7, Register.R3, "#31");
		
		Instruction instruction3 = new InstrCategorieA1(InstructionLabel.ASRI, Register.R5, Register.R7, "#15");
		
		
		Assert.assertEquals("0222", instruction1.toHexCode());  
		Assert.assertEquals("0fdf", instruction2.toHexCode());
		Assert.assertEquals("13fd", instruction3.toHexCode());
	
		
	}
	
	
	@Test
	public void InstructionCategorieA2test() throws AssemblerException {
		
		Instruction instruction1 = new InstrCategorieA2(InstructionLabel.ADD, Register.R7, Register.R4,  Register.R4);
		
		Instruction instruction2 = new InstrCategorieA2(InstructionLabel.SUB, Register.R6, Register.R3,  Register.R2);
		
		//0001 1010 1001 1110
		
		Assert.assertEquals("1927", instruction1.toHexCode());
		Assert.assertEquals("1a9e", instruction2.toHexCode());
	
		
	}

}
