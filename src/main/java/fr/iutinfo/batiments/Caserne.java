package fr.iutinfo.batiments;


public class Caserne  extends Batiment {

	private final int coutDeConstructionCaserne = 150;
	private final int tempsConstructionCaserne= 15; //en minute


	/**
	 * On initialise un entrepot sur une ile
	 */
	public Caserne () {
		this.setTempsConstruction(tempsConstructionCaserne);
		this.setCoutDeConstruction(coutDeConstructionCaserne);
		this.setNombre(0);	
		}

	@Override
	public String getNom() {
		return "Caserne";
	}

	// niveau  = nombre
	@Override
	public void up() {
		this.setCoutDeConstruction(coutdeConstruction*4);
		this.setTempsConstruction((int) (tempsConstruction*1.5));
		this.nombre++;
	}

	
}
