package fr.iutinfo;

import java.util.ArrayList;

public class Clan {
	
	ArrayList <Ile> membresClan ;
	String nom;
	int capacite;
	int nombreMembres;
	int nombre;
	
	public Clan () {
		this.setNom("clan");
		this.membresClan = new ArrayList <Ile> ();
		this.setCapacite(50);
		this.nombreMembres = 0;
		this.nombre = 1;
		
	}

	public int getNombreMembres() {
		return nombreMembres;
	}

	public void setNombreMembres(int nombreMembres) {
		this.nombreMembres = nombreMembres;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
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
			this.setNombreMembres(this.nombreMembres + 1);
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
			this.setNombreMembres(this.nombreMembres - 1);
			return true;
		}
		
	}
	
}
