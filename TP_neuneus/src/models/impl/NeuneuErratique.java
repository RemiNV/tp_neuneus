package models.impl;

import models.Neuneu;

public class NeuneuErratique extends Neuneu {
	
	public static final int COUT_DEPLACEMENT = 1;
	
	public static final int[] ARRAY_DEPLACEMENTS_X = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static final int[] ARRAY_DEPLACEMENTS_Y = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };

	public NeuneuErratique(int energie, int posX, int posY) {
		super(energie, posX, posY);
	}

	@Override
	public void seDeplacer() {
		
		this.energie -= COUT_DEPLACEMENT;

		while(true) {
			int dx = (int) (Math.random() * 3) - 1;
			
			int dy;
			if(dx == 0)
				dy = Math.random() < 0.5 ? -1 : 1;
			else
				dy = (int) (Math.random() * 3) - 1;
			
			if((dx != -1 || posX > 0) && (dx != 1 || posX < this.loft.getTailleX() - 1)
					&& (dy != -1 || posY > 0) && (dy != 1 || posY < this.loft.getTailleY() - 1)) {
				this.moveTo(posX + dx, posY + dy);
				return;
			}
		}
	}

	@Override
	public void dessiner() {
		// TODO : remplir
	}
	
	
	

}
