package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

public class GenerateurCoquillage extends Generateur{
	private int productionParMinute;
	private int coutConstruction = 100; 
	
	public GenerateurCoquillage(Ile ile) {
		super(ile);
		productionParMinute=1;
	}

	@Override
	public void ajouterRessource() {
		ile.getEntrepot().ajouter("Coquillage",productionParMinute);
	}

	@Override
	public String getNom() {
		return "Generateur de coquillage";
	}

	@Override
	public void up() {
		this.nombre++;
		coutConstruction = (int) (coutConstruction * 1.8);
		productionParMinute= (int) (productionParMinute*1.5);
	}

}
