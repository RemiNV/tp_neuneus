package models.impl;

import java.awt.Graphics;
import java.awt.Image;

import terrain.Loft;
import models.AbsNourriture;

public class NeuneuVorace extends NeuneuErratique {

	public NeuneuVorace(Loft loft, int energie, int posX, int posY) {
		super(loft, energie, posX, posY);
	}
	
	@Override
	public void seDeplacer() {
		AbsNourriture nourr = chercherNourriture();
		
		if(nourr != null) {
			this.energie -= NeuneuErratique.COUT_DEPLACEMENT;
			
			this.moveTo(nourr.getPosX(), nourr.getPosY());
		}
		else {
			super.seDeplacer();
		}
	}
	
	// Recherche quelque chose de comestible adjacent au neuneu, retourne le premier résultat
	private AbsNourriture chercherNourriture() {
		for(int i=0; i<NeuneuErratique.ARRAY_DEPLACEMENTS_X.length; i++) {
			int x = posX + NeuneuErratique.ARRAY_DEPLACEMENTS_X[i];
			int y = posY + NeuneuErratique.ARRAY_DEPLACEMENTS_Y[i];
			
			if(loft.caseValide(x, y)) {
				
				for(AbsNourriture absNourr : loft.getCase(x, y).getContenu()) {
					if(this.peutManger(absNourr))
						return absNourr;
				}
			}
		}
		
		return null;
	}
	
	@Override
	public void dessiner(Graphics g, int x, int y) {
		Image img = getImage("imgNeuneuVorace.png", Loft.TAILLE_CONTENU_CASE, Loft.TAILLE_CONTENU_CASE);
		
		g.drawImage(img, x, y, null);
	}
	
	@Override
	public String getNomNeuneu() {
		return "Vorace";
	}

}
