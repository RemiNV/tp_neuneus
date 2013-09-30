package models.impl;

import models.AbsNourriture;

public class NeuneuCannibale extends NeuneuVorace {

	public NeuneuCannibale(int energie, int posX, int posY) {
		super(energie, posX, posY);
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
