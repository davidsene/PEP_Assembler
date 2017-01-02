package main.instructionUtils;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;
import main.instructionUtils.label.Label;

public class InstrCategorieD extends Instruction {
	
	private Label label;
	
	private String labProvName;
	
	private int lineNumber; //A little help for debuging
	

	public InstrCategorieD(InstructionLabel concreteOperation,String lpName) throws AssemblerException {
		super(Categorie.D,concreteOperation);
		this.setLabProvName(lpName);
	}

	

	public void setLabel(Label lab) {
		
		if (lab == null) {
			throw new RuntimeException("trying to set null value for label");
		}
	    this.label = lab;
     }



	public String getLabProvName() {
		return labProvName;
	}



	public void setLabProvName(String lpn) throws AssemblerException {
		
		if ( lpn == null) {
			throw new RuntimeException("trying to set null value for label provisory name");
		}
		
		if(lpn.isEmpty())
			throw new AssemblerException("Syntax Error : A label branching name in a branchement can't be empty ", AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
		
		this.labProvName = lpn;
	}


	@Override
	public void BuildBinaryStringcode() {
		String binaryCode =  new StringBuilder()
	             .append(this.getCategorie().getCode())
	             .append(this.getConcreteOperation().getCodeOp())
	             .append(this.label.getAdressAsBinaryString())
	             .toString();
        this.setBinaryStringCode(binaryCode);
		
	}



	public int getLineNumber() {
		return lineNumber;
	}



	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}



	@Override
	public String toString() {
		return "InstrCategorieD [label=" + label + ", labProvName=" + labProvName + ", lineNumber=" + lineNumber + "]";
	}



	
	

}
