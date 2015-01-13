package fr.iutinfo;

import java.util.ArrayList;

public class Univers {
	private String nomUniver;
	private ArrayList<Ile> listeIle;
	private int [][] repere;
	
	
	public Univers (String nomUniver){
		this.nomUniver = nomUniver;
		listeIle = new ArrayList<Ile>();
		this.repere = new int [200][200];
	}
	
	public ArrayList<Ile> getListeIle() {
		return listeIle;
	}
	
	public void addIle(Ile ile, int x, int y){
		listeIle.add(ile);
		
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
