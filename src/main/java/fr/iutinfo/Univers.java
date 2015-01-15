package fr.iutinfo;

import java.sql.Time;
import java.util.ArrayList;

import fr.iutinfo.exceptions.PlacementOccupeException;

public class Univers {
	private String nomUniver;
	private ArrayList<Ile> listeIle;
	private Ile [][] repere;
	
	
	public Ile[][] getRepere() {
		return repere;
	}

	public void setRepere(Ile[][] repere) {
		this.repere = repere;
	}

	public Univers (String nomUniver) {
		this.nomUniver = nomUniver;
		listeIle = new ArrayList<Ile>();
		this.repere = new Ile [200][200];
	}
	
	
	public Ile getIleFromUnivers(int x, int y) {
		return this.repere[x][y];
	}
	
	public void initialiseRepere () {
		for (int i = 0; i < repere.length; i++) {
			for (int j = 0; j < repere.length; j++) {
				this.repere[i][j] = null;
			}
		}
	}
	
	public ArrayList<Ile> getListeIle() {
		return listeIle;
	}
	
	public void addIle(Ile ile, int x, int y) throws PlacementOccupeException{
		if (this.repere[x][y] == null) {
			listeIle.add(ile);
			repere[x][y] = ile;
		}

		else{
			throw new PlacementOccupeException();
		}
		
	}
	
	public String getNomUnivers(){
		return nomUniver;
	}
	
	public int getMaxId(){
		return listeIle.size();
	}
	
	
	public String toString(){
		return  "l'univer "+getNomUnivers()+" possede "+getListeIle().size()+ " ile(s).";
	}
	
	
}
