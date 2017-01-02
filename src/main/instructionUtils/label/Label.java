package main.instructionUtils.label;

import main.AssemblerException;
import main.Categorie;
import main.InstructionLabel;
import main.instructionUtils.Instruction;

public class Label extends Instruction {
	
	private String name;
	
	private int adress;
		
	public Label(String name, int adress) throws AssemblerException{
		super(Categorie.LABEL, InstructionLabel.LABEL);
		this.setName(name);
		this.setAdress(adress);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) throws AssemblerException {
		if (name == null ) {
			throw new RuntimeException("Trying to Set a null value label name ");
		}
		
		if(name.isEmpty()){
			
			throw new AssemblerException("Syntax Error : Label Name can't be empty ", AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
		}
		
		if(name.contains(":")){
			
			throw new AssemblerException("Syntax Error : Label Name can't contains the character ':' ", AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
		}
		
		
		this.name = name;
	}


	public int getAdress() {
		return adress;
	}


	public void setAdress(int adress) {
		if(adress<0 || adress>255)
			throw new RuntimeException("Label adress out of bound ");
		this.adress = adress;
	}

	public String getAdressAsBinaryString(){
		String addr = Integer.toBinaryString(this.adress);
		addr = Instruction.normaliseTo_N_Bits(addr, 8);
		return addr;
	}

	


	@Override
	public String toString() {
		return "Label [name=" + name + ", adress=" + adress + ", BinAddr="+ this.getAdressAsBinaryString()+"]";
	}


	@Override
	public void BuildBinaryStringcode() {
		return;
	}
	
	
	

	

}
