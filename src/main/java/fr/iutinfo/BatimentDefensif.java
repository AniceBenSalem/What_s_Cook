package fr.iutinfo;

public abstract class BatimentDefensif extends Batiment{

	int force;
	int pv;

	public BatimentDefensif(String name, int idBatiment, int levelMax, int coutdeConstruction, 
			int tempsConstruction, int pv, int force) {
	
		super(name, idBatiment, levelMax, coutdeConstruction, tempsConstruction);
		this.pv = pv;
		this.force = force;
	}
	
	public void setPv(){
		pv -= Armee.getForce();
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
