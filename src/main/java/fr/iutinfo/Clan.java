package fr.iutinfo;

import java.util.ArrayList;

public class Clan {
	
	ArrayList <Ile> membresClan ;
	String nom;
	int capacite;
	int nombreMembres;
	
	public Clan () {
		this.setNom("clan");
		this.membresClan = new ArrayList <Ile> ();
		this.setCapacite(50);
		this.nombreMembres = 0;
		
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public ArrayList<Ile> getMembresClan() {
		return membresClan;
	}

	public void setMembresClan(ArrayList<Ile> membresClan) {
		this.membresClan = membresClan;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Ajoute un membre dans le clan
	 * @param e
	 * @return true si l'ajout a fonctionne false sinon
	 */
	public boolean addMembre (Ile e) {
		
		if (this.nombreMembres == this.capacite) {
			return false;
		}
		
		else {
			this.membresClan.add(e);
			this.nombreMembres ++;
			return true;
		}
	
	}
	
	/**
	 * Supprime un membre du clan
	 * @param e
	 * @return true si la suppression a fonctionne false sinon
	 */
	public boolean removeMembre (Ile e) {
		if (this.nombreMembres <=0) {
			return false;
		}
		else {
			this.membresClan.remove(e);
			this.nombreMembres --;
			return true;
		}
		
	}
	
}