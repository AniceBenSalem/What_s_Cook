package fr.iutinfo;

import java.util.Stack;

import fr.iutinfo.exceptions.PlacementOccupeException;

import fr.iutinfo.unites.SurfeurCroMagnon;
import fr.iutinfo.unites.Unite;

public class Armee {
	
	private Ile ile;
	
	private Stack<Unite> effectifs;
	private int force;
	private int pv;
	private int coutDeplacementGeneral;

	public Armee(Ile i){
		ile = i;
		this.force=0;
		this.pv=0;
		this.effectifs=new Stack<Unite>();
	}

	public Stack<Unite> getStack(){
		return this.effectifs;
	}
	public void addUnite(Unite u){
		effectifs.push(u);
		force+=u.getForce();
		pv+=u.getPV();
		if(u.getCoutDeplacement() > coutDeplacementGeneral)
			coutDeplacementGeneral = u.getCoutDeplacement();

	}

	public int getForce(){
		return force;
	}

	public int getPV(){
		return pv;
	}

	public int getCoutDeplacementGeneral() {
		return coutDeplacementGeneral;
	}

	public void volerRessources(Ile i){
		int taux = this.ile.getPoints()-i.getPoints(); // A FAIRE
	}
	
	public void setCoutDeplacementGeneral(int coutDeplacementGeneral) {
		this.coutDeplacementGeneral = coutDeplacementGeneral;
	}
	/*
	 * Envoie l'armée attaque une ile. Si c'est une victoire : return true, false si c'est une défaite 
	 * 
	 */
	public boolean attaquerIle(Ile ile){
		int valdef = ile.getValeurDefense();
		int forceIle = valdef;
		int forceArm = getForce();
		
		while(this.pv>0 && valdef>0){
			forceIle = ile.getValeurDefense();
			while(forceIle>0 && !this.effectifs.isEmpty()){
				
				Unite u = effectifs.peek();
				int tmp = u.getPV();
				u.subitDegats(forceIle);
				
				if(u.estMort()){ // CAS OU L'UNITE EST TUEE
					
					effectifs.pop(); // ON RETIRE L'UNITE
					forceIle = forceIle - tmp; 
					this.pv = this.pv - tmp;
					
				}else{ //PAS TUEE
					
					this.pv -= forceIle;
					forceIle=0;
				}
				
			}
			
			valdef-=forceArm;
			System.out.println(valdef);
		}
		
		return valdef<0;
	}

}
