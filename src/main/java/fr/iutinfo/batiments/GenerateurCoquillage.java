package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

public class GenerateurCoquillage extends Generateur{
	private int valeur;
	
	public GenerateurCoquillage(Ile ile) {
		super(ile);
		valeur=1;
	}

	@Override
	public void ajouterRessource() {
		ile.getEntrepot().setCoquillage(ile.getEntrepot().getCoquillage()+valeur);
	}

	@Override
	public String getNom() {
		return "Generateur de coquillage";
	}

	@Override
	public void up() {
		this.nombre++;
		valeur++;
	}

}
