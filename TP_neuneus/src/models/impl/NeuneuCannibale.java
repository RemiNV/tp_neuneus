package models.impl;

import terrain.Loft;
import models.AbsNourriture;

public class NeuneuCannibale extends NeuneuVorace {

	public NeuneuCannibale(Loft loft, int energie, int posX, int posY) {
		super(loft, energie, posX, posY);
	}
	
	@Override
	public boolean peutManger(AbsNourriture nourr) {
		return true; // On mange tout !
	}


	@Override
	public void dessiner() {
		// TODO : écrire
		
	}
}
