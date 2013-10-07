package models;

import terrain.Loft;
import models.impl.NeuneuCannibale;
import models.impl.NeuneuErratique;
import models.impl.NeuneuLapin;
import models.impl.NeuneuVorace;
import models.impl.Nourriture;

public abstract class Neuneu extends AbsNourriture {

	public static final int ENERGIE_DEPART = 100;
	public static final int ENERGIE_REPRODUCTION = 60;
	
	public Neuneu(Loft loft, int energie, int posX, int posY) {
		super(loft, energie, posX, posY);
		
		// Ajout au plateau
		loft.getNeuneus().add(this);
	}
	
	public abstract void seDeplacer();
	
	public abstract void manger();
	
	public Neuneu seReproduire() {
		
		if(energie > ENERGIE_REPRODUCTION) {
			
			Neuneu neuneuReproduction = loft.getCase(posX, posY).getFirstNeuneu(this, ENERGIE_REPRODUCTION);
			if(neuneuReproduction != null)
				return this.seReproduireAvec(neuneuReproduction);
		}
		
		return null;
	}
	
	public Neuneu seReproduireAvec(Neuneu neuneu) {
		
		if(neuneu.posX != this.posX || neuneu.posY != this.posY)
			throw new IllegalArgumentException("Reproduction impossible sur 2 cases différentes");
		
		neuneu.energie -= ENERGIE_REPRODUCTION;
		this.energie -= ENERGIE_REPRODUCTION;
		
		Neuneu resultat = randomNeuneu(loft, ENERGIE_DEPART, posX, posY);
		
		System.out.println("Le " + this.toString() + " se reproduit avec " + neuneu.toString() + " et donne " + resultat.toString());
		
		return resultat;
	}
	
	@Override
	public void supprimer() {
		super.supprimer();
		
		System.out.println("Le neuneu " + this.toString() + " est mort !");
		
		// Suppression aussi de la liste des neuneus du loft
		loft.getNeuneus().remove(this);
	}
	
	/**
	 * Indique si le neuneu peut manger un type de nourriture donné
	 * @param nourriture Objet nourriture à tester
	 * @return true sur le neuneu peut manger cet objet
	 */
	public boolean peutManger(AbsNourriture nourriture) {
		return nourriture instanceof Nourriture && nourriture != this;
	}
	
	public void cycleDeVie() {
		
		// Déplacement
		this.seDeplacer();
		
		// Manger
		this.manger();
		
		// Se reproduire
		this.seReproduire();
		
		if(energie <= 0)
			this.supprimer();
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
			resNeuneu = new NeuneuErratique(loft, energie, posX, posY);
			break;
		case 1:
			resNeuneu = new NeuneuLapin(loft, energie, posX, posY);
			break;
		case 2:
			resNeuneu = new NeuneuVorace(loft, energie, posX, posY);
			break;
		case 3:
			resNeuneu = new NeuneuCannibale(loft, energie, posX, posY);
			break;
		default:
			throw new IllegalStateException();	
		}
		
		return resNeuneu;
	}
	
	public abstract String getNomNeuneu();
	
	@Override
	public String toString() {
		return "Neuneu " + getNomNeuneu() + "(" + super.toString() + ")" + ", NRJ " + this.energie;
	}
	
	
}
