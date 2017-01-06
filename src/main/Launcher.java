package main;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import main.exception.AssemblerException;


/**
 * Launcher
 */
public class Launcher {

	public static void main(String[] args) {
		
		

		/**
		 * CLI Initialization
		 * 
		 * POWERED BY APACHE COMMONS LIB
		 * 
		 * @see https://commons.apache.org/proper/commons-io/description.html
		 * @see https://commons.apache.org/proper/commons-cli/introduction.html
		 */

		Options options = new Options();
		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		CommandLine cmd;

		options.addOption("p", true, "The Assembler program filename"); 

		/**
		 * CLI Processing
		 */

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			formatter.printHelp("./asm", options);
			System.exit(AssemblerException.ERR_LAUNCHER_BAD_PARAMS);
			return;
		}

		/**
		 * Execute
		 */

		try {

			/**
			 * Get the  Program
			 * and sanitize the filename
			 */
			
			String programFilename = cmd.getOptionValue("p");
			
			if (programFilename == null) {
				formatter.printHelp("./asm", options);
				System.exit(AssemblerException.ERR_LAUNCHER_BAD_PARAMS);
				return;
			}

			/**
			 * Evaluate and execute the program
			 */
			
			AssemblerProgram program =  new AssemblerProgram(programFilename);
			Interpreter interpreter = new Interpreter();
			interpreter.interprete(program);
			System.exit(0); 
			
		} catch (AssemblerException e) {
			
			System.err.println(e.getMessage());
            System.exit(e.getErrorCode());
		}
	}
}
