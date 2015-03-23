package fr.iutinfo;


import java.util.Date;

import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

public class InitBDD {

	public static DBI dbi;
	public static GenericDao dao;

	public InitBDD() {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:"+/* + System.getProperty("java.io.tmpdir")
				+ System.getProperty("file.separator") + */"bdd");
		dbi = new DBI(ds);
		dao = dbi.open(GenericDao.class);
	/*	dao.createEvent();
		dao.createUser();
		dao.createParticipant();*/
	}
	public void setParticipant(int id, String login,String ingredient){
		dao.insertParticipant(id, login, ingredient);
	}
	public void setEvenement(String nom,String date, String login, String lieu){
		dao.insertEvent(nom, date, login, lieu);
	}
	public void setUser(String mail, String login, String password){
		dao.insertUser(mail, login, password);
	
	}
	
	/*public String getEvenement(String nom/* String lieu){
		System.out.println(dao.verifAllEvent(nom));
		return dao.verifAllEvent(nom);/*verifEvent(nom, lieu);
	}*/
	public String getParticipant(int id, String login, Date date){
		return dao.verifPartic(id, login,date);
		
	}
	public String getUser(String login, String password){
		return dao.verifUser(login, password);
	
	}

	private static InitBDD instance = null;

	public static InitBDD getInstance() {
		if (instance == null) {
			instance = new InitBDD();
		}
		return instance;
	}
}