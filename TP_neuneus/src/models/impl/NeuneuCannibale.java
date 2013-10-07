package models.impl;

import java.awt.Graphics;
import java.awt.Image;

import terrain.Loft;
import models.AbsNourriture;

public class NeuneuCannibale extends NeuneuVorace {

	public NeuneuCannibale(Loft loft, int energie, int posX, int posY) {
		super(loft, energie, posX, posY);
	}
	
	@Override
	public boolean peutManger(AbsNourriture nourr) {
		return nourr != this; // On mange tout !
	}


	@Override
	public void dessiner(Graphics g, int x, int y) {
		Image img = getImage("imgNeuneuCannibale.png", Loft.TAILLE_CONTENU_CASE, Loft.TAILLE_CONTENU_CASE);
		
		g.drawImage(img, x, y, null);
	}
	
	@Override
	public String getNomNeuneu() {
		return "Cannibale";
	}
}
