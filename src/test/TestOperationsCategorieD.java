package test;


import org.junit.Assert;
import org.junit.Test;

import main.AssemblerException;
import main.InstructionLabel;
import main.instructionUtils.*;
import main.instructionUtils.label.Label;


public class TestOperationsCategorieD {
	
	
	@Test
	public void InstructionCategorieCtest() throws AssemblerException {
		
		Label label1 = new Label("dav",5);
		Label label2 = new Label("dav",255);
		Label label3 = new Label("dav",0);
		
		InstrCategorieD instruction1 = new InstrCategorieD(InstructionLabel.BE, label1.getName());
		instruction1.setLabel(label1);
		InstrCategorieD instruction2 = new InstrCategorieD(InstructionLabel.BNE, label2.getName());
		instruction2.setLabel(label2);
		InstrCategorieD instruction3 = new InstrCategorieD(InstructionLabel.B, label3.getName());
		instruction3.setLabel(label3);
		//1101 0000 0000 0101
		
		Assert.assertEquals("d005", instruction1.toHexCode());
		Assert.assertEquals("d1ff", instruction2.toHexCode());
		Assert.assertEquals("df00", instruction3.toHexCode());
	}

}
