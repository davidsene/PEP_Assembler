package main;

import java.util.ArrayList;
import java.util.List;
import main.directive.DirectivesInterpreter;
import main.exception.AssemblerException;
import main.instructionUtils.InstrCategorieD;
import main.instructionUtils.Instruction;
import main.instructionUtils.InstructionFactory;
import main.instructionUtils.label.Label;
import main.syntaxe.Syntax;
import main.variableUtils.Variable;
import main.variableUtils.VariableFactory;

public class InstructionManager {
	
	/**
	 * The used DirectiveInterpreter instance
	 */
	private DirectivesInterpreter dInterpreter;
	
	
	/**
	 * The used instructionInterpreter instance
	 */
	private InstructionFactory instFactory;
	
	
	/**
	 * The list of created instruction objects 
	 */
	private List<Instruction> romInstrList;
	
	
	/**
	 *  The list of created variables objects
	 */
	private List<Variable> ramVariablesList;
	
	
	/**
	 * The used VariableFactory instance
	 */
	private VariableFactory varFactory;
	
	
	/**
	 * Hold the Instruction Manager State
	 */
	private InstructionManagerState iManagerState;
	
	
	/**
	 * Define the possible states of the instruction Manager
	 */
	public static enum InstructionManagerState {
		RECORDING_ON_RAM,
		RECORDING_ON_ROM,
		NOT_RECORDING;
	}
	
	
	/**
	 * Constructor
	 */
	public InstructionManager() {
		this.romInstrList = new ArrayList<>();
		this.ramVariablesList = new ArrayList<>();
		this.iManagerState=InstructionManagerState.NOT_RECORDING;
		this.dInterpreter = new DirectivesInterpreter();
		this.instFactory = new InstructionFactory(ramVariablesList,this.romInstrList);
		this.varFactory = new VariableFactory();
	}
	

	/**
	 * Process a line
	 * 
	 * @param line
	 * @param lineNumber
	 * @throws AssemblerException
	 */
	public void processLine(String line,int lineNumber) throws AssemblerException{
		
		if(line.trim().startsWith(Syntax.DIRECTIVES_PREFIX)){
			this.iManagerState=this.dInterpreter.interpreteDirective(line);
			return;
		}
		
		if(this.recordingOnRom()){
			Instruction inst = instFactory.getInstruction(line,lineNumber);
			if(! (inst instanceof Label)){
				this.romInstrList.add(inst);
			}
			return;
		}
		
		if(this.recordingOnRam()){
			Variable variable = varFactory.createVariable(line);
			this.addVariableToRam(variable);
			return;
		}
		
		throw new AssemblerException("Syntax Error : Instruction Used Out of Block", AssemblerException.ERR_ASM_RUNTIME_FAILED);
	}
	
	
	
	/**
	 * @param nom
	 * @return A variable from the list of declared variable | null if the variable is not declared
	 */
	private Variable getVariableFromRam(String nom){
		
		if(nom==null || nom.isEmpty()) return null;
		
		for (int i = 0; i < ramVariablesList.size(); i++) {
			if ( ramVariablesList.get(i).getNom().compareTo(nom) == 0 ) return ramVariablesList.get(i);
		}
		
		return null;
	}
	
	
	
	/**
	 * Add a new variable into the list of declared variable 
	 * 
	 * @param variable
	 * @throws AssemblerException when the variable to be added already exist in the list
	 */
	private void addVariableToRam(Variable variable) throws AssemblerException {
		
		if( this.getVariableFromRam(variable.getNom()) == null ){
			
			variable.setAdress(this.ramVariablesList.size());
			this.ramVariablesList.add(variable);
		
		}
		else
		   throw new AssemblerException("Duplicated variable declaration '"+ variable.getNom() +"' ",AssemblerException.ERR_ASM_RUNTIME_FAILED);
	}
	
	
	
	/**
	 * @return The list of created instructions
	 */
	public List<Instruction> getTheROM(){
		return this.romInstrList;
	}
	
	
	
	/**
	 * @return The list of declared variables
	 */
	public List<Variable> getTheRAM(){
		return this.ramVariablesList;
	}
	
	
	/**
	 * @return if we a recording on the romList
	 */
	private Boolean recordingOnRom() {
		return this.iManagerState==InstructionManagerState.RECORDING_ON_ROM;
	}
	
	
	/**
	 * @return if we a recording on the ramList
	 */
	private Boolean recordingOnRam() {
		return this.iManagerState==InstructionManagerState.RECORDING_ON_RAM;
	}
	
	
	
	/**
	 * Add, at the end of the record, the label's address into the bounded branching instructions
	 * 
	 * @throws AssemblerException
	 */
	public void linkLabelsWithBranchements() throws AssemblerException{
		 
		List<Instruction> newRomList = new ArrayList<>();
		
		for (Instruction instruction : romInstrList) {
			
			if (instruction instanceof InstrCategorieD) {
				InstrCategorieD branch = (InstrCategorieD) instruction;
				Label label = this.instFactory.labelFactory.getLabelFromName(branch.getLabProvName());
				
				if (label == null) {
					throw new AssemblerException("Syntax Error : Reference to an Undeclared label [On Line "+branch.getLineNumber()+"]",AssemblerException.ERR_ASM_RUNTIME_FAILED);
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
