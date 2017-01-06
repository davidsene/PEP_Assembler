package main.instructionUtils;

import main.exception.AssemblerException;
import main.syntaxe.Categorie;
import main.syntaxe.InstructionLabel;
import main.syntaxe.Register;

public class InstrCategorieA2 extends Instruction {
	
	/**
	 * The Rm register
	 */
	private Register Rm;
	
	
	/**
	 * The Rn register
	 */
	private Register Rn;
	
	
	/**
	 * The destination register
	 */
	private Register Rd;
	
	
	/**
	 * Constructor
	 * 
	 * @param concreteOperation
	 * @param rd
	 * @param rn
	 * @param rm
	 * @throws AssemblerException
	 */
	public InstrCategorieA2(InstructionLabel concreteOperation,  Register rd, Register rn, Register rm) throws AssemblerException {
		super(Categorie.A2,concreteOperation);
		this.setRm(rm);
		this.setRn(rn);
		this.setRd(rd);
		this.setConcreteOperation(concreteOperation);
	}



	/**
	 * Set Rm register value
	 * 
	 * @param rm
	 * @throws AssemblerException
	 */
	public void setRm(Register rm) throws AssemblerException {
		if (rm == null ) {
			throw new RuntimeException("Trying to Set a null value in a Rm register");
		}
		
		Rm = rm;
	}


	
	/**
	 * Set Rn register value
	 * 
	 * @param rn
	 * @throws AssemblerException
	 */
	public void setRn(Register rn) throws AssemblerException {
		
		if (rn == null ) {
			throw new RuntimeException("Trying to Set a null value in a Rn register");
		}
		Rn = rn;
	}



	/**
	 * Set Rd register value
	 * 
	 * @param rd
	 * @throws AssemblerException
	 */
	public void setRd(Register rd) throws AssemblerException {
		if (rd == null ) {
			throw new RuntimeException("Trying to Set a null value in a Rd register");
		}
		Rd = rd;
	}



	/* (non-Javadoc)
	 * @see main.instructionUtils.Instruction#BuildBinaryStringcode()
	 */
	@Override
	public void BuildBinaryStringcode() {
		String binaryCode = new StringBuilder()
								.append(this.getCategorie().getCode())
								.append(this.getConcreteOperation().getCodeOp())
								.append(this.Rm.toBinaryString())
								.append(this.Rn.toBinaryString())
								.append(this.Rd.toBinaryString())
								.toString();
		this.setBinaryStringCode(binaryCode);
	}
	
	

}
