package fr.iutinfo;

import java.sql.SQLException;
import java.util.Stack;

import site.ConnectionSQL;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.SurfeurCroMagnon;
import fr.iutinfo.unites.Unite;

public class Armee {

	private Stack<Unite> effectifs;
	private int force;
	private int pv;
	private int coutDeplacementGeneral;
	private Ile ile;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Armee(Ile i){
		this.ile=i;
		this.effectifs=new Stack<Unite>();
	}

	public Stack<Unite> getStack(){
		return this.effectifs;
	}
	
	public Ile getIle(){
		return this.ile;
	}
	
	public void addUnite(Unite u) throws SQLException{
		effectifs.push(u);
		force+=u.getForce();
		pv+=u.getPV();
		if(u.getCoutDeplacement() > coutDeplacementGeneral)
			coutDeplacementGeneral = u.getCoutDeplacement();
		new ConnectionSQL().addUnitee(this,u);
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
		}
		
		return valdef<0;
	}
	
	public void volRessource(Ile i){
		int taux = i.getPoints()/this.ile.getPoints()*100;
		
		if(taux>40)
			taux=40;
		if(taux<0)
			taux=0;
		
		int vol = i.getEntrepot().getCoquillage()*taux/100;
		
		i.getEntrepot().retirer("Coquillage",vol);
		this.ile.getEntrepot().ajouter("Coquillage",vol);
		
		
	}

}
