package models;

import terrain.Loft;

public abstract class AbsNourriture {
	protected int energie;
	protected int pourcentageConsommation;
	protected Loft loft;
	protected int posX;
	protected int posY;
	
	public AbsNourriture(Loft loft, int energie, int posX, int posY) {
		this.loft = loft;
		this.pourcentageConsommation = 100;
		this.energie = energie;
		this.posX = posX;
		this.posY = posY;
		
		// Placement dans le plateau
		loft.getCase(posX, posY).getContenu().add(this);
	}
	
	/**
	 * Mange la nourriture et indique l'énergie obtenue
	 * @param pourcentageConsomme Pourcentage de nourriture à consommer. Doit être <= au pourcentage restant
	 * @return Energie obtenue en mangeant la nourriture (fonction de l'énergie de la nourriture et du pourcentage consommé)
	 */
	public int seFaireManger(int pourcentageConsomme) {
		this.pourcentageConsommation -= pourcentageConsomme;
		if(this.pourcentageConsommation < 0)
			throw new IllegalArgumentException("Pourcentage de consommation supérieur à la limite");
		
		// Objet entièrement consommé
		if(pourcentageConsommation == 0)
			this.supprimer();
		
		return (energie * pourcentageConsomme) / 100;
	}
	
	/**
	 * Suppression de l'objet du loft
	 */
	public void supprimer() {
		loft.getCase(posX, posY).getContenu().remove(this);
	}
	
	public abstract void dessiner();
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getEnergie() {
		return energie;
	}
	
	/**
	 * Pourcentage encore disponible pour la consommation
	 * @return Valeur du pourcentage disponible
	 */
	public int getPourcentageConsommation() {
		return pourcentageConsommation;
	}
}
