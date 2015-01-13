package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

public class CocoCanon extends BatimentDefensif{

	public CocoCanon(Ile ile) {
		super(ile);
		ile.addBatiment(this);
	}
	@Override
	public String getNom() {
		return "CocoCanon";
	}
}