package models.impl;

import terrain.Loft;
import models.AbsNourriture;
import models.TypeNourriture;

public class Nourriture extends AbsNourriture {

	private TypeNourriture type;
	
	public Nourriture(Loft loft, TypeNourriture type, int posX, int posY) {
		super(loft, type.getEnergie(), posX, posY);
		
		this.type = type;
	}
	
	public static Nourriture randomNourriture(Loft loft, int posX, int posY) {
		return new Nourriture(loft, TypeNourriture.randomType(), posX, posY);
	}
	
	@Override
	public void dessiner() {
		// TODO : remplir
	}

}
