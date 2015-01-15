package site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.iutinfo.Ile;
import fr.iutinfo.Univers;
import fr.iutinfo.exceptions.PlacementOccupeException;

public class ConnectionSQL {	
	Connection con = null;
	
	public Connection getCon () {
		
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
		Connection con = this.getCon();
		Statement stmt = con.createStatement();
		
		String query = "insert into ile (nomUnivers, proprietaire, dansUnClan, x,y) values (";
		query+= "'" + i.getUnivers().getNomUnivers() + "',";
		query += "'"+  i.getProprietaire() + "',";
		query+= "'false',";
		query+= i.getX() + ",";
		query+= i.getY() + ");";
		System.out.println("Query = " + query);
		stmt.executeUpdate(query);
	}
	
	public static void main(String[] args) throws PlacementOccupeException, SQLException {
		Univers u = new Univers ("UniversTest");
		Ile i = new Ile (u,"maBiteDeKeBla", 42,42);
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