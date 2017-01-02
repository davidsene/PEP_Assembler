package main;

import java.util.List;
import main.instructionUtils.Instruction;
import main.variableUtils.Variable;


public class Interpreter {

	private InstructionManager instructionManager;
	
	private static final String COMMENT_PREFIX=";";
	
	public Interpreter() {
		this.instructionManager = new InstructionManager();
	}

	
	public void translate(AssemblerProgram program) throws AssemblerException {
		
			// Fetch the next line
			String  line = program.getNextLine();
			int instrPtr= 1;
	
			while (line != null) {
				
				if( ! line.trim().isEmpty() && ! line.trim().startsWith(Interpreter.COMMENT_PREFIX)){
					try {
						this.instructionManager.processLine(line,instrPtr);
					} 
					catch (AssemblerException e) {
						
						throw new AssemblerException(e.getMessage().concat(" [ On line : " + instrPtr +" ]" ), e.getErrorCode());
					}
				}
				
				line = program.getNextLine();
				instrPtr++;
				
			}
			
			
			this.instructionManager.linkLabelsWithBranchements();
			
			List<Instruction> rom = instructionManager.getTheROM();
			
			List<Variable> ram = instructionManager.getTheRAM();
			
			
			FileManager fileManager = new FileManager();
			
			fileManager.createROMFileFromList(rom, "rom", "ini");
			fileManager.createRAMFileFromList(ram, "ram", "ini");
			fileManager.CreateProgramMemoryMap(ram, "map", "ini");
			
			
			
			
	}
	
}
