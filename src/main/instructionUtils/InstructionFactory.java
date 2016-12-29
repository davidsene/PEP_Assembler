package main.instructionUtils;


import main.AssemblerException;
import main.InstructionLabel;
import main.Register;


public class InstructionFactory {
	
	
	
	public static Instruction getInstruction(String line) throws AssemblerException {
		
		String lineToProcess = line.trim();
		
		int firstSepPosition = lineToProcess.indexOf(Instruction.LABEL_AND_OPER_SEPARATOR);
		
		if(firstSepPosition==-1){
			
			InstructionLabel iLab = InstructionLabel.getInstructionLabel(lineToProcess);  //A little help for Debugging
			
			if(iLab == null)
				throw new AssemblerException("Syntax Error : No separator between operation and operands OR bad operation syntax ", AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
			else 
				throw new AssemblerException("Syntax Error : Missing Operand ", AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
		
		}
			
		
		String instrWord = lineToProcess.substring(0,firstSepPosition);

		InstructionLabel iLabel = InstructionLabel.getInstructionLabel(instrWord);
		
		if(iLabel == null)
			throw new AssemblerException("Syntax Error : Unknow Operation '"+ instrWord +"' ", AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
		
		String operandesString = lineToProcess.substring(firstSepPosition).trim();
		
		
		switch (iLabel.getCategorie()) {
			
			case A1: return buildInstCatA1(iLabel, operandesString);
			case A2: return buildInstCatA2(iLabel, operandesString);
			case A3: return buildInstCatA3(iLabel, operandesString);
			case B: return buildInstCatB(iLabel, operandesString);
			case C: return buildInstCatC(iLabel, operandesString);

		default:
			return null;
		}	
	}
	
	
	
	
	public static Instruction buildInstCatA1(InstructionLabel iLabel, String operandesString) throws AssemblerException{
		
		String [] operandesTab = processOperands(operandesString,3);
		    
		Register rd = Register.getRegister(operandesTab[0].trim());
		Register rm = Register.getRegister(operandesTab[1].trim());
		String imm5 = operandesTab[2].trim();
		InstructionLabel concreteOperation = iLabel;
		    
		return new InstrCategorieA1(concreteOperation,rd,rm,imm5);
		    
	}
	
	
	
	public static Instruction buildInstCatA2(InstructionLabel iLabel, String operandesString) throws AssemblerException{
		
		String [] operandesTab = processOperands(operandesString,3);
		    
		    Register rd = Register.getRegister(operandesTab[0].trim());
		    Register rn = Register.getRegister(operandesTab[1].trim());
		    Register rm = Register.getRegister(operandesTab[2].trim());
		    InstructionLabel concreteOperation = iLabel;
		    
		    return new InstrCategorieA2(concreteOperation, rd, rn, rm);
		       
	}
	
	
	public static Instruction buildInstCatA3(InstructionLabel iLabel, String operandesString) throws AssemblerException{
		
		String [] operandesTab = processOperands(operandesString,2);
		    
		    Register rd = Register.getRegister(operandesTab[0].trim());
		    String imm8 = operandesTab[1].trim();
		   
		    InstructionLabel concreteOperation = iLabel;
		    
		    return new InstrCategorieA3(concreteOperation, rd, imm8);
		   	    
	}
	
	
	public static Instruction buildInstCatB(InstructionLabel iLabel, String operandesString) throws AssemblerException{
		
		String [] operandesTab = processOperands(operandesString,2);
		    
		    Register regPos0 = Register.getRegister(operandesTab[0].trim());
		    Register regPos1 = Register.getRegister(operandesTab[1].trim());
		   
		    InstructionLabel concreteOperation = iLabel;
		    
		    return new InstrCategorieB(concreteOperation, regPos0, regPos1);
		      
	}
	
	
	public static Instruction buildInstCatC(InstructionLabel iLabel, String operandesString) throws AssemblerException{
		
		String [] operandesTab = processOperands(operandesString,2);
		    
		    Register rd = Register.getRegister(operandesTab[0].trim());
		    String imm8 = operandesTab[1].trim();
		   
		    InstructionLabel concreteOperation = iLabel;
		    
		    return new InstrCategorieC(concreteOperation, rd, imm8);
		   	    
	}
	
	
	private static String [] processOperands(String opString, int NbOprandsRequired ) throws AssemblerException{
		
		String [] opTab = opString.split(String.valueOf(Instruction.MULTI_OPER_SEPARATOR));
	    
	    if (opTab.length != NbOprandsRequired) {
			throw new AssemblerException("Syntax Error : Bad number of operandes" , AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
		}
	    return opTab;
		
	}
	
}
