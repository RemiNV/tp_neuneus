package models;

public enum TypeNourriture {
	CHOUX(150, "Chou"),
	CAROTTES(100, "Carotte"),
	VODKA(300, "Vodka"),
	SAKE(200, "Sake"),
	WHISKY(350, "Whisky");
	
	private int energie;
	private String nom;
	
	TypeNourriture(int energie, String nom) {
		this.energie = energie;
		this.nom = nom;
	}
	
	public int getEnergie() {
		return energie;
	}
	
	public static TypeNourriture randomType() {
		int tirage = (int) (Math.random() * 5);
		
		switch(tirage) {
		case 0:
			return CHOUX;
		case 1:
			return CAROTTES;
		case 2:
			return VODKA;
		case 3:
			return SAKE;
		case 4:
			return WHISKY;
		default:
			throw new IllegalStateException();	
		}
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
