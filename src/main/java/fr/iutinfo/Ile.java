package fr.iutinfo;

import java.util.HashMap;
import java.util.Map;

import fr.iutinfo.batiments.CocoCanon;
import fr.iutinfo.batiments.Entrepot;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.Unite;

public class Ile {
	
	private int id;
	private Univers univers;
	private String proprietaire;

	private Map<String,Integer> reserve; //une map representant les reserves d'unite disponibles, sous la forme <Type d'unité,nombre disponible>
	int x; 
	int y;
	
	private Entrepot entrepot;
	private Generateur generateur;
	private CocoCanon cococanon;
	
	public Ile(Univers univers,String proprietaire, int x, int y) throws PlacementOccupeException{
		this.id=univers.getMaxId()+1;
		this.univers=univers;	
		this.proprietaire=proprietaire;
		
		this.entrepot=new Entrepot();
		this.cococanon=new CocoCanon();
		this.generateur=new GenerateurCoquillage(this);
		
		univers.addIle(this, x, y);
		this.x = x;
		this.y = y;
		this.reserve = new HashMap<String,Integer>();
	}
	
	public int getValeurDefense(){
		int def=0;
		
		def+=this.cococanon.getPv()*cococanon.getNombre();
		
		return def;
	}
	public void addUnite(Unite u){
		if(reserve.containsKey(u.getNom())){
			reserve.put(u.getNom(), reserve.get(u.getNom())+1);
		}else{
			reserve.put(u.getNom(),1);
		}
	}
	
	public void upGenerateur(){
		generateur.up();
	}
	
	public void upEntrepot(){
		entrepot.up();
	}
	
	public void upCococanon(){
		cococanon.up();
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
	
	public Entrepot getEntrepot () {
		return entrepot;
	}
	
	
}
