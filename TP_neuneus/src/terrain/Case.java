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
	 * @return Le premier neuneu trouvé, ou null si aucun trouvé
	 */
	public Neuneu getFirstNeuneu() {
		for(AbsNourriture nourriture : contenu) {
			if(nourriture instanceof Neuneu)
				return (Neuneu) nourriture;
		}
		
		return null;
	}
	
	/**
	 * Recherche le premier neuneu présent dans la case et ayant une énergie donnée, à l'exception du neuneu donné
	 * @param excl Neuneu à ignorer
	 * @param energieMin Energie minimum pour le neuneu à rechercher
	 * @return Premier neuneu trouvé, ou null si aucun trouvé
	 */
	public Neuneu getFirstNeuneu(Neuneu excl, int energieMin) {
		for(AbsNourriture nourriture : contenu) {
			if(nourriture instanceof Neuneu && nourriture != excl && nourriture.getEnergie() >= energieMin)
				return (Neuneu) nourriture;
		}
		
		return null;
	}
}
