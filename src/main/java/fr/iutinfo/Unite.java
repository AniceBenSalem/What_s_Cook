package fr.iutinfo;

import java.util.HashMap;
import java.util.Map;

public abstract class Unite {
	
	protected int pv;
	protected int force;
	protected int id;
	protected int coutDeplacement;
	protected int tempsFabrication; // en secondes
	protected int niveauCaserneNecessaire; // niveau de la caserne a partir duquel on peut construire l'unite
	String nom;
	Map <String, Integer> coutFabrication; 
	

	public Unite () {
		this.coutFabrication = new HashMap <String, Integer> ();
	}
	
	public int getForce(){
		return this.force;
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
