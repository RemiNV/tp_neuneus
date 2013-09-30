package programme;

import models.Neuneu;
import terrain.Loft;

public class Programme {

	public static void main(String[] args) {
		// Création du loft
		Loft loft = new Loft(10, 10);
		
		// Ajout de quelques neuneus
		Neuneu.randomNeuneu(loft, 100, 5, 5);
		Neuneu.randomNeuneu(loft, 100, 15, 5);
		Neuneu.randomNeuneu(loft, 100, 5, 15);
		
		// Ajout de nourriture
		
	}
}
