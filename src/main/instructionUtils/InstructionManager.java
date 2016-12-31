package main.instructionUtils;

import java.util.ArrayList;
import java.util.List;
import main.AssemblerException;
import main.Variable;

public class InstructionManager {
	
	private DirectivesInterpreter dInterpreter;
	
	private InstructionFactory iFactory;
	
	private List<Instruction> romInstrList;
	
	private List<Variable> ramVariablesList;
	
	public int programState;
	
	

	public InstructionManager() {
		this.romInstrList = new ArrayList<>();
		this.ramVariablesList = new ArrayList<>();
		this.programState=0;
		this.dInterpreter = new DirectivesInterpreter();
		this.iFactory = new InstructionFactory(ramVariablesList);
	}
	

	public void processLine(String line) throws AssemblerException{
		
		if(line.trim().startsWith(DirectivesInterpreter.DIRECTIVES_PREFIX)){
			this.programState=this.dInterpreter.interpreteDirective(line);
			return;
		}
		
		if(this.recordingOnRom()){
			this.romInstrList.add(iFactory.getInstruction(line));
			return;
		}
		
		if(this.recordingOnRam()){
			Variable variable = VariableFactory.createVariable(line);
			this.addVariableToRam(variable);
			return;
		}
		
		
		
		throw new AssemblerException("Syntax Error : Instruction Used Out of Block", AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
		
		
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
		   throw new AssemblerException("Duplicated variable declaration '"+ variable.getNom() +"' ",AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
	}
	
	
	
	public List<Instruction> getTheROM(){
		return this.romInstrList;
	}
	
	
	
	public List<Variable> getTheRAM(){
		return this.ramVariablesList;
	}
	
	private Boolean recordingOnRom() {
		return this.programState==2;
	}
	
	private Boolean recordingOnRam() {
		return this.programState==1;
	}
	
}
