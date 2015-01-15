package fr.iutinfo.batiments;

public class CocoCanon extends BatimentDefensif {
	private int pvCocoCanon;
	private int coutConstructionCocoCanon;
	private int tempsConstructionCocoCanon; //en minute
	
	public CocoCanon() {
		this.pv=70;
		this.coutConstructionCocoCanon=40;
		this.tempsConstruction=5;
	}

	@Override
	public String getNom() {
		return "CocoCanon";
	}

	@Override
	public void up() {
		this.nombre+=1;
	}

	@Override
	public int getPv() {
		return this.pv*nombre;
	}
}