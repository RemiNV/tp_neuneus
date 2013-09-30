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
	
	/**
	 * Mange la nourriture et indique l'énergie obtenue
	 * @param pourcentageConsomme Pourcentage de nourriture à consommer. Doit être <= au pourcentage restant
	 * @return Energie obtenue en mangeant la nourriture (fonction de l'énergie de la nourriture et du pourcentage consommé)
	 */
	public int seFaireManger(int pourcentageConsomme) {
		this.pourcentageConsomme -= pourcentageConsomme;
		if(this.pourcentageConsomme < 0)
			throw new IllegalArgumentException("Pourcentage de consommation supérieur à la limite");
		
		return (energie * pourcentageConsomme) / 100;
	}
	
	public abstract void dessiner();
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getPourcentageConsomme() {
		return pourcentageConsomme;
	}
}
