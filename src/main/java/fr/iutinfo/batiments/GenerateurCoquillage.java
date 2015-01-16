package fr.iutinfo.batiments;

import java.sql.SQLException;

import site.ConnectionSQL;
import fr.iutinfo.Ile;

public class GenerateurCoquillage extends Generateur{
	
	private int coutConstruction = 100; 
	
	public GenerateurCoquillage(Ile ile) throws SQLException { // OK
		super(ile);
		this.productionCoquillageParMinute=1;
	}
	
	public int getProductionParMinute() {
		return productionCoquillageParMinute;
	}

	public void setProductionParMinute(int productionParMinute) {
		this.productionCoquillageParMinute = productionParMinute;
	}
	
	@Override
	public void ajouterRessource() {
		ile.getEntrepot().ajouter("Coquillage",productionCoquillageParMinute);
	}

	@Override
	public String getNom() {
		return "Generateur de coquillage";
	}

	@Override
	public void up() {
		this.nombre++;
		coutConstruction = (int) (coutConstruction * 1.8);
		productionCoquillageParMinute= (int) (productionCoquillageParMinute*1.5);
	}

}
