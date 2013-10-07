package programme;

import models.Neuneu;
import models.impl.Nourriture;
import terrain.Loft;

public class Programme {

	
	public static final int MAX_ITERATIONS = 100;
	
	public static void main(String[] args) {
		// Création du loft
		Loft loft = new Loft(10, 10);
		
		loft.setVisible(true);
		
		
		
		// Ajout de quelques neuneus
		Neuneu.randomNeuneu(loft, 100, 5, 5);
		Neuneu.randomNeuneu(loft, 100, 7, 5);
		Neuneu.randomNeuneu(loft, 100, 5, 7);
		
		// Ajout de nourriture
		Nourriture.randomNourriture(loft, 5, 9);
		Nourriture.randomNourriture(loft, 9, 2);
		Nourriture.randomNourriture(loft, 5, 8);
		
		loft.repaint();

		// Boucle du programme
		for(int i=0; i<MAX_ITERATIONS && loft.getNeuneus().size() > 0; i++) {
			
			Neuneu[] neuneusATraiter = new Neuneu[loft.getNeuneus().size()];
			neuneusATraiter = loft.getNeuneus().toArray(neuneusATraiter);
			
			for(Neuneu n : neuneusATraiter) {
				if(loft.getNeuneus().contains(n)) { // Neuneu éventuellement supprimé à un tour précédent
					n.cycleDeVie();
				}
			}
			
			// Dessin de la situation
			loft.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Sleep interrompu");
				e.printStackTrace();
			}
		}

	}
	
	
}
