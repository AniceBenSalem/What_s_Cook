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

	/*Unites*/
	private SurfeurCroMagnon surfeur;

	/*Armees*/
	private Armee armee;

	/*Batiments*/
	private Entrepot entrepot;
	private Caserne caserne;
	private GenerateurCoquillage generateurCoquillage;
	private CocoCanon cococanon;
	
	public Ile(Univers univers,String proprietaire) throws PlacementOccupeException, SQLException{
		this.id=ConnectionSQL.getMaxID();
		this.univers=univers;	
		this.proprietaire=proprietaire;
		this.points = 0;
		
		/*
		 * AJOUTER L'ID ICI
		 */

		/*entrepot*/
		this.entrepot=new Entrepot(this); // OK 

		// caserne
		
		this.caserne = new Caserne(this);// OK 
		
		// cococanon
		this.cococanon=new CocoCanon(this);// OK 
		this.generateurCoquillage=new GenerateurCoquillage(this);// OK 
		
		/*Unites*/
		this.armee=new Armee(this);
		this.surfeur=new SurfeurCroMagnon(this);
	}
	
	public void ajouterABDD() throws SQLException{
		ConnectionSQL.addIle(this);
	}
	
	public Caserne getCaserne() {
		return caserne;
	}

	public void setCaserne(Caserne caserne) {
		this.caserne = caserne;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
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

	public void setGenerateurCoquillage(GenerateurCoquillage generateurCoquillage) {
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

	public boolean isDansUnClan() {
		return dansUnClan;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
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

	public String getProprietaire() {
		return proprietaire;
	}

	public Entrepot getEntrepot () {
		return entrepot;
	}

	public GenerateurCoquillage getGenerateurCoquillage() {
		return this.generateurCoquillage;
	}

	public CocoCanon getCococanon() {
		return this.cococanon;
	}

	public void putSurfeurCromagnonArmee() throws SQLException{
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

	public void putAllSurfeurCromagnonArmee() throws SQLException{
		while(this.surfeur.getNombre()>0){
			putSurfeurCromagnonArmee();
		}
	}

	public Armee getArmee() {
		return armee;
	}
	
	public Integer nombreCoquillageEntrepot() {
		String s = "select coquillage from entrepot where id='" + this.entrepot.getId() + "'";
		return id;
		
	}

}
