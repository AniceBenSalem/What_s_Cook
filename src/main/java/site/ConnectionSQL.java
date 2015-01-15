package site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.iutinfo.Armee;
import fr.iutinfo.Ile;
import fr.iutinfo.Univers;
import fr.iutinfo.batiments.Caserne;
import fr.iutinfo.batiments.CocoCanon;
import fr.iutinfo.batiments.Entrepot;
import fr.iutinfo.exceptions.PlacementOccupeException;

public class ConnectionSQL {	
	Connection con = null;
	
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
		
		String query = "insert into ile (nomUnivers, proprietaire, dansUnClan, x,y) values (";
		query+= "'" + i.getUnivers().getNomUnivers() + "',";
		query += "'"+  i.getProprietaire() + "',";
		query+= "'false',";
		query+= i.getX() + ",";
		query+= i.getY() + ");";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
		con.close();
		System.out.println("OK maggle");
	}
	
	public static void addEntrepot (Entrepot e) throws SQLException {
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
		System.out.println("s = " + s);
		con.close();
		return a;
		
	}
	
	
	public static void main(String[] args) throws PlacementOccupeException, SQLException {
		Univers u = new Univers ("UniversTest");
		Ile i = new Ile (u,"ma", 42,42);
		ConnectionSQL c = new ConnectionSQL();
		ConnectionSQL.setDansUnClan(i, true);
		
	 
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
