package main;

public enum Categorie {
A1("00"),
A2("00"),
A3("00"),
B("010000"),
C("0101"),
D("1001");

	private String code;
	
	private Categorie(String code){
		this.code = code;
	}
	
	public String getCode(){
		return this.code;
	}
}
