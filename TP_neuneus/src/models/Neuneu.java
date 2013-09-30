package models;

import models.impl.Nourriture;

public abstract class Neuneu extends AbsNourriture {

	public static final int ENERGIE_DEPART = 100;
	public static final int ENERGIE_REPRODUCTION = 40;
	
	public Neuneu(int energie, int posX, int posY) {
		super(energie, posX, posY);
	}
	
	public abstract void seDeplacer();
	
	public Neuneu seReproduire(Neuneu neuneu) {
		
		if(neuneu.posX != this.posX || neuneu.posY != this.posY)
			throw new IllegalArgumentException("Reproduction impossible sur 2 cases différentes");
		
		neuneu.energie -= ENERGIE_REPRODUCTION;
		this.energie -= ENERGIE_REPRODUCTION;
		
		return randomNeuneu(ENERGIE_DEPART, posX, posY);
	}
	
	/**
	 * Indique si le neuneu peut manger un type de nourriture donné
	 * @param nourriture Objet nourriture à tester
	 * @return true sur le neuneu peut manger cet objet
	 */
	public boolean peutManger(AbsNourriture nourriture) {
		return nourriture instanceof Nourriture;
	}
	
	public void cycleDeVie() {
		// TODO : écrire
	}
	
	/**
	 * Déplacement du neuneu. Ne pas accéder directement à posX et pos Y
	 * (besoin de mettre à jour les cases)
	 * @param x nouvelle position X
	 * @param y nouvelle position Y
	 */
	public void moveTo(int x, int y) {
		
		loft.getCase(posX, posY).getContenu().remove(this);
		
		this.posX = x;
		this.posY = y;
		
		loft.getCase(posX, posY).getContenu().add(this);
	}
	
	
	public static Neuneu randomNeuneu(int energie, int posX, int posY) {
		// TODO : écrire
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
}
