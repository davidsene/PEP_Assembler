package main.instructionUtils;

import main.AssemblerException;

public class DirectivesInterpreter {
	
	public static final String DIRECTIVES_PREFIX = "." ;
	
	public int interpreteDirective(String directive) throws AssemblerException{
		
		switch (directive.trim().substring(1)) {
			case "text" : return 2;
			case "data" : return 1;
			case "end" :  return 0 ;
		default:
			throw new AssemblerException("Syntax Error : Unknow Directive for the Compilator ", AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED) ;
		}
		
	}

}
