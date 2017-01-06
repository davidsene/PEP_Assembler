package test;


import org.junit.Assert;
import org.junit.Test;

import main.exception.AssemblerException;
import main.instructionUtils.*;
import main.syntaxe.InstructionLabel;
import main.syntaxe.Register;

public class TestOperationsCategorieB {
	
	
	@Test
	public void InstructionCategorieB1test() throws AssemblerException {
		
		Instruction instruction1 = new InstrCategorieB(InstructionLabel.AND, Register.R7, Register.R6);
		Instruction instruction2 = new InstrCategorieB(InstructionLabel.EOR, Register.R3, Register.R5);
		Instruction instruction3 = new InstrCategorieB(InstructionLabel.LSL, Register.R6, Register.R6);
		Instruction instruction4 = new InstrCategorieB(InstructionLabel.LSR, Register.R4, Register.R3);
		Instruction instruction5 = new InstrCategorieB(InstructionLabel.ASR, Register.R3, Register.R0);
		Instruction instruction6 = new InstrCategorieB(InstructionLabel.ADC, Register.R2, Register.R5);
		Instruction instruction7 = new InstrCategorieB(InstructionLabel.SUBC, Register.R2, Register.R5);
		Instruction instruction8 = new InstrCategorieB(InstructionLabel.ROR, Register.R7, Register.R3);
		Instruction instruction9 = new InstrCategorieB(InstructionLabel.TST, Register.R4, Register.R2);
		Instruction instruction10 = new InstrCategorieB(InstructionLabel.RSB, Register.R2, Register.R2);
		Instruction instruction11 = new InstrCategorieB(InstructionLabel.CMP, Register.R7, Register.R5);
		Instruction instruction12 = new InstrCategorieB(InstructionLabel.CMN, Register.R6, Register.R0);
		Instruction instruction13 = new InstrCategorieB(InstructionLabel.ORR, Register.R4, Register.R0);
		Instruction instruction14 = new InstrCategorieB(InstructionLabel.MUL, Register.R7, Register.R1);
		Instruction instruction15 = new InstrCategorieB(InstructionLabel.BIC, Register.R7, Register.R1);
		Instruction instruction16 = new InstrCategorieB(InstructionLabel.MVN, Register.R5, Register.R6);
		
		Assert.assertEquals("4037", instruction1.toHexCode());
		Assert.assertEquals("406b", instruction2.toHexCode()); 
		Assert.assertEquals("40b6", instruction3.toHexCode()); 
		Assert.assertEquals("40dc", instruction4.toHexCode()); 
		Assert.assertEquals("4103", instruction5.toHexCode());
		Assert.assertEquals("416a", instruction6.toHexCode());
		Assert.assertEquals("41aa", instruction7.toHexCode());
		Assert.assertEquals("41df", instruction8.toHexCode());
		Assert.assertEquals("4214", instruction9.toHexCode());
		Assert.assertEquals("4252", instruction10.toHexCode());
		Assert.assertEquals("42af", instruction11.toHexCode());
		Assert.assertEquals("42c6", instruction12.toHexCode()); 
		Assert.assertEquals("4304", instruction13.toHexCode());
		Assert.assertEquals("434f", instruction14.toHexCode());
		Assert.assertEquals("438f", instruction15.toHexCode());
		Assert.assertEquals("43f5", instruction16.toHexCode());
		
	}
		
}
