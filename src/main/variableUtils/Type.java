package main.variableUtils;

/**
 * Define types for data
 */
public enum Type {
	
	WORD;
	
	/**
	 * @param typeLabe
	 * @return A type object from a string code
	 */
	public static Type getType(String typeLabe){
		
		switch (typeLabe) {
		
		case "word": return WORD;

		default:
			return null;
		}
	}

}
