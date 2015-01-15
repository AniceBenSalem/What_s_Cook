package fr.iutinfo.batiments;

import java.util.Calendar;
import java.util.Date;

public class CocoCanon extends BatimentDefensif {

	
	public CocoCanon() {
		this.pv=70;
		this.tempsConstruction=5;
		this.coutdeConstruction=40;
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