package main.instructionUtils;

import main.exception.AssemblerException;
import main.syntaxe.Categorie;
import main.syntaxe.InstructionLabel;
import main.syntaxe.Register;

public class InstrCategorieB extends Instruction {
	
	
	/**
	 * The register declared at position 0 
	 */
	private Register regPos0;
	
	/**
	 * The register declared at position 1
	 */
	private Register regPos1;
	

	/**
	 * Constructor
	 * 
	 * @param concreteOperation
	 * @param regPos0
	 * @param regPos1
	 * @throws AssemblerException
	 */
	public InstrCategorieB(InstructionLabel concreteOperation, Register regPos0 ,Register regPos1) throws AssemblerException {
		super(Categorie.B, concreteOperation);
		this.setRegPos0(regPos0);
		this.setRegPos1(regPos1);
	}

	
	
	
	/**
	 * Set the value of the register declared at position 0
	 * 
	 * @param r0
	 * @throws AssemblerException
	 */
	public void setRegPos0(Register r0) throws AssemblerException {
		
		if (r0 == null ) {
			throw new RuntimeException("Trying to Set a null value in a register");
		}
		this.regPos0 = r0;
	}

	
	
	
	/**
	 * Set the value of the register declared at position 1
	 * 
	 * @param r1
	 * @throws AssemblerException
	 */
	public void setRegPos1(Register r1) throws AssemblerException {
		
		if (r1 == null ) {
			throw new RuntimeException("Trying to Set a null value in a register");
		}
		
		this.regPos1 = r1;
	}
	
	
	

	/* (non-Javadoc)
	 * @see main.instructionUtils.Instruction#BuildBinaryStringcode()
	 */
	@Override
	public void BuildBinaryStringcode() {
		String binaryCode =  new StringBuilder()
	             .append(this.getCategorie().getCode())
	             .append(this.getConcreteOperation().getCodeOp())
	             .append(this.regPos1.toBinaryString())
	             .append(this.regPos0.toBinaryString())
	             .toString();
       this.setBinaryStringCode(binaryCode);	
	}
	
}
