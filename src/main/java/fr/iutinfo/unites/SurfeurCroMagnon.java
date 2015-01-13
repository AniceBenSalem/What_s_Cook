package fr.iutinfo.unites;


public class SurfeurCroMagnon extends Unite {

	public SurfeurCroMagnon () {
		super();
		this.nombre=0;
		this.force = 10;
		this.pv = 42;
		this.coutDeplacement = 1;
		this.tempsFabrication = 20;
		this.niveauCaserneNecessaire = 1;
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
	public String getDescription() {
		return "Un homme préhistorique équipé d'un surf volant et lancant des cailloux. N'est ce pas formidable ?";
	}

	@Override
	public void up() {
		this.nombre++;
		
	}
	
	
	
	
}
