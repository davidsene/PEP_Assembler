package main;

import java.util.List;
import main.exception.AssemblerException;
import main.instructionUtils.Instruction;
import main.syntaxe.Syntax;
import main.variableUtils.Variable;


public class Interpreter {
	
	
	/**
	 * The used instruction manager instance
	 */
	private InstructionManager instructionManager;
	
	
	
	/**
	 * Constructor
	 */
	public Interpreter() {
		this.instructionManager = new InstructionManager();
	}

	
	/**
	 * interprete the given program and generate files
	 * 
	 * @param program
	 * @throws AssemblerException
	 */
	public void interprete(AssemblerProgram program) throws AssemblerException {
		
			// Fetch the next line
			String  line = program.getNextLine();
			int instrPtr= 1;
	
			while (line != null) {
				
				if( ! line.trim().isEmpty() && ! line.trim().startsWith(Syntax.COMMENT_PREFIX)){
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
			
			String filename = program.getFilename().substring(0,program.getFilename().indexOf("."));
			
			fileManager.createROMFile(rom, "rom_" + filename, "");
			fileManager.createRAMFile(ram, "ram_"+ filename, "");
			fileManager.createMemoryMap(ram, "map_"+ filename, "");
				
	}
	
}
