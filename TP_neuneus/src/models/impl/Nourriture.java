package models.impl;

import models.AbsNourriture;
import models.TypeNourriture;

public class Nourriture extends AbsNourriture {

	private TypeNourriture type;
	
	public Nourriture(TypeNourriture type, int posX, int posY) {
		super(type.getEnergie(), posX, posY);
	}
	
	@Override
	public void dessiner() {
		// TODO : remplir
	}

}
