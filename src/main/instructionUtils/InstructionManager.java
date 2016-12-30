package main.instructionUtils;

import java.util.ArrayList;
import java.util.List;
import main.AssemblerException;
import main.Variable;

public class InstructionManager {
	
	
	private List<Instruction> romInstrList;
	
	private List<Variable> ramVariablesList;
	
	private boolean recordingOnRam;
	
	private boolean recordingOnRom;
	

	public InstructionManager() {
		this.romInstrList = new ArrayList<>();
		this.ramVariablesList = new ArrayList<>();
		this.recordingOnRam=false;
		this.recordingOnRom=true;
	}
	

	public void processLine(String line) throws AssemblerException{
		
		if(this.recordingOnRom){
			this.romInstrList.add(InstructionFactory.getInstruction(line));
			return;
		}
		
		if(this.recordingOnRam){
			Variable variable = VariableFactory.createVariable(line);
			this.addVariableToRam(variable);
			return;
		}
		
	}
	
	
	
	private Variable getVariableFromRam(String nom){
		
		if(nom==null || nom.isEmpty()) return null;
		
		for (int i = 0; i < ramVariablesList.size(); i++) {
			if ( ramVariablesList.get(i).getNom().compareTo(nom) == 0 ) return ramVariablesList.get(i);
		}
		
		return null;
	}
	
	
	
	private void addVariableToRam(Variable variable) throws AssemblerException {
		
		if( this.getVariableFromRam(variable.getNom()) == null ){
			
			variable.setAdress(this.ramVariablesList.size());
			this.ramVariablesList.add(variable);
		
		}
		else
		   throw new AssemblerException("Duplicated declaration Variable[ "+ variable.getNom() +"] . Aborting",AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
	}
	
	
	
	public List<Instruction> getTheROM(){
		return this.romInstrList;
	}
	
	
	
	public List<Variable> getTheRAM(){
		return this.ramVariablesList;
	}
	
}
