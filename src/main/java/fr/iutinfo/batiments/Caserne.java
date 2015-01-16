package fr.iutinfo.batiments;

import java.sql.SQLException;

import site.ConnectionSQL;
import fr.iutinfo.Ile;

public class Caserne extends Batiment {

	private final int coutDeConstructionCaserne = 150;
	private final int tempsConstructionCaserne = 15; // en minute
	private int k = 10;

	/**
	 * On initialise un entrepot sur une ile
	 * @throws SQLException 
	 */
	public Caserne(Ile i) throws SQLException {
		this.i=i;
		this.setTempsConstruction(tempsConstructionCaserne);
		this.setCoutDeConstruction(coutDeConstructionCaserne);
		this.setNombre(0);
		this.id = k;
		this.k ++;
		
	}

	@Override
	public String getNom() {
		return "Caserne";
	}

	// niveau = nombre
	@Override
	public void up() {
		this.setCoutDeConstruction(coutdeConstruction * 4);
		this.setTempsConstruction((int) (tempsConstruction * 1.5));
		this.nombre++;
	
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCoutDeConstructionCaserne() {
		return coutDeConstructionCaserne;
	}

	public int getTempsConstructionCaserne() {
		return tempsConstructionCaserne;
	}

}
