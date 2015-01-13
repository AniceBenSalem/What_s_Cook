package fr.iutinfo;

import java.util.HashMap;
import java.util.Map;

public abstract class Unite {
	
	int pv;
	int force;
	int id;
	int coutDeplacement;
	int tempsFabrication; // en secondes
	int niveauCaserneNecessaire; // niveau de la caserne a partir duquel on peut construire l'unite
	String nom;
	Map <String, Integer> coutFabrication; 
	

	public Unite () {
		this.coutFabrication = new HashMap <String, Integer> ();
	}
	
	/**
	 * Initialise le cout d'un deplacement
	 */
	public void initialiseDeplacement () {
		this.coutDeplacement = this.force + this.pv;
	}

	/**
	 * Initialise le cout de fabrication selon les ressources
	 */
	public abstract void initialiseCoutFabrication ();
}
