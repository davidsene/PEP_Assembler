package test;


import org.junit.Assert;
import org.junit.Test;

import main.AssemblerException;
import main.InstructionLabel;
import main.Register;
import main.instructionUtils.*;

public class TestPrincipal {
	
  //Test de la normalization
	//Tester les instruction de la categorie A1
	

	@Test
	public void InstructionCategorieA1test() throws AssemblerException {
		
		Instruction instruction = new InstrCategorieA1(InstructionLabel.LSL, Register.R2, Register.R4, "#8");
		
		Assert.assertEquals("0222", instruction.toHexCode());
	
		//TODO Faire la meme chose pour LSR ET ASR
		
	}

}
