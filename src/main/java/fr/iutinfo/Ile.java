package fr.iutinfo;

import java.util.HashMap;
import java.util.Map;

import fr.iutinfo.batiments.Batiment;
import fr.iutinfo.batiments.CocoCanon;
import fr.iutinfo.batiments.Entrepot;
import fr.iutinfo.batiments.Generateur;
import fr.iutinfo.batiments.GenerateurCoquillage;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.SurfeurCroMagnon;
import fr.iutinfo.unites.Unite;

public class Ile {

	private int id;
	private Univers univers;
	private String proprietaire;
	private boolean dansUnClan;
	private int points;
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	private Map<String,Integer> reserve; //une map representant les reserves d'unite disponibles, sous la forme <Type d'unité,nombre disponible>
	int x; 
	int y;

	private SurfeurCroMagnon surfeur;

	private Entrepot entrepot;
	private Generateur generateurCoquillage;
	private CocoCanon cococanon;

	public Ile(Univers univers,String proprietaire, int x, int y) throws PlacementOccupeException{
		this.id=univers.getMaxId()+1;
		this.univers=univers;	
		this.proprietaire=proprietaire;

		this.entrepot=new Entrepot();
		this.cococanon=new CocoCanon();
		this.generateurCoquillage=new GenerateurCoquillage(this);

		univers.addIle(this, x, y);
		this.x = x;
		this.y = y;
		this.reserve = new HashMap<String,Integer>();
		this.setDansUnClan(false);
		this.setPoints(0);
	}

	public boolean isDansUnClan() {
		return dansUnClan;
	}

	public void setDansUnClan(boolean dansUnClan) {
		this.dansUnClan = dansUnClan;
	}

	public int getValeurDefense(){
		int def=0;
		def+=this.cococanon.getPv();
		System.out.println(cococanon.getPv());
		return def;
	}
	public void addUnite(Unite u){
		if(reserve.containsKey(u.getNom())){
			reserve.put(u.getNom(), reserve.get(u.getNom())+1);
		}else{
			reserve.put(u.getNom(),1);
		}
		
		this.setPoints(this.points + 5);
	}

	public void upGenerateur(){
		if(this.entrepot.getCoquillage()>0){
			generateurCoquillage.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-generateurCoquillage.getCoutDeConstruction());
			this.setPoints(this.points + 100);
		}
	}

	public void upEntrepot(){
		if(this.entrepot.getCoquillage()>0){
			entrepot.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-entrepot.getCoutDeConstruction());
		}	
		
		this.setPoints(this.points + 80);
	}

	public void upCococanon(){
		int cout = cococanon.getCoutDeConstruction();
		if(this.entrepot.getCoquillage()>cout){
			cococanon.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-cout);
		}
		this.setPoints(this.points + 120);
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

	public Generateur getGenerateurCoquillage() {
		return this.generateurCoquillage;
	}

	public Batiment getCococanon() {
		return this.cococanon;
	}


}
