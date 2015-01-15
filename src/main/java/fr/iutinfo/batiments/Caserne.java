package fr.iutinfo.batiments;

public class Caserne extends Batiment {

	private final int coutDeConstructionCaserne = 150;
	private final int tempsConstructionCaserne = 15; // en minute
	private int k = 1;
	private int id;

	/**
	 * On initialise un entrepot sur une ile
	 */
	public Caserne() {
		this.setTempsConstruction(tempsConstructionCaserne);
		this.setCoutDeConstruction(coutDeConstructionCaserne);
		this.setNombre(0);
	}

	@Override
	public String getNom() {
		return "Caserne";
	}

	// niveau = nombre
	@Override
	public void up() {
		this.setCoutDeConstruction(coutdeConstruction * 4);
		this.setTempsConstruction((int) (tempsConstruction * 1.5));
		this.nombre++;
		this.id = k;
		this.k ++;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCoutDeConstructionCaserne() {
		return coutDeConstructionCaserne;
	}

	public int getTempsConstructionCaserne() {
		return tempsConstructionCaserne;
	}

}
