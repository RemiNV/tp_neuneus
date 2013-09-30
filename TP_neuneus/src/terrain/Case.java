package terrain;

import java.util.LinkedHashSet;

import models.AbsNourriture;
import models.Neuneu;

public class Case {
	public LinkedHashSet<AbsNourriture> contenu;
	
	public Case() {
		contenu = new LinkedHashSet<AbsNourriture>();
	}
	
	public LinkedHashSet<AbsNourriture> getContenu() {
		return contenu;
	}
	
	/**
	 * Recherche le premier neuneu présent dans la case
	 * @return Le premier neuneu trouvé
	 */
	public Neuneu getFirstNeuneu() {
		for(AbsNourriture nourriture : contenu) {
			if(nourriture instanceof Neuneu)
				return (Neuneu) nourriture;
		}
		
		return null;
	}
}
