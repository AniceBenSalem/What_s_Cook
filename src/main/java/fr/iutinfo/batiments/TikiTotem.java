package fr.iutinfo.batiments;

import java.util.Calendar;
import java.util.Date;

public class TikiTotem extends BatimentDefensif{

	
	public TikiTotem() {
		this.pv=85;
		this.tempsConstruction=10;
		this.coutdeConstruction=65;
	}

	@Override
	public String getNom() {
		return "TikiTotem";
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