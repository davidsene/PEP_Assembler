package main;

public class Variable {
	
	private String nom;
	
	private int adress;
	
	private Type type;
	
	
	public Variable(String nom, int adress, Type type) {
		this.setNom(nom);
		this.setAdress(adress);
		this.setType(type);
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAdress() {
		return adress;
	}
	
	public String getAdressAsBinaryString() {
		return "";
	}

	public void setAdress(int adress) {
		this.adress = adress;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	

}
