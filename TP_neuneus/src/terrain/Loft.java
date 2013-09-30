package terrain;

import java.util.LinkedHashSet;

import models.Neuneu;

public class Loft {
	private LinkedHashSet<Neuneu> neuneus;
	private Case[] cases;
	private int tailleX;
	private int tailleY;
	
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
}
