package fr.iutinfo.batiments;

import fr.iutinfo.Ile;

/**This class allow to create a building*/
public abstract class Batiment {
	
	protected int level, levelMax, idBatiment, coutdeConstruction , tempsConstruction; 
	protected String name;
	
	/**Allow to upgrade the level*/
	public void upgradeLevel(){
		if(level++ > levelMax)
			System.out.println("Vous êtes déjà au niveau maximum");
		else
			level++;
	}
	
	/**Return true if the current level is the max level else false*/
	public boolean isLevelMax(){
		return level == levelMax ? true : false;
	}
	
	/**Allow to know if the building is built*/
	public boolean estConstruit(boolean enConstruction){
		if (enConstruction || this.level ==0){ 
			return false; 
		}
		else{
			return true;
		}
	}
	
	/*Utile ? (instanciation à null pour supprimer un batiment)
	 * public boolean estDetruit(boolean existe){
		if(existe){ 
			return false;
		}
		return true;
	}*/
	
	/**Allow to improve the building*/
	public abstract void amelioration();
	
}


