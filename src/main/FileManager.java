package main;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import main.exception.AssemblerException;
import main.instructionUtils.Instruction;
import main.variableUtils.Variable;


public class FileManager {
	

	/**
	 * Create New File
	 * 
	 * @param filename The name of the file to create
	 * @param extension  The extension of the file to create
	 * @return A fileWriter for handling the created file
	 * @throws AssemblerException
	 */
	private  FileWriter createNewFile(String filename,String extension) throws AssemblerException{
		
		FileWriter fileWriter;

		try {
				fileWriter = new FileWriter(Paths.get( System.getProperty("user.dir") + System.getProperty("file.separator") + filename).normalize().toFile());
		} catch (IOException e) {
				throw new AssemblerException("unable to create log file.", AssemblerException.ERR_LAUNCHER_ASM_PROGRAM_FAILED);
		}
		
		return fileWriter;
	}
	
	
	
	/**
	 * Add content into a file
	 * 
	 * @param content
	 * @param spacer
	 * @param fileWriter
	 * @throws AssemblerException
	 */
	private void appendInFile(String content, String spacer, FileWriter fileWriter) throws AssemblerException{
		
		try {
			fileWriter.append(content + spacer);
		} catch (IOException e) {
			throw new AssemblerException("unable to append data to log file.", AssemblerException.ERR_LAUNCHER_ASM_PROGRAM_FAILED);
		}
	}
	
	
	

	/**
	 * Close a file
	 * 
	 * @param fileWriter
	 * @throws AssemblerException
	 */
	private void closeFile(FileWriter fileWriter) throws AssemblerException {
		try {
			fileWriter.close();
		} catch (IOException e) {
			throw new AssemblerException("unable to release log file handle.", AssemblerException.ERR_LAUNCHER_ASM_PROGRAM_FAILED);
		}
	}
	
	
	
	
	/**
	 * Create the Ram file
	 * 
	 * @param list
	 * @param filename
	 * @param fileExtension
	 * @throws AssemblerException
	 */
	public void createRAMFile(List<Variable> list , String filename, String fileExtension) throws AssemblerException{
		
		FileWriter fileWriter= createNewFile(filename,fileExtension);
		appendInFile("v2.0 raw","\n",fileWriter);
		
		for (Variable variable : list) {
			appendInFile(String.valueOf(Integer.toHexString(variable.getInitialValue()))," ",fileWriter);
		}
		
		closeFile(fileWriter);
	}
	
	
	
	/**
	 *  Create the Rom file
	 * 
	 * @param list
	 * @param filename
	 * @param fileExtension
	 * @throws AssemblerException
	 */
	public void createROMFile(List<Instruction> list , String filename, String fileExtension) throws AssemblerException{
		
		FileWriter fileWriter= createNewFile(filename,fileExtension+fileExtension);
		
		appendInFile("v2.0 raw","\n",fileWriter);
		
		for (Instruction instruction : list) {
			appendInFile(String.valueOf(instruction.toHexCode()),"\n",fileWriter);
		}
		
		closeFile(fileWriter);
	}
	
	
	
	
	/**
	 * Create the map file
	 * 
	 * @param list
	 * @param filename
	 * @param fileExtension
	 * @throws AssemblerException
	 */
	public void createMemoryMap( List<Variable> list , String filename, String fileExtension) throws AssemblerException{
		
		FileWriter fileWriter= createNewFile(filename,fileExtension);
		appendInFile("v2.0 raw","\n",fileWriter);
		
		for (Variable variable : list) {
			appendInFile(String.valueOf(variable.getNom()+" "+ variable.getAdress()),"\n",fileWriter);
		}
		
		closeFile(fileWriter);
	}
	
	

}
