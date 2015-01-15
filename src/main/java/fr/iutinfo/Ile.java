package fr.iutinfo;



import java.sql.Connection;
import java.sql.SQLException;

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
	ConnectionSQL connectionSQL = new ConnectionSQL();
	Connection conn = null;
	
	public Caserne getCaserne() {
		return caserne;
	}

	public void setCaserne(Caserne caserne) {
		this.caserne = caserne;
	}

	public ConnectionSQL getCon() {
		return connectionSQL;
	}

	public void setCon(ConnectionSQL con) {
		this.connectionSQL = con;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSurfeur(SurfeurCroMagnon surfeur) {
		this.surfeur = surfeur;
	}

	public void setArmee(Armee armee) {
		this.armee = armee;
	}

	public void setEntrepot(Entrepot entrepot) {
		this.entrepot = entrepot;
	}

	public void setGenerateurCoquillage(Generateur generateurCoquillage) {
		this.generateurCoquillage = generateurCoquillage;
	}

	public void setCococanon(CocoCanon cococanon) {
		this.cococanon = cococanon;
	}

	public Univers getUnivers() {
		return univers;
	}

	public void setUnivers(Univers univers) {
		this.univers = univers;
	}



	
	public Ile(Univers univers,String proprietaire, int x, int y) throws PlacementOccupeException, SQLException{
		//this.id=univers.getMaxId()+1;
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

		this.points = 0;
		
		/*Connection sql*/

		conn = connectionSQL.getCon();
		connectionSQL.addIle(this);
		
		conn.close();
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

	public void setDansUnClan(boolean dansUnClan) throws SQLException {
		connectionSQL.setDansUnClan(this, dansUnClan);
		this.dansUnClan = dansUnClan;
	}

	public int getValeurDefense(){
		int def=0;
		def+=this.cococanon.getPv();
		return def;
	}

	public void upCromagnonSurfeur(){
		int cout = surfeur.getCoutFabrication("Coquillage");
		if(this.entrepot.getCoquillage()>=cout){
			surfeur.up();
			entrepot.setCoquillage(entrepot.getCoquillage()-cout);
		}

	}

	public void upGenerateurCoquillage(){
		int cout = generateurCoquillage.getCoutDeConstruction();
		if(this.entrepot.getCoquillage()>=cout){
			generateurCoquillage.lanceConstruction();
			entrepot.setCoquillage(entrepot.getCoquillage()-cout);
			this.setPoints(this.points + 100);
		}
	}

	public void upEntrepot(){
		int cout = entrepot.getCoutDeConstruction();
		if(this.entrepot.getCoquillage()>=cout){
			entrepot.lanceConstruction();
			entrepot.setCoquillage(entrepot.getCoquillage()-entrepot.getCoutDeConstruction());
			points += 80;
		}	
	}	

	public void upCococanon(){
		int cout = cococanon.getCoutDeConstruction();
		if(this.entrepot.getCoquillage()>cout){
			cococanon.lanceConstruction();
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
