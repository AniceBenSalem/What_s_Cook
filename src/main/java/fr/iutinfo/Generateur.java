package fr.iutinfo;

import java.util.Timer;
import java.util.TimerTask;

import fr.iutinfo.batiments.Batiment;
import fr.iutinfo.exceptions.PlacementOccupeException;

public abstract class Generateur extends Batiment{
	Timer timer = new Timer();
	Ile ile ;
	int delay = 60;
	
	public Generateur (Ile ile){
		this.ile = ile;
		ile.addBatiment(this);
	}
	
	

	
	public void genererRessource()  {
		 
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
					
					ile.getEntrepot().setCoquillage(ile.getEntrepot().getCoquillage()+1);
					
			}
		}, 0,1000*delay);		
		
	}
	
	
	
	public void stopGenererRessource(){
		timer.cancel();
	}
	
	@Override
	public void amelioration() {
		
		
	}
	
	public int getNbRessource(){
		return ile.getEntrepot().getCoquillage();
	}
		
	
	
	/*public static void main(String[] args) throws PlacementOccupeException {
		Generateur g = new Generateur(new Ile(new Univers("Omega"), "moi", 5, 5));
		g.genererRessource();
		System.out.println("salut");
		try {
			Thread.sleep(6000);
			g.stopGenererRessource();
			System.out.println(g.getNbRessource());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("fini");
	}*/

	
	
}

	

	
