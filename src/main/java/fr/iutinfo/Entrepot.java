package fr.iutinfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Sert a stocker les ressources d'une ile
 * @author dumetza
 *
 */
public class Entrepot extends Batiment {
	
	Map <String, Integer> ressources;
	
	public Entrepot (Ile ile) {
		super(200, 2, 1000, 60);
		this.niveau = 0;
		this.nom = "Entrepot";
		this.ressources = new HashMap <String, Integer> ();
	}
	
	public void initialiseRessources() {
		this.ressources.put ("Coquillage", 0);
	}

	@Override
	public void amelioration(int niveau, int coutAmelioraiton,
			int tempsConstruction) {

	}
	

	/**
	 * Donne des ressources au joueur possedant l'entrepot e
	 * @param r
	 * @param montant
	 * @param e
	 */
	public void donnerRessource (Ressource r, int montant, Entrepot e) {

	}
}
