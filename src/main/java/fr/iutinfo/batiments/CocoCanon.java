package fr.iutinfo.batiments;

import java.sql.SQLException;

import site.ConnectionSQL;
import fr.iutinfo.Ile;


public class CocoCanon extends BatimentDefensif {

	
	public CocoCanon(Ile i) throws SQLException { // OK
		this.i=i;
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