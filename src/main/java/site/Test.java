package site;

import java.sql.*;

public class Test {

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
                String query = "select * from users";
                System.out.println(query);
                //ResultSet rs = stmt.executeQuery(query);
                ResultSet rs  = stmt.executeQuery(query);
                
                while(rs.next()){
                    System.out.println("coucou");
                }
                con.close();
            }catch(Exception e){
                System.out.println("Problem requete");
            }
        }catch(ClassNotFoundException e){
            System.out.println("Problem connection");
        }
	}
}
