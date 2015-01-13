package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

public abstract class BatimentDefensif extends Batiment{

	int force;
	int pv;

	public BatimentDefensif(String name, int idBatiment, int levelMax, int coutdeConstruction, 
			int tempsConstruction, int pv, int force, Ile ile) {
	
		super(name, idBatiment, levelMax, coutdeConstruction, tempsConstruction, ile);
		this.pv = pv;
		this.force = force;
	}
	
	public int getPv(){
		return this.pv;
	}
	
	public int getForce(){
		return this.force; 
	}
	
	public boolean estDetruit(){
		return pv <= 0 ? true : false;
	}
	
}
