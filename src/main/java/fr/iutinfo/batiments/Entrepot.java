package fr.iutinfo.batiments;

import fr.iutinfo.Ile;
import fr.iutinfo.exceptions.NoCoquillageException;
import fr.iutinfo.ressources.Coquillage;
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
	 * @param ile
	 */
	public Entrepot (Ile ile) {
		super("Entrepot",2, 999, 60, 60, ile);
		this.level = 0;
		this.name = "Entrepot";
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
	public void donnerRessource (Ressource r, int montant, Entrepot e) throws NoCoquillageException {
		
		if (r instanceof Coquillage) {
		
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
		// TODO Auto-generated method stub
		
	}
}
