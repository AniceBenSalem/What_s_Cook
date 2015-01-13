package fr.iutinfo;


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
		super(200, 2, 1000, 60);
		this.niveau = 0;
		this.nom = "Entrepot";
		ile.addBatiment(this);
		this.initialiseRessources();

	}
	
	public void initialiseRessources() {
		this.coquillage = 0;
		
	}

	@Override
	public void amelioration(int niveau, int coutAmelioraiton,
			int tempsConstruction) {

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
}
