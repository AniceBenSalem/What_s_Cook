package fr.iutinfo.unites;

import java.util.HashMap;
import java.util.Map;

public abstract class Unite {
	protected int nombre;
	protected int pv;
	protected int force;
	protected int coutDeplacement;
	protected int tempsFabrication; // en secondes
	protected int niveauCaserneNecessaire; // niveau de la caserne a partir duquel on peut construire l'unite
	String nom;
	protected Map <String, Integer> coutFabrication; 
	

	public Unite () {
		this.coutFabrication = new HashMap <String, Integer> ();
	}
	
	public int getNombre(){
		return nombre;
	}
	
	public abstract void up();
	/**
	 * Initialise le cout de fabrication selon les ressources
	 */
	public abstract void initialiseCoutFabrication ();
	
	/**
	 * Retourne le nom de l'unité
	 */
	public abstract String getNom();
	/**
	 * Fais attaquer une unite contre une autre unite.
	 */
	
	public void attaque(Unite u) {
		u.pv = u.pv - this.force;
	}
	
	/**
	 * Fait subir i degats a cette unite.
	 */
	public void subitDegats(int i){
		this.pv-=i;
	}
	
	public int getForce(){
		return this.force;
	}
	
	public int getPV(){
		return this.pv;
	}
	
	public int getCoutDeplacement() {
		return this.coutDeplacement;
	}
	
	public abstract String getDescription();
	
	public int getNiveauCaserneRequis(){
		return this.niveauCaserneNecessaire;
	}
	
	public boolean estMort(){
		return pv<=0;
	}
}
