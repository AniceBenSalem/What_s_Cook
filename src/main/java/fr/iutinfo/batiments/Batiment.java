package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

/**This class allow to create a building*/
public abstract class Batiment {
	protected int nombre, coutdeConstruction , tempsConstruction; 	

	public Batiment(){
		this.nombre=0;
	}
	public abstract String getNom();
	
}


