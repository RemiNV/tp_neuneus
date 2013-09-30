package models.impl;

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
	public void dessiner() {
		// TODO : remplir
	}

}
