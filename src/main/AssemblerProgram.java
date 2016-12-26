package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;

public class AssemblerProgram  {
	
	/**
	 * the program file name
	 */
	private String filename;

	
	/**
	 * Gets the program filename
	 */
	public String getFilename() {
		return this.filename;
	}

	/**
	 * line by line reader
	 */
	private LineIterator filePtr = null;

	
	/**
	 * Default Constructor
	 * 
	 */
	public AssemblerProgram(String filePath) throws AssemblerException {
		
		if (filePath == null || filePath.isEmpty()) {
			throw new AssemblerException("filename attribute is empty.", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
		
		filePath = FilenameUtils.normalize(filePath);

		// Chroot the file location to the user directory
		File file = Paths.get( System.getProperty("user.dir") + System.getProperty("file.separator") + filePath ).normalize().toFile();

		if (file == null) {
			throw new AssemblerException("bad file.", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}

		
		if (!file.exists() || !file.isFile()) {
			throw new AssemblerException("'" + file.toPath() + "' does not exist. Working directory is set to '" + System.getProperty("user.dir") + "'", AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
		
			
		try {
			this.filePtr = FileUtils.lineIterator(file);
			this.filename = file.getName();
		}
		catch (IOException e) {
			throw new  AssemblerException(e.getMessage(),  AssemblerException.ERR_LAUNCHER_BFCK_PROGRAM_FAILED);
		}
	
	}
	

	
	public String getNextLine(){
			
			try {
				return filePtr.next().trim();
			}
			catch (NoSuchElementException e){
				LineIterator.closeQuietly(this.filePtr); 
				return null;
				
			}
	}

}
