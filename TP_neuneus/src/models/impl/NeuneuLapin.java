package models.impl;

import terrain.Loft;
import models.Neuneu;

public class NeuneuLapin extends NeuneuErratique {

	public NeuneuLapin(Loft loft, int energie, int posX, int posY) {
		super(loft, energie, posX, posY);
	}

	@Override
	public void seDeplacer() {
		Neuneu neuneuTrouve = chercherNeuneu();
		
		if(neuneuTrouve != null) {
			this.energie -= NeuneuErratique.COUT_DEPLACEMENT;
			
			moveTo(neuneuTrouve.getPosX(), neuneuTrouve.getPosY());
		}
		else {
			super.seDeplacer();
		}
	}
	
	/**
	 * Recherche un neuneu adjacent et le retourne
	 * @return Le premier neuneu adjacent trouvé
	 */
	private Neuneu chercherNeuneu() {
		for(int i=0; i<NeuneuErratique.ARRAY_DEPLACEMENTS_X.length; i++) {
			int x = posX + NeuneuErratique.ARRAY_DEPLACEMENTS_X[i];
			int y = posY + NeuneuErratique.ARRAY_DEPLACEMENTS_Y[i];
			
			Neuneu neuneu;
			
			if(loft.caseValide(x,  y) && (neuneu = loft.getCase(x, y).getFirstNeuneu()) != null) {
				return neuneu;
			}
		}
		
		return null;
	}
	
	@Override
	public void dessiner() {
		// TODO : écrire
	}
}
