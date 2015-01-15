package fr.iutinfo.batiments;

import fr.iutinfo.Ile;
import fr.iutinfo.Univers;
import fr.iutinfo.exceptions.NoCoquillageException;


/**
 * Sert a stocker les ressources d'une ile
 * @author dumetza
 *
 */
public class Entrepot extends Batiment {

	private int coquillage;
	private int capacite;
	private int coutDeConstructionEntrepot;
	private int tempsConstructionEntrepot; //en minute


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
		if(this.coquillage<0)
			this.coquillage=0;
	}


	/**
	 * On initialise un entrepot sur une ile
	 */
	public Entrepot () {
		coquillage=0;
		capacite = 200;
		coutDeConstructionEntrepot = 100;
		tempsConstructionEntrepot = 11;
		this.setNombre(1);	
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

	public void ajouter(String ressource,int montant ){
		switch(ressource){
		case "Coquillage":	
			this.coquillage+=montant;
			break;
		}
	}

	public void retirer(String ressource,int montant){
		switch(ressource){
		case "Coquillage":
			this.coquillage-=montant;
			if(this.coquillage<0)
				this.coquillage=0;
			break;
		default:
			break;
		}
	}

	@Override
	public String getNom() {
		return "Entrepot";
	}

	// niveau  = nombre
	@Override
	public void up() {
		this.setCapacite(this.capacite *2);
		this.setCoutDeConstruction(coutdeConstruction*4);
		this.setTempsConstruction((int) (tempsConstruction*1.5));
		this.nombre++;
	}
}
