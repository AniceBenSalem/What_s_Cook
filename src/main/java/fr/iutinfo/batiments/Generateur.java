package fr.iutinfo.batiments;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import fr.iutinfo.Ile;
import fr.iutinfo.exceptions.PlacementOccupeException;

public abstract class Generateur extends Batiment{
	Timer timer = new Timer();
	Ile ile ;
	int delay = 60; // delai avant generation
	protected int productionCoquillageParMinute;

	public Generateur (Ile ile){
		this.ile = ile;
		this.nombre=1;
		genererRessource();
	}
	
	public Ile getIle(){
		return ile;
	}

	public int getProductionCoquillage(){
		return productionCoquillageParMinute;
	}
	
	public abstract void ajouterRessource() throws SQLException;
	public void genererRessource()  {
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				try {
					ajouterRessource();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0,1000*delay);		

	}



	public void stopGenererRessource(){
		timer.cancel();
	}


	public int getNbRessource(){
		return ile.getEntrepot().getCoquillage();
	}
}




