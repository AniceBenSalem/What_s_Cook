package fr.iutinfo.batiments;

public class CocoCanon extends BatimentDefensif {
	private int pvCocoCanon = 100;
	private int coutConstructionCocoCanon = 50;
	private int tempsConstructionCocoCanon = 5; //en minute
	
	public CocoCanon() {
		this.setTempsConstruction(tempsConstructionCocoCanon);
		this.setCoutdeConstruction(coutConstructionCocoCanon);
		this.setPv(pvCocoCanon);
		this.setNombre(0);
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
}