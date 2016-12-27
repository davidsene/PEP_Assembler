package main;


import main.instructionUtils.Instruction;
import main.instructionUtils.InstructionFactory;


public class Interpreter {

	
	
	public Interpreter() {
		
	}

	
	public void translate(AssemblerProgram program) throws AssemblerException {
		
		try {
			
	
			// Fetch the next line
			String  line = program.getNextLine();
	
			while (line != null) {
	
				Instruction instruction = InstructionFactory.getInstruction(line);
				//System.out.println(instruction.toBinCode());
				System.out.println(instruction.toHexCode());
				
				line = program.getNextLine();
			}
		}
		catch (AssemblerException e) {
			
			throw new AssemblerException(e.getMessage(), e.getErrorCode());
		}
		
	}

	
}
