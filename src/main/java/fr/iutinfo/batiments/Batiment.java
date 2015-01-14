package fr.iutinfo.batiments;



/**This class allow to create a building*/
public abstract class Batiment {
	protected int nombre, coutdeConstruction , tempsConstruction; 	

	public int getCoutdeConstruction() {
		return coutdeConstruction;
	}
	public void setCoutdeConstruction(int coutdeConstruction) {
		this.coutdeConstruction = coutdeConstruction;
	}
	public int getTempsConstruction() {
		return tempsConstruction;
	}
	public void setTempsConstruction(int tempsConstruction) {
		this.tempsConstruction = tempsConstruction;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public Batiment(){
		this.nombre=0;
	}
	public abstract String getNom();
	public abstract  void up();
	
	public int getNombre(){
		return this.nombre;
	}
}


