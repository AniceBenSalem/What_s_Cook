package fr.iutinfo;

public class SurfeurCroMagnon extends Unite {

	public SurfeurCroMagnon () {
		this.force = 10;
		this.pv = 42;
		this.tempsFabrication = 20;
		this.niveauCaserneNecessaire = 1;
		this.initialiseDeplacement();
		this.initialiseCoutFabrication();
	

	}

	@Override
	public void initialiseCoutFabrication() {
		this.coutFabrication.put("Coquillage", new Integer(20));
		
	}

	@Override
	public String getNom() {
		return "Surfeur Cro-Magnon";
	}

	@Override
	public int getPV() {
		return pv;
	}
	
	
	
	
}
