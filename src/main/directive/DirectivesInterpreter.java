package main.directive;

import main.InstructionManager;
import main.InstructionManager.InstructionManagerState;
import main.exception.AssemblerException;

public class DirectivesInterpreter {
	
	
	/**
	 * @param directive
	 * @return The result state after interpreting the directive
	 * @throws AssemblerException When the directive is unknown
	 */
	public InstructionManagerState interpreteDirective(String directive) throws AssemblerException{
		
		switch (directive.trim().substring(1)) {
			case "text" : return InstructionManager.InstructionManagerState.RECORDING_ON_ROM;
			case "data" : return InstructionManager.InstructionManagerState.RECORDING_ON_RAM;
			case "end" :  return InstructionManager.InstructionManagerState.NOT_RECORDING ;
		default:
			throw new AssemblerException("Syntax Error : Unknow Directive for the Compilator ", AssemblerException.ERR_ASM_RUNTIME_FAILED) ;
		}
		
	}

}
