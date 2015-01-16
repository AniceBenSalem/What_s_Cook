package fr.iutinfo.batiments;

import java.sql.SQLException;
import java.util.Calendar;

import fr.iutinfo.Ile;



/**This class allow to create a building*/
public abstract class Batiment {

protected int id,nombre, coutdeConstruction, tempsConstruction; 	
	protected Calendar lancement,fin;
	Ile i;

	public boolean enConstruction(){
		System.out.println("En construction");
		return !Calendar.getInstance().after(fin);	
	}
	
	public boolean estDispo(){
		return Calendar.getInstance().after(fin);	
	}
	
	public void lanceConstruction() throws SQLException{
		this.lancement= Calendar.getInstance();
		this.fin=(Calendar) lancement.clone();
		this.fin.add(Calendar.SECOND,tempsConstruction);
		this.up();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	


	public int getCoutDeConstruction() {
		return coutdeConstruction;
	}
	public void setCoutDeConstruction(int coutdeConstruction) {
		this.coutdeConstruction = coutdeConstruction;
	}
	public int getCoutdeConstruction() {
		return coutdeConstruction;
	}
	public void setCoutdeConstruction(int coutdeConstruction) {
		this.coutdeConstruction = coutdeConstruction;
	}
	public int getTempsConstruction() { //en minute
		return tempsConstruction;
	}
	public void setTempsConstruction(int tempsConstruction) { // en minute
		this.tempsConstruction = tempsConstruction;
	}
	
	public int getNombre() {
		return this.nombre;
	}
	
	public Ile getIle(){
		return this.i;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}	

	public Batiment(){
		this.nombre=0;
		this.id ++;
	}
	
	public abstract String getNom();
	public abstract  void up() throws SQLException;

	
}


