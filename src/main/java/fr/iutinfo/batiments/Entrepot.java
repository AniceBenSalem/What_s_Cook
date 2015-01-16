package fr.iutinfo.batiments;


import java.sql.Connection;
import java.sql.SQLException;

import site.ConnectionSQL;
import fr.iutinfo.Ile;
import fr.iutinfo.Univers;

import fr.iutinfo.exceptions.NoCoquillageException;


/**
 * Sert a stocker les ressources d'une ile
 * @author dumetza
 *
 */
public class Entrepot extends Batiment {

	private int coquillage;
	private int capacite;

	/*Connection*/
	ConnectionSQL connectionSQL = new ConnectionSQL();
	Connection conn = null;
	
	private Ile ile;
	
	
	/**
	 * On initialise un entrepot sur une ile
	 * @throws SQLException 
	 */
	public Entrepot (Ile i) throws SQLException {
		coquillage=0;
		this.ile = i;
		capacite = 200;
		coutdeConstruction = 100;
		tempsConstruction= 11;
		this.setNombre(1);	

	}
	
	public Ile getIle() {
		return ile;
	}

	public void setIle(Ile ile) {
		this.ile = ile;
	}

	
	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public int getCoquillage() {
		return coquillage;
	}

	public void setCoquillage(int coquillage) {
		this.coquillage = coquillage;
		if(this.coquillage<0)
			this.coquillage=0;
	}

	/**
	 * Donne des ressources au joueur possedant l'entrepot e
	 * @param r
	 * @param montant
	 * @param e
	 * @throws NoCoquillageException 
	 */
	public void donnerRessource (String ressource, int montant, Entrepot e) throws NoCoquillageException {

		if (ressource.equals("Coquillage")) {

			if (this.coquillage >= montant) {
				this.coquillage -= montant;
				e.coquillage += montant;
			}

			else {
				throw new NoCoquillageException();
			}
		}

	}

	public void ajouter(String ressource,int montant ){
		switch(ressource){
		case "Coquillage":	
			this.coquillage+=montant;
			if(this.coquillage>capacite)
				this.coquillage=capacite;
			break;
		default:
			break;
		}
		
	}

	public void retirer(String ressource,int montant){
		switch(ressource){
		case "Coquillage":
			this.coquillage-=montant;
			if(this.coquillage<0)
				this.coquillage=0;
			break;
		default:
			break;
		}
	}

	@Override
	public String getNom() {
		return "Entrepot";
	}

	// niveau  = nombre
	@Override
	public void up() {
		this.setCapacite(this.capacite *2);
		this.setCoutDeConstruction(coutdeConstruction*4);
		this.setTempsConstruction((int) (tempsConstruction*1.5));
		this.nombre++;
	}
}
