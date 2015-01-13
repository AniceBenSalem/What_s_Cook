package fr.iutinfo;

import java.util.ArrayList;

public class Ile {
	private int id;
	private Univers univers;
	private String proprietaire;
	private ArrayList<Batiment> listeBatiments;
	private Armee armee;
	
	
	public Ile(Univers univers,String proprietaire, int x, int y) throws PlacementOccupeException{
		this.id=univers.getMaxId()+1;
		this.univers=univers;
		this.proprietaire=proprietaire;
		this.armee=new Armee();
		this.listeBatiments = new ArrayList <Batiment> ();
		univers.addIle(this, x, y);
	}
	
	public void construire(Batiment b){
		listeBatiments.add(b);
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

	public ArrayList<Batiment> getBatiments() {
		return listeBatiments;
	}

	public void setBatiments(ArrayList<Batiment> batiments) {
		this.listeBatiments = batiments;
	}

	public Armee getArmee() {
		return armee;
	}

	public void setArmee(Armee armee) {
		this.armee = armee;
	}
	
	public void addBatiment (Batiment b) {
		this.listeBatiments.add(b);
	}
	
}
