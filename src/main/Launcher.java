package main;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


/**
 * BrainF*ck Launcher
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

		options.addOption("p", true, "Assembler filename"); // the bfck program filename parameter, requires a parameter (true)

		/**
		 * CLI Processing
		 */

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			formatter.printHelp("./Ass", options);
			System.exit(AssemblerException.ERR_LAUNCHER_BAD_PARAMS);
			return;
		}

		/**
		 * Execute
		 */

		try {

			/**
			 * Get the BrainF*ck Program
			 * and sanitize the filename
			 */
			
			String programFilename = cmd.getOptionValue("p");
			
			if (programFilename == null) {
				formatter.printHelp("./Ass", options);
				System.exit(AssemblerException.ERR_LAUNCHER_BAD_PARAMS);
				return;
			}

			/**
			 * Evaluate and execute the program
			 */
			
			AssemblerProgram program =  new AssemblerProgram(programFilename);
			Interpreter interpreter = new Interpreter();
			interpreter.translate(program);
			System.exit(0); 
			
		} catch (AssemblerException e) {
			
			System.err.println(e.getMessage());
            System.exit(e.getErrorCode());
		}
	}
}
