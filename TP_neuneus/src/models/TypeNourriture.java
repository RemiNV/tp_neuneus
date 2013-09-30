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
}
