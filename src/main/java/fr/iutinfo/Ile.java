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
	private Map<String,Integer> batiments;
	private Entrepot entrepot;
	private 
	private Map<String,Integer> reserve; //une map representant les reserves d'unite disponibles, sous la forme <Type d'unité,nombre disponible>
	int x; 
	int y;
	
	public Ile(Univers univers,String proprietaire, int x, int y) throws PlacementOccupeException{
		this.id=univers.getMaxId()+1;
		this.univers=univers;
		this.proprietaire=proprietaire;
		this.batiments = new HashMap<String,Integer> ();
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
	
	public void addBatiment(Batiment b){
		if(reserve.containsKey(b.getNom())){
			reserve.put(b.getNom(), reserve.get(b.getNom())+1);
		}else{
			reserve.put(b.getNom(),1);
		}
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

	public String getProprietaire() {
		return proprietaire;
	}
	
}
