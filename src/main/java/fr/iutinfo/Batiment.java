package fr.iutinfo;

public abstract class Batiment {
	int coutdeConstruction; 
	String nom; 
	int idBatiment;
	int niveau;
	int tempsConstruction;
	int niveauMax;

	public Batiment(int coutdeConstruction, int idBatiment, int niveauMax, int tempsConstruction){
		this.coutdeConstruction = coutdeConstruction;
		this.idBatiment = idBatiment;
		this.niveauMax = niveauMax;
		this.tempsConstruction = tempsConstruction;
	}
	
	public boolean estConstruit(boolean enConstruction){
		if (enConstruction){ 
			return false; 
		}else{
			return true;
		}
	}
	public boolean estDetruit(boolean existe){
		if(existe){ 
			return false;
		}
		return true;
	}
	
	public boolean estNiveauMax(int niveau, int niveauMax){
		if (niveau >= niveauMax){
			return true; 
		}else{
			return false; 
		}
	}
	
	public abstract void amelioration(int niveau, int coutAmelioraiton, int tempsConstruction);
	
}
