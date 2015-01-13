package fr.iutinfo;

import java.util.ArrayList;
import java.util.Stack;

import fr.iutinfo.unites.Unite;

public class Armee {

	private Stack<Unite> effectifs;
	private int force;
	private int pv;
	
	public Armee(){
		this.effectifs=new Stack<Unite>();
	}
	
	public Stack<Unite> getStack(){
		return this.effectifs;
	}
	public void addUnite(Unite u){
		effectifs.push(u);
		force+=u.getForce();
		pv+=u.getPV();
	}
	public void subitDegats(int degats){
		while(degats>0 && this.pv >=0 && !effectifs.isEmpty()){
			Unite u = effectifs.peek();
			u.subitDegats(degats);
			if(u.estMort()){
				
				effectifs.pop();
				degats-=u.getPV();
				this.pv-=u.getPV();
				System.out.println(u.getNom()+" est mort !");
			}else{
				this.pv-=degats;
				degats=0;
			}
		}
	}
	
	public int getForce(){
		return force;
	}
	
	public int getPV(){
		return pv;
	}
}
