package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

public class CocoCanon extends BatimentDefensif{

	public CocoCanon(Ile ile) {
		
		this.level = 0;
		this.name = "CocoCanon";
		ile.addBatiment(this);
	}
	@Override
	public void amelioration() {
		this.level ++;
		
	}
}