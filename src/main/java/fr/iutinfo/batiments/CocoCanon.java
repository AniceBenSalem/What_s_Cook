package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

public class CocoCanon extends BatimentDefensif{

	@Override
	public String getNom() {
		return "CocoCanon";
	}

	@Override
	public void up() {
		this.nombre++;		
	}
}