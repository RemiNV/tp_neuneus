package terrain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.LinkedHashSet;

import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Neuneu;

public class Loft extends JFrame {
	
	public static final int TAILLE_CASE = 40;
	public static final int TAILLE_CONTENU_CASE = 30;
	public static final int PADDING = 5;
	
	private LinkedHashSet<Neuneu> neuneus;
	private Case[][] cases;
	private int tailleX;
	private int tailleY;
	
	@SuppressWarnings("serial")
	private class NeuneusPanel extends JPanel {
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(tailleX * TAILLE_CASE, tailleY * TAILLE_CASE);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			// Dessin de la grille
			for(int i=0; i<=tailleX; i++) {
				g.drawLine(i*TAILLE_CASE, 0, i*TAILLE_CASE, tailleY*TAILLE_CASE);
			}
			
			for(int i=0; i<=tailleY; i++) {
				g.drawLine(0, i*TAILLE_CASE, tailleX*TAILLE_CASE, i*TAILLE_CASE);
			}
			
			// Dessin des éléments
			for(int i=0; i<cases.length; i++) {
				for(int j=0; j<cases[i].length; j++) {
					cases[i][j].dessiner(g, i*TAILLE_CASE, j*TAILLE_CASE);
				}
			}
		}
	};
	
	public Loft(int tailleX, int tailleY) {
		super("Loft");
		
		// Initialisation des attributs
		cases = new Case[tailleX][tailleY];
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		this.neuneus = new LinkedHashSet<Neuneu>();
		
		for(int i=0; i<tailleX; i++) {
			for(int j=0; j<tailleY; j++) {
				cases[i][j] = new Case();
			}
		}
		
		// Initialisation de la fenêtre
		this.setSize((tailleX+1) * TAILLE_CASE, 50 + (tailleY+1) * TAILLE_CASE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new NeuneusPanel());
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
	
	public LinkedHashSet<Neuneu> getNeuneus() {
		return neuneus;
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
