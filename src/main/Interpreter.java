package main;

import java.util.List;

import main.instructionUtils.Instruction;
import main.instructionUtils.InstructionManager;


public class Interpreter {

	private InstructionManager instructionManager;
	
	public Interpreter() {
		this.instructionManager = new InstructionManager();
	}

	
	public void translate(AssemblerProgram program) throws AssemblerException {
		
			// Fetch the next line
			String  line = program.getNextLine();
			int instrPtr= 1;
	
			while (line != null && ! line.trim().isEmpty()) {
				
				try {
					this.instructionManager.processLine(line);
				} 
				catch (AssemblerException e) {
					
					throw new AssemblerException(e.getMessage().concat(" [ On line : " + instrPtr +" ]" ), e.getErrorCode());
				}
				
				line = program.getNextLine();
				instrPtr++;
				
			}
			
			
			List<Instruction> rom = instructionManager.getTheROM();
			
			for (Instruction instruction : rom) {
				System.out.println(instruction.toHexCode());
			}
			
	}
	
}
