package requetes;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class Requetes {

	public Base b;
	public ResultSet rs = null;
	
	public Requetes() throws SQLException, IOException {
		b =new Base();
		
		b.open();
	}
	

	public String executeRequete(String table,String colonne,String requete){
		String JSON = "{\"Recettes\" :[";
		try {
			rs = b.executeQry("SELECT * FROM "+table+" where "+colonne+" like '%"+this.requete(requete)+"%';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if(rs.next()){
				JSON +="{"+"\"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
			}
			while (rs.next()) {
				JSON +=",{"+"\"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.close();
		return JSON +"]}";
	}
	
	public String executeRequeteTitre(String table,String colonne,String requete){
		String JSON = "{\"Recettes\" :[";
		try {
			rs = b.executeQry("SELECT * FROM "+table+" where "+colonne+" like '"+this.requete(requete)+" %';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if(rs.next()){
				JSON +="{"+"\"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
			}
			while (rs.next()) {
				JSON +=",{"+"\"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.close();
		return JSON +"]}";
	}
	
	public String executeRequete(String table,String colonne,ArrayList<String> requete){
		String JSON = "{\"Recettes\" :[";
		try {
			rs = b.executeQry("SELECT * FROM "+table+" where "+colonne+" like '%"+this.requete(requete)+"%';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if(rs.next()){
				JSON +="{"+"\"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
			}
			while (rs.next()) {
				JSON +=",{"+"\"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.close();
		return JSON +"]}";
	}
	
	public String requete(ArrayList<String> list){
		String g = "";
		
		for(int i =0 ; i< list.size();i++){
			g += list.get(i);
			if( i != list.size()-1){
				g += "%' AND TxtRecette LIKE '%";
			}		
		}
		
		return g;
	}

	public String requete(String s) {
		boolean suite = false;
		String g = "";

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ' ' && i != s.length() - 1 && i > 2 && suite && (s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z')) {
				g += "%' AND TxtRecette LIKE '% ";
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
	
	public String recetteDuJour() throws SQLException {
		int tmp =0;
		rs = b.executeQry("SELECT * FROM RecetteDuJour ;");
		if(rs.next()){
			tmp = Integer.parseInt(rs.getString("date"));
			if ( tmp == new Date().getDate()){
				rs = b.executeQry("SELECT * FROM Recettes where NumRecette = "+rs.getString("id")+";");
				if(rs.next()){
					b.close();
					return "{"+"\"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
				}
			}
			else{
				rs = b.executeQry("SELECT * FROM Recettes where NumRecette = "+new Random().nextInt(this.nbRecettes())+";");
				String id = rs.getString("NumRecette");
				int date = new Date().getDate();
				b.executeStmt("UPDATE RecetteDuJour SET id = "+Integer.parseInt(id)+" , date = "+date+";");
				return recetteDuJour();
			}
		}
		b.close();
		return "PAS DE RECETTE AUJOURD HUI";
	}
	
	/*public void ajouterCommentaire(String login, String message, Date date) throws SQLException{
		int idCommentaire = this.nbCommentaires()+1;
		String insert="";
		if(idCommentaire >0){
		insert ="insert into Post (idPost, login, message, date) " +
				"values("+idCommentaire+",'"+login+"' ,"+message+" ,'"+date+"');";
		}
		try{
		
		b.executeStmt(insert);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}*/

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
		b.close();
	}
	
	/*public int nbCommentaires() throws SQLException{
		int com =-1; 
		rs =b.executeQry("select count(*) from Post");
		
		if(rs.next()){
			com =rs.getInt(1);
		}
		return com;
	}*/
	
	public int nbRecettes() throws SQLException{
		int ret =-1; 
		rs =b.executeQry("select count(*) from Recettes");
		
		if(rs.next()){
			ret =rs.getInt(1);
		}
		b.close();
		return ret;
	}

	/*public String frigo(int idFrigo, int idUser) throws SQLException{
		String retour ="Huuuumm J'ai tout ça de bon: \n";
		rs = b.executeQry("select ingredients from Frigo where idFrigo ="+idFrigo+" AND idUser="+idUser+";");
		while(rs.next()){
			retour+= rs.getString(1)+"\n";
		}
		return retour;
	}*/
	
	public String monFrigo() throws SQLException {
		String JSON = "{\"Ingredients\" :[";
		rs = b.executeQry("select Libelle from Abreviations;");
		
		if(rs.next());
		JSON +="{ \"Libelle\" : \""+rs.getString("Libelle")+"\"}";
		while (rs.next()) {
			JSON +=",{ \"Libelle\" : \""+rs.getString("Libelle")+"\"}";
		}
		b.close();
		return JSON +"]}";
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
			retour+= /*rs.getString("NumRecette")+"---"+*/rs.getString("TitreRecette")+"---"/*rs.getString("TxtRecette")+"\n"*/;
		}
		b.close();
		return retour;
		
	}
	
	public void insertUser(User u) {
		try {
			b.executeStmt("INSERT INTO User VALUES('"+u.getMail()+"','"+u.getLogin()+"','"+u.getPassword()+"');");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		b.close();
	}
	
	public boolean checkLogin(String l) {
		try {
			rs = b.executeQry("select * from User where login='"+l+"';");
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		b.close();
		return false;
	}
	
	public boolean checkPassword(String p) {
		try {
			rs = b.executeQry("select * from User where password='"+p+"';");
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		b.close();
		return false;
	}
	
	public boolean checkUser(String l, String p) {
		try {
			rs = b.executeQry("select * from User where login='"+l+"' and password='"+p+"';");
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		b.close();
		return false;
	}
	
	public boolean changePassword(String login, String newPassword) {
		try {
			b.executeStmt("UPDATE User SET password = '"+newPassword+"' WHERE login = '"+login+"';");
			b.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			b.close();
			return false;
			
		}
		
	}
	
	public boolean supprimerCompte(String login) {
		try {
			b.executeStmt("DELETE FROM User WHERE login = '"+login+"';");
			b.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			b.close();
			return false;
			
		}
	}
	
	public String insertEvent(String nom, String date, String description, String ville  ) throws SQLException {
		int nb;
		ResultSet rs = b.executeQry("select count(*) from Event");
		nb = rs.getInt(1)+1;
		String succes="{\"Succes\" :[";
		String tmp="";
		try {
			b.executeStmt("INSERT INTO Event(id, nom ,date ,description ,ville ) VALUES("+nb+",'"+nom+"','"+date+"','"+description+"','"+ville+"');");
			tmp=" Creer avec succès!! faites en de meme pour cet evenement";
		} catch (Exception e) {
			tmp="petit probleme veuillez contacter l'admin ou patienter que le probleme soit resolu \n merci à vous pour votre patience et dosolé pour la gêne occasionée";
			e.printStackTrace();
			System.exit(0);
			
		} 
		
		succes += "{"+"\"Succes\" : \""+tmp+"\"}]}";
		System.out.println(succes);
		b.close();
		return succes;
	}
	
	public void ajouterPost(String login, String message) {
		
		try {
			b.executeStmt("insert into Post(login,message) values('"+login+"','"+message+"');");
			b.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void ajouterFavoris(String login, String id) {
		try {
			b.executeStmt("insert into Favoris(login,idRecette) values('"+login+"',"+id+");");
			b.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/*public String getPost() {
		String JSON = "{\"Post\" :[";
		try {
		
			rs = b.executeQry("select login,message from Post;");
		
			if(rs.next());
			JSON +="{ \"message\" : \""+rs.getString("message")+"\"}";
			while (rs.next()) {
				JSON +=",{ \"message\" : \""+rs.getString("message")+"\"}";
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return JSON +"]}";
	}*/
	
	public String getPost() throws SQLException {
		String JSON = "{\"Post\" :[";
		rs = b.executeQry("select * from Post;");
		
		if(rs.next()) {
			JSON +="{ \"message\" : \""+rs.getString("message")+"\" , \"login\" : \""+rs.getString("login")+"\"}";
			while (rs.next()) {
				JSON +=",{ \"message\" : \""+rs.getString("message")+"\" , \"login\" : \""+rs.getString("login")+"\"}";
			}
		}
		b.close();
		return JSON +"]}";
	}
	
	public String getFavoris(String login) throws SQLException {
		String JSON = "{\"Favoris\" :[";
		rs = b.executeQry("select titreRecette,TxtRecette from Favoris as f,Recettes as r where f.idRecette = r.NumRecette AND login='"+login+"';");
		
		
		if(rs.next()) {
			JSON +="{ \"titre\" : \""+rs.getString("titreRecette")+"\" , \"recette\" : \""+rs.getString("Txtrecette")+"\"}";
			while (rs.next()) {
				JSON +=",{ \"titre\" : \""+rs.getString("titreRecette")+"\" , \"recette\" : \""+rs.getString("Txtrecette")+"\"}";
			}
		}
		b.close();
		return JSON +"]}";
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("rhubarbe");
		list.add("cassis");
		new Requetes().executeRequete("Recettes", "TxtRecette","cassis");
	}

	public String contenu(String titre) {
		String JSON = "";
		try {
			rs = b.executeQry("SELECT TxtRecette FROM Recettes where TitreRecette = \""+titre+"\";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			if(rs.next()){
				JSON += rs.getString("TxtRecette");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.close();
		return JSON ;
	}

	public String executeRequetePourFavoris(String table, String colonne,String requete) {
			String JSON = "{\"Recettes\" :[";
			try {
				rs = b.executeQry("SELECT * FROM "+table+" where "+colonne+" like '%"+this.requete(requete)+"%';");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if(rs.next()){
					JSON +="{"+"\"idRecette\" : \""+rs.getString("NumRecette")+"\" , \"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
				}
				while (rs.next()) {
					JSON +=",{"+"\"idRecette\" : \""+rs.getString("NumRecette")+"\" , \"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.close();
			return JSON +"]}";
	}


	public String executeRequetePourFavorisTitre(String table, String colonne,String requete) {
		String JSON = "{\"Recettes\" :[";
		try {
			rs = b.executeQry("SELECT * FROM "+table+" where "+colonne+" like '"+this.requete(requete)+" %';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if(rs.next()){
				JSON +="{"+"\"idRecette\" : \""+rs.getString("NumRecette")+"\"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
			}
			while (rs.next()) {
				JSON +=",{"+"\"idRecette\" : \""+rs.getString("NumRecette")+"\"TitreRecette\" : \""+rs.getString("TitreRecette")+"\" , \"TxtRecette\" : \""+rs.getString("TxtRecette")+"\"}";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.close();
		return JSON +"]}";
	}


}
