package fr.iutinfo.unites;


public class GuerrierRequin extends Unite {

	public GuerrierRequin () {
		super();
		this.nombre=0;
		this.force = 40;
		this.pv = 40;
		this.vitesseDeplacement = 2;
		this.tempsFabrication = 40;
		this.niveauCaserneNecessaire = 3;
		this.initialiseCoutFabrication();
	

	}
	
	@Override
	public void initialiseCoutFabrication() {
		this.coutFabrication.put("Coquillage", new Integer(50));
		
	}

	@Override
	public String getNom() {
		return "GuerrierRequin";
	}

	@Override
	public String getDescription() {
		return "Mi homme mi requin, ce guerrier est issue du mariage d'un grand requin blanc et d'un guerrier d'une tribut du nord";
	}

	@Override
	public void up() {
		this.nombre++;
		
	}
	
	
	
	
}
