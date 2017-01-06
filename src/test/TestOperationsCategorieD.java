package test;


import org.junit.Assert;
import org.junit.Test;

import main.exception.AssemblerException;
import main.instructionUtils.*;
import main.instructionUtils.label.Label;
import main.syntaxe.InstructionLabel;


public class TestOperationsCategorieD {
	
	
	@Test
	public void InstructionCategorieDtest() throws AssemblerException {
		
		Label label1 = new Label("dav",5);
		Label label2 = new Label("dav",255);
		Label label3 = new Label("dav",0);
		
		InstrCategorieD instruction1 = new InstrCategorieD(InstructionLabel.BE, label1.getName());
		instruction1.setLabel(label1);
		InstrCategorieD instruction2 = new InstrCategorieD(InstructionLabel.BNE, label2.getName());
		instruction2.setLabel(label2);
		InstrCategorieD instruction3 = new InstrCategorieD(InstructionLabel.B, label3.getName());
		instruction3.setLabel(label3);
		
		Assert.assertEquals("d005", instruction1.toHexCode());
		Assert.assertEquals("d1ff", instruction2.toHexCode());
		Assert.assertEquals("de00", instruction3.toHexCode());
	}

}
