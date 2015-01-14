package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.MockUnite;
import fr.iutinfo.unites.SurfeurCroMagnon;
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
			System.out.println(degats);
			System.out.println(this.pv);
			if(u.estMort()){
				System.out.println("		if degats :"+degats);
				effectifs.pop();
				degats=u.getPV() - degats;
				this.pv=u.getPV() - this.pv;
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

	public void attaquerIle(Ile ile){
		int valdef = ile.getValeurDefense();
		int forceIle = valdef;
		int forceArm = getForce();
		
		while(this.pv>0 && valdef>0){
			forceIle = ile.getValeurDefense();
			while(forceIle>0 && !this.effectifs.isEmpty()){
				Unite u = effectifs.peek();
				u.subitDegats(forceIle);
				if(u.estMort()){ // CAS OU L'UNITE EST TUEE
					System.out.println(u.getNom()+" est mort");
					effectifs.pop(); // ON RETIRE L'UNITE
					forceIle = forceIle - u.getPV(); 
					this.pv = this.pv - u.getPV();
				}else{ //PAS TUEE
					this.pv -= forceIle;
					forceIle=0;
				}
			}
			valdef-=forceArm;
		}
		System.out.println("Fin de la guerre");

	}

	//	public String attaquerIle(Ile ile){
	//		int valdef = ile.getValeurDefense();
	//		int forceArm = getForce();
	//		int tmp = 0;
	//		System.out.println("force = "+forceArm);
	//		System.out.println("valdef = "+valdef);
	//		System.out.println("effectifs"+effectifs);
	//		if (forceArm >= valdef){
	//			System.out.println(""+forceArm +" > "+valdef );
	//			if( effectifs.peek().getPV() < valdef){
	//				System.out.println("		"+effectifs.peek().getPV() +" < "+valdef);
	//				while(valdef < effectifs.peek().getPV()){
	//					System.out.println("			while  -> "+valdef+" < "+effectifs.peek().getPV());
	//					effectifs.peek().subitDegats( valdef) ;	
	//					valdef -= forceArm;	
	//					
	//					
	//				}
	//				
	//			}
	//			return "Armee gagne";
	//		}
	//		else{
	//			System.out.println(forceArm +" < "+valdef );
	//			for(int i = 0 ; i< 3 ;i++){
	//				System.out.println("	for --> "+i);
	//				
	//				valdef -= forceArm;
	//				this.subitDegats(valdef);
	//				System.out.println("		valdef : "+valdef);
	//				System.out.println(effectifs);
	//				
	//				//if( effectifs.peek().getPV() < valdef){
	//					//System.out.println("		if  "+effectifs.peek().getPV() + " < "+valdef);
	//					
	//					//
	//					//valdef -= forceArm;	
	//					/*while(valdef < effectifs.peek().getPV()){
	//						System.out.println("			while  -> "+valdef+" < "+effectifs.peek().getPV());
	//						
	//						
	//						
	//					}*/
	//				//}
	//				
	//				
	//				if(effectifs.isEmpty()){
	//					System.out.println("vide");
	//					return "Perdu";
	//				}
	//				if (valdef <= 0){
	//					System.out.println("valdef : "+ valdef);
	//					return "Armee gagne for";
	//				}
	//				
	//			}
	//			
	//		}
	//		return "Match null";
	//	}

	public static void main(String[] args) throws PlacementOccupeException {
		Armee a=new Armee();
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		a.addUnite(new MockUnite());
		Ile ile = new Ile(new Univers("fake"),"leon",1,1);
		ile.getEntrepot().setCoquillage(300);
		ile.upCococanon();
		a.attaquerIle(ile);
	}

}
