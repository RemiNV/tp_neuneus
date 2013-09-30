package models.impl;

import terrain.Loft;
import models.AbsNourriture;
import models.Neuneu;

public class NeuneuErratique extends Neuneu {
	
	public static final int COUT_DEPLACEMENT = 1;
	
	public static final int[] ARRAY_DEPLACEMENTS_X = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static final int[] ARRAY_DEPLACEMENTS_Y = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };

	public NeuneuErratique(Loft loft, int energie, int posX, int posY) {
		super(loft, energie, posX, posY);
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
	public void manger() {
		// Recherche de nourriture sur la case
		for(AbsNourriture nourr : loft.getCase(posX, posY).getContenu()) {
			if(this.peutManger(nourr)) {
				
				int pourcentageConsomme = (int) (Math.random() * 100);
				if(pourcentageConsomme > nourr.getPourcentageConsommation())
					pourcentageConsomme = nourr.getPourcentageConsommation();
				
				this.energie += nourr.seFaireManger(pourcentageConsomme); // Consommation
				
				return; // On ne mange qu'une chose par tour
			}
				
		}
	}

	@Override
	public void dessiner() {
		// TODO : remplir
	}
	
	
	

}
