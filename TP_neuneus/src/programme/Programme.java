package programme;

import models.Neuneu;
import models.impl.Nourriture;
import terrain.Loft;

public class Programme {

	
	public static final int MAX_ITERATIONS = 100;
	
	public static void main(String[] args) {
		// Création du loft
		Loft loft = new Loft(10, 10);
		
		// Création de la fenêtre
		
		
		// Ajout de quelques neuneus
		Neuneu.randomNeuneu(loft, 100, 5, 5);
		Neuneu.randomNeuneu(loft, 100, 7, 5);
		Neuneu.randomNeuneu(loft, 100, 5, 7);
		
		// Ajout de nourriture
		Nourriture.randomNourriture(loft, 5, 10);
		Nourriture.randomNourriture(loft, 10, 2);
		Nourriture.randomNourriture(loft, 5, 8);
		
		// Boucle du programme
		for(int i=0; i<MAX_ITERATIONS && loft.getNeuneus().size() > 0; i++) {
			for(Neuneu n : loft.getNeuneus()) {
				n.cycleDeVie();
			}
			
			// Dessin de la situation
			loft.dessiner();
		}
	}
	
	
}
