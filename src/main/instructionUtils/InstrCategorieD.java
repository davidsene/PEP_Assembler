package main.instructionUtils;

import main.exception.AssemblerException;
import main.instructionUtils.label.Label;
import main.syntaxe.Categorie;
import main.syntaxe.InstructionLabel;

public class InstrCategorieD extends Instruction {
	
	
	/**
	 * The bounded Label object
	 */
	private Label label;
	
	
	
	/**
	 * The previous label name used before bounding the instruction with the matching Label object
	 */
	private String labProvName;
	
	
	
	/**
	 * The position of the instruction in the program file
	 */
	private int lineNumber; //A little help for debuging
	

	
	/**
	 * Constructor
	 * 
	 * @param concreteOperation
	 * @param lpName
	 * @throws AssemblerException
	 */
	public InstrCategorieD(InstructionLabel concreteOperation,String lpName) throws AssemblerException {
		super(Categorie.D,concreteOperation);
		this.setLabProvName(lpName);
	}

	
	

	/**
	 * Set the label value
	 * 
	 * @param lab
	 */
	public void setLabel(Label lab) {
		
		if (lab == null) {
			throw new RuntimeException("trying to set null value for label");
		}
	    this.label = lab;
     }


	

	/**
	 * @return The instruction's previous label name
	 */
	public String getLabProvName() {
		return labProvName;
	}


	

	/**
	 * Set the instruction's previous label name
	 * 
	 * @param lpn
	 * @throws AssemblerException
	 */
	public void setLabProvName(String lpn) throws AssemblerException {
		
		if ( lpn == null) {
			throw new RuntimeException("trying to set null value for label provisory name");
		}
		
		if(lpn.isEmpty())
			throw new AssemblerException("Syntax Error : A label branching name in a branchement can't be empty ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		
		this.labProvName = lpn;
	}

	

	/* (non-Javadoc)
	 * @see main.instructionUtils.Instruction#BuildBinaryStringcode()
	 */
	@Override
	public void BuildBinaryStringcode() {
		String binaryCode =  new StringBuilder()
	             .append(this.getCategorie().getCode())
	             .append(this.getConcreteOperation().getCodeOp())
	             .append(this.label.getAdressAsBinaryString())
	             .toString();
        this.setBinaryStringCode(binaryCode);
		
	}

	

	/**
	 * @return The position of the instruction in the program file
	 */
	public int getLineNumber() {
		return lineNumber;
	}



	/**
	 * Set the position of the instruction in the program file
	 * 
	 * @param lineNumber
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

}
