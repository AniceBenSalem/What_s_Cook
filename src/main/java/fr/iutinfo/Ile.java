package fr.iutinfo;

public class Ile {
	private int id;
	private Univers univers;
	private String proprietaire;
	private ArrayList<Batiment[]> batiments;
	private Armee armee;
	
	public Ile(Univers univers,String proprietaire){
		this.id=univers.getMaxId();
		this.univers=univers;
		this.proprietaire=proprietaire;
		this.armee=new Armee();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Univers getUnivers() {
		return univers;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public ArrayList<Batiment[]> getBatiments() {
		return batiments;
	}

	public void setBatiments(ArrayList<Batiment[]> batiments) {
		this.batiments = batiments;
	}

	public Armee getArmee() {
		return armee;
	}

	public void setArmee(Armee armee) {
		this.armee = armee;
	}
	
}
