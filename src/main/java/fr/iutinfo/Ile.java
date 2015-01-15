package fr.iutinfo;



import site.ConnectionSQL;
import fr.iutinfo.batiments.Batiment;
import fr.iutinfo.batiments.Caserne;
import fr.iutinfo.batiments.CocoCanon;
import fr.iutinfo.batiments.Entrepot;
import fr.iutinfo.batiments.Generateur;
import fr.iutinfo.batiments.GenerateurCoquillage;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.SurfeurCroMagnon;

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
	private Armee armee;

	/*Batiments*/
	private Entrepot entrepot;
	private Caserne caserne;
	private Generateur generateurCoquillage;
	private CocoCanon cococanon;

	
	/*Connection*/
	ConnectionSQL con = null;

	
	public Ile(Univers univers,String proprietaire, int x, int y) throws PlacementOccupeException{
		this.id=univers.getMaxId()+1;
		this.univers=univers;	
		this.proprietaire=proprietaire;

		/*Batiments*/
		this.entrepot=new Entrepot();
		this.caserne = new Caserne();
		this.cococanon=new CocoCanon();
		this.generateurCoquillage=new GenerateurCoquillage(this);
		
		/*Unites*/
		this.armee=new Armee(this);
		this.surfeur=new SurfeurCroMagnon();
		
		univers.addIle(this, x, y);
		this.x = x;
		this.y = y;
		this.setDansUnClan(false);
		this.points = 0;
		
		/*Connection sql*/
		//con.getCon();
		
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
		return def;
	}

	public void upCromagnonSurfeur(){
		int cout = surfeur.getCoutFabrication("Coquillage");
		System.out.println(cout);
		if(this.entrepot.getCoquillage()>=cout){
			surfeur.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-cout);
		}

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
		if(this.entrepot.getCoquillage()>=cout){
			entrepot.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-entrepot.getCoutDeConstruction());
			points += 80;
		}	
	}	

	public void upCococanon(){
		int cout = cococanon.getCoutDeConstruction();
		if(this.entrepot.getCoquillage()>cout){
			cococanon.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-cout);
			this.setPoints(this.points + 120);
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

	public Entrepot getEntrepot () {
		return entrepot;
	}

	public Generateur getGenerateurCoquillage() {
		return this.generateurCoquillage;
	}

	public Batiment getCococanon() {
		return this.cococanon;
	}

	public void putSurfeurCromagnonArmee(){
		if(surfeur.getNombre()>0){
			SurfeurCroMagnon surf = new SurfeurCroMagnon();
			surf.up();
			this.armee.addUnite(surf);
			surfeur.retire();
		}
	}
	public SurfeurCroMagnon getSurfeur() {
		return surfeur;
	}

	public void putAllSurfeurCromagnonArmee(){
		while(this.surfeur.getNombre()>0){
			putSurfeurCromagnonArmee();
		}
	}

	public Armee getArmee() {
		return armee;
	}

}
