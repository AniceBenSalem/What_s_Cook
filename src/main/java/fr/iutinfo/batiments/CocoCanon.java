package fr.iutinfo.batiments;

public class CocoCanon extends BatimentDefensif {

	public CocoCanon() {
		this.tempsConstruction = 0;
		this.coutDeConstruction = 50;
		this.nombre = 0;
		this.pv = 100;
	}

	@Override
	public String getNom() {
		return "CocoCanon";
	}

	@Override
	public void up() {
		this.nombre++;		
	}

	@Override
	public int getPv() {
		return this.pv*nombre;
	}
}