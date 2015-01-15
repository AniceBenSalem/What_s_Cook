package site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

import fr.iutinfo.Armee;
import fr.iutinfo.Ile;
import fr.iutinfo.Univers;
import fr.iutinfo.batiments.Caserne;
import fr.iutinfo.batiments.CocoCanon;
import fr.iutinfo.batiments.Entrepot;
import fr.iutinfo.batiments.GenerateurCoquillage;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.GuerrierRequin;
import fr.iutinfo.unites.SurfeurCroMagnon;
import fr.iutinfo.unites.Unite;

public class ConnectionSQL {	
	Connection con = null;
	private int i = 0;
	public static Connection getCon () {
		
        try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Probleme dans le driver");
			e.printStackTrace();
		}			
        String url = "jdbc:sqlite:vinland.db";
        String name = null;
        String passwd = null;
        try {
			return DriverManager.getConnection(url, name, passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Probleme dans la co");
			e.printStackTrace();
		}
        return null;
	}
	
	public void addIle (Ile i) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		
		String query = "insert into ile (nomUnivers, proprietaire, dansUnClan) values (";
		query+= "'" + i.getUnivers().getNomUnivers() + "',";
		query += "'"+  i.getProprietaire() + "',";
		query+= "'false');";
		//query += addArmee(i.getArmee().getId()+");";

		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		con.close();
		System.out.println("OK maggle");
	}
	

	public static void addEntrepot2 (Entrepot e) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		
		String query = "insert into entrepot (coquillage, capacite, coutDeConstructionEntrepot, tempsDeConstructionEntrepot, nombre) values (";
		query+= e.getCoquillage() + ",";
		query += e.getCapacite() + ",";
		query+= e.getCoutdeConstruction() + ",";
		query+= e.getTempsConstruction() + ",";
		query+= e.getNombre() + ");";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		con.close();
	}
	
	public static void addCaserne(Caserne c) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		
		String query = "insert into caserne (coutDeConstructionCaserne, tempsDeConstructionCaserne, nombre) values (";
		query+= c.getCoutdeConstruction() + ",";
		query += c.getTempsConstruction() + ",";
		query+= c.getNombre() + ");";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		con.close();
	}
	
	public static void addCocoCanon (CocoCanon coco) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		String query = "insert into cococanon (pvCanon, coutDeConstructionCocoCanon, tempsDeConstructionCocoCanon, nombre) values (";
		query+= coco.getPv() + ",";
		query+= coco.getCoutdeConstruction() + ",";
		query += coco.getTempsConstruction() + ",";
		query+= coco.getNombre() + ");";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		con.close();
	}
	
	public static void addGenerateurCoquillage (GenerateurCoquillage genCoq) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		String query = "insert into generateurCoquillage (productionParMinute, nombre) values (";
		query+= genCoq.getProductionCoquillage() + ",";
		query+= genCoq.getNombre() + ");";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		con.close();
	}
	
	public static void setDansUnClan (Ile i, boolean b) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		String query = "update ile set dansUnClan='" + b + "'where id=" + i.getId() + ";";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		con.close();
	}
	
	public static Integer recupIDIle (Ile i) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		String query = "select id from ile where proprietaire = '" + i.getProprietaire() + "';";
		System.out.println("Query = " + query);
		ResultSet rs = stmt.executeQuery(query);
		String s = rs.getString("id");
		Integer a = Integer.parseInt(s);
		System.out.println("id ile= " + s);
		con.close();
		return a;
		
	}

	public void addEntrepot (Entrepot e) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		String query = "insert into entrepot(coquillage,capacite, nombre) values (";
		//query+= e.getId() + ",";
		query+= e.getCoquillage() + ",";
		query+= e.getCapacite() + ",";
		query += e.getNombre() + ");";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		con.close();
	}
	
	public Integer afficheCoquillage (Entrepot e) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		String query = "select coquillage from entrepot where id = " + e.getId() + ";";
		System.out.println("Query = " + query);
		ResultSet rs = stmt.executeQuery(query);
		String s = rs.getString("coquillage");
		Integer a = Integer.parseInt(s);
		System.out.println("Coquillage = " + s);
		con.close();
		return a;
		
		
	}
	
	public void idIlePourEntrepot (Entrepot e, Ile i) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		String query = "update entrepot set idIle='" + i.getId() + "'where id=" + e.getId() + ";";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		con.close();
		
	}
	
	/*
	public int addArmee(Armee armee) throws SQLException{
		Connection con = this.getCon();
		Statement stmt = con.createStatement();
		int nbSurfeurCroMagnon = 0;
		int nbRequinGuerrier = 0 ;
		Stack<Unite> pile = armee.getStack();
		
		while(!pile.isEmpty()){//incrementation des NB selon le type d'unité
			Unite u = pile.pop();
			if(u instanceof GuerrierRequin){
				nbRequinGuerrier++;
			}
			if(u instanceof SurfeurCroMagnon){
				nbSurfeurCroMagnon++;
			}
		}
		
		String query = "insert into armee (surfeurCroMagnon, requinGuerrier) values (";
		query+= " "+ nbSurfeurCroMagnon + ",";
		query += ""+  nbRequinGuerrier + "";
		query +=");";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		ResultSet rs = stmt.executeQuery("select max(id) from armee;");
		int id=0;
		if(rs.next()){
			id = Integer.parseInt(rs.getString("id"));
		}
		
		
		con.close();
		return id;
	}  
	*/
	
//	
//	public void addUnitee(Armee armee, Unite u) throws SQLException{
////		//int idIle = recupIDIle(armee.getIle());
////		Connection con = this.getCon();
//////		Statement stmt = con.createStatement();
//////		String query;
//////		query = "update armee set ";
//		if (u instanceof SurfeurCroMagnon){
//			//query += "nbSurfeurCroMagnon = nbSurfeurCroMagnon + 1";
//		}
//		if (u instanceof GuerrierRequin){
//			//query += "requinGuerrier = requinGuerrier + 1";
//		}
//		//query += " where idArmee = (select idArmee from ile where id = "+idIle;
//		//query +=" );";
////		System.out.println("Query hhhh= " + query);
//		//stmt.executeUpdate(query);
//		//ResultSet rs = stmt.executeQuery("select max(idArmee) from armee;");
//		//ResultSet aaa = stmt.executeQuery("PRAGMA table_info(armee);");
//		///System.out.println(aaa.toString());
//		
//		
//		//ResultSet rs = stmt.executeQuery("select * from armee;");
//		int id=0;
//		/*if(rs.next()){
//			id = Integer.parseInt(rs.getString("idArmee"));
//		}
//		*/
//		con.close();
//	} 
	
	
	public Integer recupIDEntrepot(Entrepot e, Ile i) throws SQLException {
		Connection con = ConnectionSQL.getCon();
		Statement stmt = con.createStatement();
		String query = "select id from entrepot where idIle = " + i.getId() + ";";
		System.out.println("Query = " + query);
		ResultSet rs = stmt.executeQuery(query);
		String s = rs.getString("id");
		Integer a = Integer.parseInt(s);
		System.out.println("Id entrepot = " + s);
		con.close();
		return a;
	}
	
	
	
	public static void main(String[] args) throws PlacementOccupeException, SQLException {
		Univers u = new Univers ("UniversTest");
		Ile i = new Ile (u,"ma");
		System.out.println("Id entrepot = " + i.getEntrepot().getId());
		System.out.println("Id caserne = " + i.getCaserne().getId());

	}
	
	
	
	/*
	public static void main(String[] args) throws SQLException {
		
		try{
            //Recorde driver
            Class.forName("org.sqlite.JDBC");			

            //Connection to the base
            String url = "jdbc:sqlite:vinland.db";
            String name = null;
            String passwd = null;
            try (Connection con = DriverManager.getConnection(url, name, passwd)) {
            	Statement stmt = con.createStatement();
                
                //String query = "insert into users values('troll', 'lolilol', 'prout@geugeul.fr', 152)";
                String query = "select * from ile";
                ResultSet rs  = stmt.executeQuery(query);
                
                while(rs.next()){
                	System.out.println(rs.getString(1) + " ," + rs.getString(2) + " ," + rs.getString(3) + " ," + rs.getString(4));
                }
                con.close();
            }catch(Exception e){
                System.out.println("Problem requete");
                System.out.println(e.getMessage());
            }
        }catch(ClassNotFoundException e){
            System.out.println("Problem connection");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            
        }
	}
	
	*/
	
	

}
