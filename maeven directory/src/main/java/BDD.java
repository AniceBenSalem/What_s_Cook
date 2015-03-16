import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BDD {
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	
	public BDD () throws SQLException{
		this.connexion();
	}
	
	public void connexion() throws SQLException{
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		connection = DriverManager.getConnection("jdbc:sqlite:bdd");
		statement = connection.createStatement();
		statement.setQueryTimeout(30);
		
	}
	
	public void deconnexion (){
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e2) {
			// connection close failed.
			System.err.println(e2);
		}
	}
	
	public ArrayList<String> executeRequete(String table,String colonne,String requete){
		ArrayList<String> list = new ArrayList<String>();
		try {
			rs = statement.executeQuery("SELECT * FROM "+table+" where "+colonne+" like '%"+this.Requete(requete)+"%';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				list.add(rs.getString("NumRecette")+"---"+rs.getString("TitreRecette")+"---"+rs.getString("TxtRecette"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.deconnexion();
		}
		System.out.println(list.get(0));
		return list;
	}
	
	public ArrayList<String> executeRequete(String table,String colonne,ArrayList<String> requete){
		ArrayList<String> list = new ArrayList<String>();
		try {
			rs = statement.executeQuery("SELECT * FROM "+table+" where "+colonne+" like '%"+this.Requete(requete)+"%';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				list.add(rs.getString("NumRecette")+"---"+rs.getString("TitreRecette")+"---"+rs.getString("TxtRecette"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.deconnexion();
		}
		return list;
	}
	
	public String Requete(ArrayList<String> list){
		String g = "";
		
		for(int i =0 ; i< list.size();i++){
			g += list.get(i);
			if( i != list.size()-1){
				g += "%' OR TxtRecette LIKE '";
			}		
		}
		
		return g;
	}

	public String Requete(String s) {
		boolean suite = false;
		String g = "";

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ' ' && i != s.length() - 1 && i > 2 && suite && (s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z')) {
				g += "%' OR TxtRecette LIKE '";
				suite = false;
			} else if (s.charAt(i) != ' ') {
				g += s.charAt(i);
				suite = true;
			}

		}
		if (s.length() != 0) {
			g += "%";
		}
		return g;
	}
	
	public static void main(String[] args) throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("rhubarbe");
		list.add("cassis");
		new BDD().executeRequete("Recettes", "TxtRecette", "cassis");
	}
}
