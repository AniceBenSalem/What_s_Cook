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

	/*General*/
	private int id;
	private Univers univers;
	private String proprietaire;
	boolean dansUnClan;
	private int points;
	
	/*pos*/
	int x; 
	int y;
	
	/*Unites*/
	private SurfeurCroMagnon surfeur;
	
	/*Armees*/
	private Map<String,Integer> reserve; //une map representant les reserves d'unite disponibles, sous la forme <Type d'unité,nombre disponible>
	private Armee armee;
	
	/*Batiments*/
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
		this.points = 0;
	}

	public boolean isDansUnClan() {
		return dansUnClan;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
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
	
	public void upCromagnonSurfeur(){
		int cout = surfeur.getCoutFabrication("Coquillage");
		if(this.entrepot.getCoquillage()>=cout){
			generateurCoquillage.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-cout);
			this.setPoints(this.points + 5);
		}
<<<<<<< HEAD
		
		points +=5;
	}
=======
>>>>>>> 0c3df4ee1cbf68e52b83e7b6d71ce80554816737

	}
	
	public void upGenerateurCoquillage(){
		int cout = generateurCoquillage.getCoutDeConstruction();
		if(this.entrepot.getCoquillage()>=cout){
			generateurCoquillage.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-cout);
			this.setPoints(this.points + 100);
		}
	}

	public void upEntrepot(){
		int cout = entrepot.getCoutDeConstruction();
		if(this.entrepot.getCoquillage()>cout){
			entrepot.up();
<<<<<<< HEAD
			entrepot.setCoquillage(entrepot.getCoquillage()-entrepot.getCoutDeConstruction());
			points += 80;
		}	
=======
			entrepot.setCoquillage(entrepot.getCoquillage()-cout);
			this.setPoints(this.points + 80);
		}	
		

>>>>>>> 0c3df4ee1cbf68e52b83e7b6d71ce80554816737
	}

	public void upCococanon(){
		int cout = cococanon.getCoutDeConstruction();
		if(this.entrepot.getCoquillage()>cout){
			cococanon.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-cout);
			this.setPoints(this.points + 120);

		}
<<<<<<< HEAD
		points += 120;
=======
>>>>>>> 0c3df4ee1cbf68e52b83e7b6d71ce80554816737
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
