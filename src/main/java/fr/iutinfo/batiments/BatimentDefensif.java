package fr.iutinfo.batiments;



public abstract class BatimentDefensif extends Batiment{
	protected int pv;

	public int getPv(){
		return this.pv;
	}
	
	public boolean estDetruit(){
		return pv <= 0 ? true : false;
	}
	
}
