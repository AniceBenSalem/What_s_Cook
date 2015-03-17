package cuisine;
import java.util.ArrayList;
import java.util.Date;


public class Frigo {
	private ArrayList<Ingredient> stock;

	public Frigo(){
		stock = new ArrayList<Ingredient>();

	}
	
	
public void add(Ingredient x){
	stock.add(x);
}

public ArrayList<Ingredient> bientotPerime(){
	ArrayList<Ingredient> aConsomer = new ArrayList<Ingredient>();
	Ingredient current;	
	for(int i=0; i<this.stock.size();i++){
		current= stock.get(i);
		if(current.bientotPerime()){
					aConsomer.add(stock.get(i));
				}
		}
	return aConsomer;
}

public String toString(){
	String monFrigo="";
	Ingredient current;		
	for (int i = 0; i < stock.size(); i++) {
		current = stock.get(i);		
		monFrigo += current.getNom()+": qte "+current.getQuantite()+" Date de peremption: "+current.getPeremption()+"\n";
	}
	
	return monFrigo;
}
public void nettoyerFrigo(){
	for(int i=0; i<stock.size();i++){
		if(stock.get(i).estPerime()){
			stock.remove(i);
		}
	}
}

public Ingredient prendre(String name){
	for(int i=0; i<stock.size();i++){
		Ingredient current = stock.get(i);
		if(current.getNom().equals(name)){
			return current;
		}
	}
	return null;
}


public ArrayList<Ingredient> getFrigo() {
	return stock;
}


public void setFrigo(ArrayList<Ingredient> stock) {
	this.stock = stock;
}



}

