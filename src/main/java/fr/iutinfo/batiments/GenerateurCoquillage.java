package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

public class GenerateurCoquillage extends Generateur{
	private int productionParMinute;
	
	public GenerateurCoquillage(Ile ile) {
		super(ile);
		productionParMinute=1;
	}

	@Override
	public void ajouterRessource() {
		ile.getEntrepot().setCoquillage(ile.getEntrepot().getCoquillage()+productionParMinute);
	}

	@Override
	public String getNom() {
		return "Generateur de coquillage";
	}

	@Override
	public void up() {
		this.nombre++;
		productionParMinute++;
	}

}
