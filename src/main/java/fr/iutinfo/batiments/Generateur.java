package fr.iutinfo.batiments;

import java.util.Timer;
import java.util.TimerTask;

import fr.iutinfo.Ile;
import fr.iutinfo.exceptions.PlacementOccupeException;

public abstract class Generateur extends Batiment{
	Timer timer = new Timer();
	Ile ile ;
	int delay = 60; // delai avant generation

	public Generateur (Ile ile){
		this.ile = ile;
		this.nombre=1;
		genererRessource();
	}



	public abstract void ajouterRessource();
	
	public void genererRessource()  {
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				ajouterRessource();
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




