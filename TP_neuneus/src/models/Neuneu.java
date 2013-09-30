package models;

import terrain.Loft;
import models.impl.NeuneuCannibale;
import models.impl.NeuneuErratique;
import models.impl.NeuneuLapin;
import models.impl.NeuneuVorace;
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
		
		return randomNeuneu(loft, ENERGIE_DEPART, posX, posY);
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
	
	
	/**
	 * Créé un Neuneu au hasard et l'ajoute au plateau de jeu
	 * @param energie Energie du neuneu
	 * @param posX Position x
	 * @param posY Position y
	 * @return Un neuneu initialisé et inséré dans le plateau de jeu
	 */
	public static Neuneu randomNeuneu(Loft loft, int energie, int posX, int posY) {
		int typeNeuneu = (int) (Math.random() * 4);
		
		Neuneu resNeuneu;
		
		switch(typeNeuneu) {
		case 0:
			resNeuneu = new NeuneuErratique(energie, posX, posY);
			break;
		case 1:
			resNeuneu = new NeuneuLapin(energie, posX, posY);
			break;
		case 2:
			resNeuneu = new NeuneuVorace(energie, posX, posY);
			break;
		case 3:
			resNeuneu = new NeuneuCannibale(energie, posX, posY);
			break;
		default:
			throw new IllegalStateException();	
		}
		
		// Placement du neuneu dans le plateau
		loft.getCase(posX, posY).getContenu().add(resNeuneu);
		loft.addNeuneu(resNeuneu);
		
		return resNeuneu;
	}

}
