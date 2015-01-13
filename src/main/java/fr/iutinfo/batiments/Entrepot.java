package fr.iutinfo.batiments;

import fr.iutinfo.Ile;
import fr.iutinfo.exceptions.NoCoquillageException;
import fr.iutinfo.ressources.Ressource;


/**
 * Sert a stocker les ressources d'une ile
 * @author dumetza
 *
 */
public class Entrepot extends Batiment {

	private int coquillage;
	
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
		this.coquillage=0;

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
}
