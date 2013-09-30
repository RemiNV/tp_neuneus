package models;

public enum TypeNourriture {
	CHOUX(150),
	CAROTTES(100),
	VODKA(300),
	SAKE(200),
	WHISKY(350);
	
	private int energie;
	
	TypeNourriture(int energie) {
		this.energie = energie;
	}
	
	public int getEnergie() {
		return energie;
	}
}
