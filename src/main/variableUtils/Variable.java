package main.variableUtils;

public class Variable {
	
	
	/**
	 * The name of the variable
	 */
	private String nom;
	
	
	/**
	 * The address of the variable in the ram
	 */
	private int adress;
	
	
	/**
	 * The type of the variable
	 */
	private Type type;
	
	
	/**
	 * The initial value of the variable
	 */
	private int initialValue;
	
	
	/**
	 * Constructor
	 * 
	 * @param nom
	 * @param adress
	 * @param type
	 * @param initialValue
	 */
	public Variable(String nom, int adress, Type type, int initialValue) {
		this.setNom(nom);
		this.setAdress(adress);
		this.setType(type);
		this.setInitialValue(initialValue);
	}
	

	

	/**
	 * @return The name of the variable
	 */
	public String getNom() {
		return nom;
	}

	
	
	/**
	 * Set the name of the variable
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		if(nom==null)
			throw new RuntimeException("Trying to Set a null value as variable name");
		this.nom = nom;
	}

	
	
	/**
	 * @return The integer address of the variable
	 */
	public int getAdress() {
		return adress;
	}
	
	
	
	/**
	 * @return the address of the variable as an Imm8
	 */
	public String getAdressAsImm8() {
		String adress =  "#"+this.adress;
		return adress;
	}

	
	
	/**
	 * Set the integer address of the variable
	 * 
	 * @param adress
	 */
	public void setAdress(int adress) {
		this.adress = adress;
	}

	
	
	/**
	 * @return The type object of the variable
	 */
	public Type getType() {
		return type;
	}

	
	
	/**
	 * Set the type of the variable
	 * 
	 * @param type
	 */
	public void setType(Type type) {
		if(type==null)
			throw new RuntimeException("Trying to Set a null value as variable Type");
		this.type = type;
	}

	
	
	/**
	 * @return The initial value of the variable
	 */
	public int getInitialValue() {
		return initialValue;
	}


	
	/**
	 * Set the initial value of the variable
	 * 
	 * @param initialValue
	 */
	public void setInitialValue(int initialValue) {
		this.initialValue = initialValue;
	}

	
}
