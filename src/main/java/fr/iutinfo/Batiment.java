package fr.iutinfo;

/**This class allow to create a building*/
public abstract class Batiment {
	
	protected int level, levelMax, idBatiment, coutdeConstruction , tempsConstruction; 
	protected String name;
	protected Ile ile;
	
	/**To create a building, define the name of this, id, level max, cost of construction, time of construction*/
	public Batiment(String name, int idBatiment, int levelMax, int coutdeConstruction, int tempsConstruction, Ile ile){
		this.coutdeConstruction = coutdeConstruction;
		this.idBatiment = idBatiment;
		this.levelMax = levelMax;
		this.tempsConstruction = tempsConstruction;
		this.ile = ile;
		ile.addBatiment(this);
	}
	
	/**Allow to upgrade the level*/
	public void upgradeLevel(){
		if(level++ > levelMax)
			System.out.println("you are in max level");
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


