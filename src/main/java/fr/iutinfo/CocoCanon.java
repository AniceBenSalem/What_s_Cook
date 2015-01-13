package fr.iutinfo;

public class CocoCanon extends BatimentDefensif{

	public CocoCanon(Ile ile) {
		super("CocoCanon", 10, 10, 400, 400, 400, 40,ile); 
		this.level = 0;
		this.name = "CocoCanon";
		ile.addBatiment(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void amelioration() {
		// TODO Auto-generated method stub
		
	}
	

		
}
