package main.instructionUtils;


import main.AssemblerException;
import main.InstructionLabel;
import main.Register;


public class InstructionFactory {
	
	public static Instruction getInstruction(String line) throws AssemblerException {
		
		String[] tab = line.split(Instruction.LABEL_AND_OPER_SEPARATOR);
		
		if (tab.length<2) {
			throw new AssemblerException("Syntax Error : Missing operandes : Near : '" + line , AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
		}
		String instrWord = tab[0].trim();
		
		InstructionLabel iLabel = InstructionLabel.getInstructionLabel(instrWord);;
		
		switch (iLabel.getCategorie()) {
			
			case A1: return buildInstCat1(iLabel, tab[1], line);
		

		default:
			return null;
		}
		
		
	}
	
	
	public static Instruction buildInstCat1(InstructionLabel iLabel, String oper,String line) throws AssemblerException{
		
		String [] operande = oper.split(Instruction.MULTI_OPER_SEPARATOR);
		    
		    if (operande.length!=3) {
				throw new AssemblerException("Syntax Error : Bad number of operandes : Near : '" + line , AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
			}
		    return new InstrCategorieA1(iLabel,Register.getRegister(operande[0].trim()),Register.getRegister(operande[1].trim()),operande[2].trim());
		    
	}

}
