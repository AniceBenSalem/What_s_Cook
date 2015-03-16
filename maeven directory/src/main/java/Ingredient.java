
import java.util.GregorianCalendar;


public class Ingredient {
private String nom;
private int quantite;
private GregorianCalendar peremption; 

public Ingredient(String nom,int quantite, GregorianCalendar limite){
	this.nom = nom;
	this.quantite=quantite;
	peremption = limite;
	
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public int getQuantite() {
	return quantite;
}

public void setQuantite(int quantite) {
	this.quantite = quantite;
}

public GregorianCalendar getPeremption() {
	return peremption;
}

public void setPeremption(GregorianCalendar peremption) {
	this.peremption = peremption;
	
}
public boolean estPerime(){
	GregorianCalendar today = new GregorianCalendar();
	if(this.peremption.YEAR==today.YEAR && peremption.MONTH == today.MONTH){
		if(peremption.DAY_OF_MONTH>= peremption.DAY_OF_MONTH ){
			return true;
		}
	}
	return false;
}

public boolean bientotPerime(){
	GregorianCalendar today = new GregorianCalendar();
	if(this.peremption.YEAR==today.YEAR && peremption.MONTH == today.MONTH){
		if(peremption.DAY_OF_MONTH - peremption.DAY_OF_MONTH <=5 && peremption.DAY_OF_MONTH - peremption.DAY_OF_MONTH >0 ){
			return true;
		}
	}
	return false;
}
public static void main(String[] args) {
	System.out.println();
}


}
