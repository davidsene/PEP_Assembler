package main;


import main.instructionUtils.Instruction;
import main.instructionUtils.InstructionFactory;


public class Interpreter {

	
	
	public Interpreter() {}

	
	public void translate(AssemblerProgram program) throws AssemblerException {
		
			// Fetch the next line
			String  line = program.getNextLine();
			int instrPtr= 1;
	
			while (line != null && ! line.trim().isEmpty()) {
				
				try {
					
					Instruction instruction = InstructionFactory.getInstruction(line);
					System.out.println(instruction.toHexCode());
				} 
				catch (AssemblerException e) {
					
					throw new AssemblerException(e.getMessage().concat(" [ On line : " + instrPtr +" ]" ), e.getErrorCode());
				}
				
				line = program.getNextLine();
				instrPtr++;
				
			}
			
	}
	
}
