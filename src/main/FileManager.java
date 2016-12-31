package main;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import main.instructionUtils.Instruction;


public class FileManager {
	

	private  FileWriter createNewFile(String filename,String extension) throws AssemblerException{
		
		FileWriter fileWriter;

		try {
				fileWriter = new FileWriter(Paths.get( System.getProperty("user.dir") + System.getProperty("file.separator") + filename).normalize().toFile());
		} catch (IOException e) {
				throw new AssemblerException("unable to create log file.", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
		
		return fileWriter;
	}
	
	
	
	private void appendInNewFile(String content, String spacer, FileWriter fileWriter) throws AssemblerException{
		
		try {
			fileWriter.append(content + spacer);
		} catch (IOException e) {
			throw new AssemblerException("unable to append data to log file.", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
	}
	
	
	

	private void closeNewFile(FileWriter fileWriter) throws AssemblerException {
		try {
			fileWriter.close();
		} catch (IOException e) {
			throw new AssemblerException("unable to release log file handle.", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
	}
	
	
	
	
	
	public void createRAMFileFromList(List<Variable> list , String filename, String fileExtension) throws AssemblerException{
		
		FileWriter fileWriter= createNewFile(filename,fileExtension);
		appendInNewFile("v2.0 raw","\n",fileWriter);
		
		for (Variable variable : list) {
			appendInNewFile(String.valueOf(Integer.toHexString(variable.getInitialValue()))," ",fileWriter);
		}
		
		closeNewFile(fileWriter);
	}
	
	
	
	public void createROMFileFromList(List<Instruction> list , String filename, String fileExtension) throws AssemblerException{
		
		FileWriter fileWriter= createNewFile(filename,fileExtension);
		
		appendInNewFile("v2.0 raw","\n",fileWriter);
		
		for (Instruction instruction : list) {
			appendInNewFile(String.valueOf(instruction.toHexCode()),"\n",fileWriter);
		}
		
		closeNewFile(fileWriter);
	}
	
	
	public void CreateProgramMemoryMap( List<Variable> list , String filename, String fileExtension) throws AssemblerException{
		
		FileWriter fileWriter= createNewFile(filename,fileExtension);
		appendInNewFile("v2.0 raw","\n",fileWriter);
		
		for (Variable variable : list) {
			appendInNewFile(String.valueOf(variable.getNom()+" "+ variable.getAdress()),"\n",fileWriter);
		}
		
		closeNewFile(fileWriter);
	}
	
	

}
