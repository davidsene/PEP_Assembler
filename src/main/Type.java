package main;

public enum Type {
	
	WORD;
	
	public static Type getType(String typeLabe){
		
		switch (typeLabe) {
		
		case "word": return WORD;

		default:
			return null;
		}
	}

}
