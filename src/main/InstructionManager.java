package main;

import java.util.ArrayList;
import java.util.List;

import main.directive.DirectivesInterpreter;
import main.instructionUtils.InstrCategorieD;
import main.instructionUtils.Instruction;
import main.instructionUtils.InstructionFactory;
import main.instructionUtils.label.Label;
import main.variableUtils.Variable;
import main.variableUtils.VariableFactory;

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
		this.iFactory = new InstructionFactory(ramVariablesList,this.romInstrList);
	}
	

	public void processLine(String line,int lineNumber) throws AssemblerException{
		
		if(line.trim().startsWith(DirectivesInterpreter.DIRECTIVES_PREFIX)){
			this.programState=this.dInterpreter.interpreteDirective(line);
			return;
		}
		
		if(this.recordingOnRom()){
			Instruction inst = iFactory.getInstruction(line,lineNumber);
			if(! (inst instanceof Label)){
				this.romInstrList.add(inst);
			}
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
	
	
	public void linkLabelsWithBranchements() throws AssemblerException{
		 
		List<Instruction> newRomList = new ArrayList<>();
		
		for (Instruction instruction : romInstrList) {
			
			if (instruction instanceof InstrCategorieD) {
				InstrCategorieD branch = (InstrCategorieD) instruction;
				Label label = this.iFactory.labelFactory.getLabelFromName(branch.getLabProvName());
				
				if (label == null) {
					throw new AssemblerException("Syntax Error : Reference to an Undeclared label [On Line "+branch.getLineNumber()+"]",AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
				}
				branch.setLabel(label);
				newRomList.add(branch);
			}
			else if (! (instruction  instanceof Label)){
				newRomList.add(instruction);
			}
		}
		this.romInstrList = newRomList;
	}
	
}
