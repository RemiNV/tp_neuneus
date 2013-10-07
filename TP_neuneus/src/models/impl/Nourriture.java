package models.impl;

import java.awt.Graphics;
import java.awt.Image;

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
	public void dessiner(Graphics g, int x, int y) {
		
		String filenameNourriture = null;
		switch(type) {
		case CHOUX:
			filenameNourriture = "imgChou.png";
			break;
		case CAROTTES:
			filenameNourriture = "imgCarotte.png";
			break;
		case VODKA:
			filenameNourriture = "imgVodka.png";
			break;
		case SAKE:
			filenameNourriture = "imgSake.png";
			break;
		case WHISKY:
			filenameNourriture = "imgWhisky.png";
			break;
		}
		
		Image img = getImage(filenameNourriture, Loft.TAILLE_CONTENU_CASE, Loft.TAILLE_CONTENU_CASE);
		
		g.drawImage(img, x, y, null);
	}
	
	@Override
	public String toString() {
		return type.toString() + "(reste " + this.energie + ")";
	}
}
