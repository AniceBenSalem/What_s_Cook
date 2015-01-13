package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

public class GenerateurCoquillage extends Generateur{

	public GenerateurCoquillage(Ile ile) {
		super(ile);
	}

	@Override
	public void ajouterRessource() {
		ile.getEntrepot().setCoquillage(ile.getEntrepot().getCoquillage()+1);
	}

	@Override
	public String getNom() {
		return "Generateur de coquillage";
	}

	@Override
	public void up() {
		this.nombre++;
	}

}
