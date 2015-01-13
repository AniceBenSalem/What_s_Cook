package fr.iutinfo;

import java.util.Stack;

import fr.iutinfo.unites.Unite;

public class Armee {

	private Stack<Unite> effectifs;
	private int force;
	private int pv;
	private int coutDeplacementGeneral;
	
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
		if(u.getCoutDeplacement() > coutDeplacementGeneral)
			coutDeplacementGeneral = u.getCoutDeplacement();
		
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

	public int getCoutDeplacementGeneral() {
		return coutDeplacementGeneral;
	}

	public void setCoutDeplacementGeneral(int coutDeplacementGeneral) {
		this.coutDeplacementGeneral = coutDeplacementGeneral;
	}
	
	
	
	public String attaquerIle(Ile ile){
		int valdef = ile.getValeurDefense();
		int forceArm = getForce();
		int tmp = 0;
		
		if (forceArm > valdef){
			if( effectifs.peek().getPV() < valdef){
				while(valdef < effectifs.peek().getPV()){
					valdef -= effectifs.pop().getPV();					
				}
			}
			return "Armee gagne";
		}
		else{
			for(int i = 0 ; i< 3 ;i++){
				valdef -= forceArm;
				if( effectifs.peek().getPV() < valdef){
					while(valdef < effectifs.peek().getPV()){
						valdef -= effectifs.pop().getPV();					
					}
				}
				if(effectifs.isEmpty()){
					return "Perdu";
				}
				
			}
			
		}
		return "match null";
	}
}
