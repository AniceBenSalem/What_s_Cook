package fr.iutinfo.batiments;

public class CocoCanon extends BatimentDefensif {
	private int pvCocoCanon = 100;
	private int coutConstructionCocoCanon = 50;
	private int tempsConstructionCocoCanon = 5; //en minute
	
	public CocoCanon() {
		this.pv=100;
		this.coutConstructionCocoCanon=50;
		this.tempsConstruction=5;
	}

	@Override
	public String getNom() {
		return "CocoCanon";
	}

	@Override
	public void up() {
		this.nombre++;
		this.setPv(pvCocoCanon*nombre);	
	}

	@Override
	public int getPv() {
		return this.pv*nombre;
	}
}