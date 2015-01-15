package fr.iutinfo.batiments;

import java.util.Date;

public class CocoCanon extends BatimentDefensif {

	
	public CocoCanon() {
		this.pv=70;
		//this.tempsConstruction=5;
	}

	@Override
	public String getNom() {
		return "CocoCanon";
	}

	@Override
	public void up() {
		this.lancement= new Date();
		this.fin=lancement.
		this.enConstruction=true;
		this.nombre+=1;
	}

	@Override
	public int getPv() {
		return this.pv*nombre;
	}
}