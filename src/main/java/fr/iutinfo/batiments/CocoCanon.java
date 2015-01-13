package fr.iutinfo.batiments;

public class CocoCanon extends BatimentDefensif {

	public CocoCanon() {
		this.tempsConstruction = 0;
		this.coutdeConstruction = 50;
		this.nombre = 1;
		this.pv = 100*nombre;
	}

	@Override
	public String getNom() {
		return "CocoCanon";
	}

	@Override
	public void up() {
		this.nombre++;		
	}
}