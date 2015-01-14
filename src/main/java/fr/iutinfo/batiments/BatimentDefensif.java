package fr.iutinfo.batiments;



public abstract class BatimentDefensif extends Batiment{
	protected int pv;
	
	public BatimentDefensif(){
		super();
	}
	public abstract int getPv();
	
	public void setPv(int a) {
		this.pv = a;
	}
	
	public boolean estDetruit(){
		return pv <= 0 ? true : false;
	}
	
}
