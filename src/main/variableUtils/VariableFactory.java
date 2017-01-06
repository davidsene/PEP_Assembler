package main.variableUtils;

import main.exception.AssemblerException;
import main.syntaxe.Syntax;

public class VariableFactory {
	
	/**
	 * Create a variable object from a declaration line
	 * 
	 * @param line
	 * @return
	 * @throws AssemblerException
	 */
	public Variable createVariable (String line) throws AssemblerException {
		
		//Counting the number of blocks
		String lineToProcess = line.trim();
		String[] blocks = lineToProcess.split("\\s+");
		
		if( blocks.length !=3 ){
			throw new AssemblerException("Syntax Error : Varaible declaration should contains 3 block separated with spaces ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		
		
		String varStringBlk = blocks[0];
		
		if(! varStringBlk.endsWith(Syntax.VARIABLE_DECLARATION_SUFFIX)){
			throw new AssemblerException("Syntax Error : NO variable suffix ':' found in declaration ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		String varName = varStringBlk.substring(0, varStringBlk.length()-1);
		
		if(varName.isEmpty()){
			throw new AssemblerException("Syntax Error : Varaible name can't be empty ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		if(varName.contains(Syntax.VARIABLE_DECLARATION_SUFFIX)){
			throw new AssemblerException("Syntax Error : Varible name can't contain ':' charactere ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		
		
		
		String typeStringBlk = blocks[1];
		
		if(! typeStringBlk.startsWith(Syntax.TYPE_PREFIX)){
			throw new AssemblerException("Syntax Error : Bad type Prefix  ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		String typeName = typeStringBlk.substring(1);
		
		if(typeStringBlk.isEmpty()){
			throw new AssemblerException("Syntax Error : type name can't be empty ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		Type varType = Type.getType(typeName);
		
		if(varType==null){
			throw new AssemblerException("Syntax Error : Unknown type in Declaration ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		
		String valueStringBlk = blocks[2];
		
		if(! valueStringBlk.startsWith("0x")){
			throw new AssemblerException("Syntax Error : Initialisation value should be prefixed with '0x'  ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		int  varValue;
		
		try {
			
			varValue = Integer.parseInt(valueStringBlk.substring(2), 16);
			
		} catch (Exception e) {
			
			throw new AssemblerException("Syntax Error :Bad intial value format ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		if(varValue>Integer.MAX_VALUE){
			
			throw new AssemblerException("Syntax Error :initial value is out of bound ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
			
		}

			
		 return new Variable(varName, 0, varType, varValue);
	}
		
}
