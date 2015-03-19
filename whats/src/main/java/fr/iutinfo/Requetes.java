package fr.iutinfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Requetes {

	public Base b;
	public ResultSet rs = null;
	
	public Requetes() throws SQLException {
		b =new Base();
		
		b.open();
	}
	
	public ArrayList<String> executeRequete(String table,String colonne,String requete){
		ArrayList<String> list = new ArrayList<String>();
		try {
			rs = b.executeQry("SELECT * FROM "+table+" where "+colonne+" like '%"+this.Requete(requete)+"%';");
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
		}
		System.out.println(list.get(0));
		return list;
	}
	
	public ArrayList<String> executeRequete(String table,String colonne,ArrayList<String> requete){
		ArrayList<String> list = new ArrayList<String>();
		try {
			rs = b.executeQry("SELECT * FROM "+table+" where "+colonne+" like '%"+this.Requete(requete)+"%';");
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

	public void ajouterRecette(String name, int nb,String Temps, String ingredients, String description) throws SQLException{
		int idRecettes = this.nbRecettes()+1;
		String insert="";
		if(idRecettes >0){
		insert ="insert into Recettes (NumRecette, TitreRecette, NbPersonne ,Temps ,Ingredients , TxtRecette) " +
				"values("+idRecettes+",'"+name+"' ,"+nb+" ,'"+Temps+"' ,'"+ingredients+"' ,'"+description+"');";
		}
		try{
		
		b.executeStmt(insert);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public int nbRecettes() throws SQLException{
		int ret =-1; 
		rs =b.executeQry("select count(*) from Recettes");
		
		if(rs.next()){
			ret =rs.getInt(1);
		}
		return ret;
	}

	public String frigo(int idFrigo, int idUser) throws SQLException{
		String retour ="Huuuumm J'ai tout ça de bon: \n";
		rs = b.executeQry("select ingredients from Frigo where idFrigo ="+idFrigo+" AND idUser="+idUser+";");
		while(rs.next()){
			retour+= rs.getString(1)+"\n";
		}
		return retour;
	}
	public String searchRecettes(String s) throws SQLException{
		
		/*int jeChercheUnInt = Integer.parseInt(s);*/
		String retour ="";
		System.out.println("select * from Recettes where TitreRecette like '%"+s+"%'" +
				" OR NbPersonneTxt like '%"+s+"%' OR Temps like '%"+s+"%'" +
						" OR Ingredients like '%"+s+"%'+ OR TxtRecette like '%"+s+"%';");
		
		rs = b.executeQry("select * from Recettes where TitreRecette like '%"+s+"%'" +
				" OR NbPersonneTxt like '%"+s+"%' OR Temps like '%"+s+"%'" +
						" OR Ingredients like '%"+s+"%' OR TxtRecette like '%"+s+"%';");
		
		
		while(rs.next()){
			retour+= rs.getString("NumRecette")+"---"+rs.getString("TitreRecette")+"---"+rs.getString("TxtRecette")+"\n";
		}
		return retour;
		
		/*
		 * NumRecette` INTEGER NOT NULL DEFAULT 0, 
  `TitreRecette` VARCHAR(255), 
  `NbPersonne` INTEGER DEFAULT 0, 
  `NbPersonneTxt` VARCHAR(255), 
  `Temps` VARCHAR(255), 
  `Ingredients` LONGTEXT, 
  `TxtRecette` LONGTEXT, 
  PRIMARY KEY (`NumRecette`)

		 * 
		 */
	}
	
/*	public void insertUser(User u) {
		try {
			statement = c.createStatement();
			statement.executeUpdate("INSERT INTO test(login, password) VALUES('"+u.getLogin()+"','"+u.getPassword()+"';");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkUser(User u) {
		System.out.println("fqskdmfl");
		try {
			statement = c.createStatement();
			rs = statement.executeQuery("select * from test where login='"+u.getLogin()+"' and password='"+u.getPassword()+"';");
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				statement.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return false;
	}
	
	public static void main(String[] args) throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("rhubarbe");
		list.add("cassis");
		new Requetes().executeRequete("Recettes", "TxtRecette","cassis");
	}*/
}
