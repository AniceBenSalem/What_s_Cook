package fr.iutinfo.batiments;



/**This class allow to create a building*/
public abstract class Batiment {
	protected int nombre, coutdeConstruction, tempsConstruction; 	

	public int getCoutdeConstruction() {
		return coutdeConstruction;
	}
	public void setCoutdeConstruction(int coutdeConstruction) {
		this.coutdeConstruction = coutdeConstruction;
	}
	public int getTempsConstruction() { //en minute
		return tempsConstruction;
	}
	public void setTempsConstruction(int tempsConstruction) { // en minute
		this.tempsConstruction = tempsConstruction;
	}
	
	public int getNombre() {
		return this.nombre;
	}
	
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}	

	public Batiment(){
		this.nombre=0;
	}
	
	public abstract String getNom();
	public abstract  void up();
	
}


