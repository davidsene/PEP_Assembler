package main;

public class AssemblerException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Exception error code
	 */
	private int errorCode = -1;
	
	
	public static final int ERR_LAUNCHER_BAD_PARAMS = 1;
	
	public static final int ERR_LAUNCHER_BFCK_PROGRAM_FAILED = 2;
	
	public static final int ERR_LAUNCHER_BFCK_RUNTIME_FAILED = 3;
	
	

	public AssemblerException(String message) {
		this(message, 0);
	}
	
	public AssemblerException(String message, int errorCode) {
		super(message);
		
		if (errorCode >= 0) {
			this.errorCode = errorCode;
		}
	}
	
	/**
	 * Get the error code
	 * @return errorCode The error code
	 */
	public int getErrorCode() {
		return this.errorCode;
	}
}
