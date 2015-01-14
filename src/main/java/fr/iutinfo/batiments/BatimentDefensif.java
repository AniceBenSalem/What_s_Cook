package fr.iutinfo.batiments;



public abstract class BatimentDefensif extends Batiment{
	protected int pv;

	public abstract int getPv();
	
	public boolean estDetruit(){
		return pv <= 0 ? true : false;
	}
	
}
