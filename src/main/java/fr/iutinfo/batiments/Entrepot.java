package fr.iutinfo.batiments;

import fr.iutinfo.exceptions.NoCoquillageException;


/**
 * Sert a stocker les ressources d'une ile
 * @author dumetza
 *
 */
public class Entrepot extends Batiment {

	private int coquillage;
	private int capacite;
	
	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public int getCoquillage() {
		return coquillage;
	}

	public void setCoquillage(int coquillage) {
		this.coquillage = coquillage;
	}


	/**
	 * On initialise un entrepot sur une ile
	 * @param ile
	 */
	public Entrepot () {
		this.coquillage=0;
		this.level=1;
		this.levelMax=10;
		this.idBatiment=2;
		this.name = "Entrepot";
		this.capacite = 100;
		this.initialiseRessources();

	}
	
	public void initialiseRessources() {
		this.coquillage = 0;
		
	}


	/**
	 * Donne des ressources au joueur possedant l'entrepot e
	 * @param r
	 * @param montant
	 * @param e
	 * @throws NoCoquillageException 
	 */
	public void donnerRessource (String ressource, int montant, Entrepot e) throws NoCoquillageException {
		
		if (ressource.equals("Coquillage")) {
		
			if (this.coquillage >= montant) {
				this.coquillage -= montant;
				e.coquillage += montant;
			}
				
			else {
				throw new NoCoquillageException();
			}
		}
	
	}

	@Override
	public void amelioration() {
		this.level ++;
		this.capacite = this.capacite * 2;
		
	}
}
