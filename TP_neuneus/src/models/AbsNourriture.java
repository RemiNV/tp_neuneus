package models;

import terrain.Loft;

public abstract class AbsNourriture {
	protected int energie;
	protected int pourcentageConsomme;
	protected Loft loft;
	protected int posX;
	protected int posY;
	
	public AbsNourriture(int energie, int posX, int posY) {
		this.energie = energie;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void manger(int pourcentageConsomme) {
		this.pourcentageConsomme -= pourcentageConsomme;
		if(this.pourcentageConsomme < 0)
			throw new IllegalArgumentException("Pourcentage de consommation supérieur à la limite");
	}
	
	public abstract void dessiner();
}
