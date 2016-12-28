package main;

public enum Register {
	R0(0),R1(1),R2(2),R3(3),R4(4),R5(5),R6(6),R7(7);
	
	public int value;
	
	private Register(int value){
		this.value = value;
	}
	
	public String toBinaryString(){
		String val = "000" + Integer.toBinaryString(value);
		return val.substring(val.length()-3);
	}
	
	public static Register getRegister(String code) throws AssemblerException{
		switch (code) {
		   case "R0": return Register.R0;
		   case "R1": return Register.R1;
		   case "R2": return Register.R2;
		   case "R3": return Register.R3;
		   case "R4": return Register.R4;
		   case "R5": return Register.R5;
		   case "R6": return Register.R6;
		   case "R7": return Register.R7;
		default:
			throw new AssemblerException("Syntax Error : Bad register name ",AssemblerException.ERR_LAUNCHER_BFCK_RUNTIME_FAILED);
		}	
	}

}
