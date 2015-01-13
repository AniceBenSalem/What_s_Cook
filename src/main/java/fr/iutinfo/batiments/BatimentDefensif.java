package fr.iutinfo.batiments;



public abstract class BatimentDefensif extends Batiment{
	Ile ile;
	int force;
	int pv;
	
	public BatimentDefensif(Ile i){
		this.ile=i;
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
