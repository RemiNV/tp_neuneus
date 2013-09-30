package terrain;

import java.util.LinkedHashSet;

import models.Neuneu;

public class Loft {
	private LinkedHashSet<Neuneu> neuneus;
	private Case[][] cases;
	private int tailleX;
	private int tailleY;
	
	public Loft(int tailleX, int tailleY) {
		cases = new Case[tailleX][tailleY];
		
		for(int i=0; i<tailleX; i++) {
			for(int j=0; j<tailleY; j++) {
				cases[i][j] = new Case();
			}
		}
	}
	
	public void exclureNeuneu(Neuneu neuneu) {
		neuneus.remove(neuneu);
	}
	
	public void dessiner() {
		// TODO : remplir
	}
	
	public int getTailleX() {
		return tailleX;
	}
	
	public int getTailleY() {
		return tailleY;
	}
	
	public Case getCase(int x, int y) {
		return cases[x][y];
	}
	
	/**
	 * Fonction utilitaire indiquant si une case est valide
	 * @param x Coordonnée X
	 * @param y Coordonnée Y
	 * @return true si la case fait partie du plateau
	 */
	public boolean caseValide(int x, int y) {
		return x >= 0 && x < tailleX && y >= 0 && y < tailleY;
	}
}
