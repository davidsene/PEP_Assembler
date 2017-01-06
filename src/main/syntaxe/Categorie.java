package main.syntaxe;

/**
 *Defines supported categories of instruction
 */
public enum Categorie {
	
	A1("00"),
	A2("00"),
	A3("00"),
	B("010000"),
	C("1001"),
	D("1101"),
	LABEL("");

	private String code;
	
	/**
	 * Constructor
	 * 
	 * @param code
	 */
	private Categorie(String code){
		this.code = code;
	}
	
	/**
	 * @return The binary code of a categorie
	 */
	public String getCode(){
		return this.code;
	}
}
