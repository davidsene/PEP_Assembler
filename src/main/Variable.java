package main;

public class Variable {
	
	private String nom;
	
	private int adress;
	
	private Type type;
	
	private int initialValue;
	
	
	public Variable(String nom, int adress, Type type, int initialValue) {
		this.setNom(nom);
		this.setAdress(adress);
		this.setType(type);
		this.setInitialValue(initialValue);
	}
	

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if(nom==null)
			throw new RuntimeException("Trying to Set a null value as variable name");
		this.nom = nom;
	}

	public int getAdress() {
		return adress;
	}
	
	public String getAdressAsImm8() {
		String adress =  "#"+this.adress;
		return adress;
	}

	public void setAdress(int adress) {
		this.adress = adress;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		if(type==null)
			throw new RuntimeException("Trying to Set a null value as variable Type");
		this.type = type;
	}

	
	public int getInitialValue() {
		return initialValue;
	}


	public void setInitialValue(int initialValue) {
		this.initialValue = initialValue;
	}




	@Override
	public String toString() {
		return "Variable [nom=" + nom + ", adress=" + adress + ", type=" + type + ", initialValue=" + initialValue
				+ "]";
	}


	

	

}
