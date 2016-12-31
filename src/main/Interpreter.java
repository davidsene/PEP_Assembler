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
	
			while (line != null) {
				
				if( ! line.trim().isEmpty()){
					try {
						this.instructionManager.processLine(line);
					} 
					catch (AssemblerException e) {
						
						throw new AssemblerException(e.getMessage().concat(" [ On line : " + instrPtr +" ]" ), e.getErrorCode());
					}
				}
				
				line = program.getNextLine();
				instrPtr++;
				
			}
			
			List<Instruction> rom = instructionManager.getTheROM();
			List<Variable> ram = instructionManager.getTheRAM();
			
			FileManager fileManager = new FileManager();
			
			fileManager.createROMFileFromList(rom, "rom", "ini");
			fileManager.createRAMFileFromList(ram, "ram", "ini");
			fileManager.CreateProgramMemoryMap(ram, "map", "ini");
			
			
			
			//for (Instruction instruction : rom) {
				//System.out.println(instruction.toHexCode());
			//}
			//System.out.println("======THE RAM=======");
			
			
			//for (Variable variable : ram) {
				//System.out.println(variable.toString());
			//}
			//System.out.println("======THE ROM=======");
	}
	
}
