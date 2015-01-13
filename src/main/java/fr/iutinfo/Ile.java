package fr.iutinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.iutinfo.batiments.Batiment;
import fr.iutinfo.batiments.Entrepot;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.Unite;

public class Ile {
	private int id;
	private Univers univers;
	private String proprietaire;
	private ArrayList<Batiment> listeBatiments;
	private Entrepot entrepot;
	private Map<String,Integer> reserve; //une map representant les reserves d'unite disponibles, sous la forme <Type d'unité,nombre disponible>
	int x; 
	int y;
	
	public Ile(Univers univers,String proprietaire, int x, int y) throws PlacementOccupeException{
		this.id=univers.getMaxId()+1;
		this.univers=univers;
		this.proprietaire=proprietaire;
		this.listeBatiments = new ArrayList <Batiment> ();
		this.entrepot=new Entrepot();
		univers.addIle(this, x, y);
		this.x = x;
		this.y = y;
		this.reserve = new HashMap<String,Integer>();
	}
	
	public void addUnite(Unite u){
		if(reserve.containsKey(u.getNom())){
			reserve.put(u.getNom(), reserve.get(u.getNom())+1);
		}else{
			reserve.put(u.getNom(),1);
		}
	}
	public void construire(Batiment b){
		listeBatiments.add(b);
	}
	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
	
	public void addBatiment (Batiment b) {
		this.listeBatiments.add(b);
	}
	
	public Entrepot getEntrepot () {
		return entrepot;
	}
	
	
}
