package fr.iutinfo.batiments;

import fr.iutinfo.exceptions.NoCoquillageException;


/**
 * Sert a stocker les ressources d'une ile
 * @author dumetza
 *
 */
public class Entrepot extends Batiment {

	private int coquillage = 0;
	private int capacite = 200;
	private int coutDeConstructionEntrepot = 100;
	private int tempsConstructionEntrepot = 11; //en minute
	
	
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
	 */
	public Entrepot () {
		this.setCoquillage(coquillage);
		this.setCapacite(capacite);
		this.setTempsConstruction(tempsConstructionEntrepot);
		this.setCoutdeConstruction(coutDeConstructionEntrepot);
		this.setNombre(0);
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
	public String getNom() {
		return "Entrepot";
	}

	/**
	 * On double la capacite de stockage a chaque augmentation de niveau
	 */
	@Override
	public void up() {
		this.setCapacite(this.capacite *2);
		this.setCoutdeConstruction(coutdeConstruction*4);
		this.setTempsConstruction((int) (tempsConstruction*1.5));
	}
}
