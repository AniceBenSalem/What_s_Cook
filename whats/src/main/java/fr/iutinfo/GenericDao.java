package fr.iutinfo;



import java.util.Date;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import requetes.User;

public interface GenericDao {



	@SqlUpdate("CREATE TABLE if NOT EXISTS User (mail TEXT, login TEXT, password TEXT, constraint loginUser_pk PRIMARY KEY(login));")
	void createUser();
	/*table fausse ? il n'y a q'une recette par evenement ?*/
	@SqlUpdate("CREATE TABLE if NOT EXISTS Event (id INT AUTO_INCREMENT, nom TEXT, date DATE, description TEXT, ville TEXT, constraint idEvent_pk PRIMARY KEY(nom,ville));")
	void createEvent();

	@SqlUpdate("CREATE TABLE if NOT EXISTS Participant (id INT, login TEXT, recette TEXT, constraint fk_idPartic FOREIGN KEY (id) REFERENCES Event(id) ON UPDATE CASCADE, constraint fk_loginPart FOREIGN KEY (login) REFERENCES User(login) ON UPDATE CASCADE, constraint pk_Participant PRIMARY KEY(id,login));")
	void createParticipant();

/*
	@SqlUpdate("CREATE TABLE CreeRecette(login TEXT, nomRecette TEXT,ingredient TEXT, methode TEXT, temps INT, constraint fk_loginCree FOREIGN KEY(login) REFERENCES User(login) ON UPDATE CASCADE, constraint fk_nomRecette FOREIGN KEY nomRecette REFERENCES (nomRecette) ON UPDATE CASCADE, constraint pk_CreeRecette PRIMARY KEY(mail, nomRecette));")
	void createRecette();
	
	@SqlUpdate("CREATE TABLE RealRecette(login TEXT, nomRecette TEXT, temps INT, constraint fk_loginReal FOREIGN KEY(login) REFERENCES User(login) ON UPDATE CASCADE, constraint fk_nomRecette FOREIGN KEY nomRecette REFERENCES (nomRecette) ON UPDATE CASCADE, constraint pk_CreeRecette PRIMARY KEY(mail, nomRecette));")
	void realRecette();
	
	@SqlUpdate("CREATE TABLE PossIngred(login TEXT, nomI TEXT, quantite INT, dlc DATE, constraint fk_loginPoss FOREIGN KEY(login) REFERENCES User(login) ON UPDATE CASCADE, constraint fk_nomI FOREIGN KEY (nomI) REFERENCES(nomI) ON UPDATE CASCADE, constraint pk_PossIngred PRIMARY KEY (mail, nomI));")
	void possIngred();
	
	@SqlUpdate(CREATE TABLE ContientRec(id INT, nomR TEXT, constraint fk_idCont FOREIGN KEY(id) REFERENCES Event(id), constraint fk_nomR FOREIGN KEY Recette(nomR) ON UPDATE CASCADE, constraint pk_ContientRec PRIMARY KEY (id,nomR));")
	void contientRec();
	
	@SqlUpdate(CREATE TABLE ContientIngred(nomR TEXT, nomI TEXT, quantite INT, constraint fk_nomR FOREIGN KEY Recette(nomR) ON UPDATE CASCADE, constraint fk_idCont FOREIGN KEY(nomI) REFERENCES Event(nomI) ON UPDATE CASCADE, constraint pk_ContientRec PRIMARY KEY (nomR, nomI));")
	void ContientIngred();

*/

	@SqlUpdate("insert into User (mail, login, password) values (:mail, :login, :password)")
	@GetGeneratedKeys
	int insertUser(@Bind("mail") String mail, @Bind("login") String login, @Bind("password") String password);

	@SqlUpdate("insert into Event (nom, date, description, ville) values (:nom, :date, :description, :ville)")
	@GetGeneratedKeys
	int insertEvent(@Bind("nom") String nom,@Bind("date") String date, @Bind("description") String description, @Bind("ville") String ville);

	@SqlUpdate("insert into Participant (id, login, recette) values (:id, :login, :recette)")
	@GetGeneratedKeys
	int insertParticipant(@Bind("id") int id,@Bind("login") String login, @Bind("recette") String recette);

/*
	@SqlUpdate("insert into CreeRecette (login, nomRecette, ingredient, methode, temps) values (:login, :nomRecette, :ingredient, :methode, :temps)")
	@GetGeneratedKeys
	Integer insertCreeRecette(@Bind("login") String login,@Bind("nomRecette") String nomRecette, @Bind("ingredient") String ingredient, @Bind("methode") String methode, @Bind("temps") int temps;

	@SqlUpdate("insert into RealRecette (login, nomRecette, temps) values (:login, :nomRecette, :temps)")
	@GetGeneratedKeys
	Integer insertRealRecette(@Bind("login") String login,@Bind("nomRecette") String nomRecette, @Bind("temps") Integer temps;

	@SqlUpdate("insert into PossIngred (login, nomI, quantite, dlc) values (:login, :nomI, :quantite, :dlc)")
	@GetGeneratedKeys
	Integer insertPossIngred(@Bind("login") String login,@Bind("nomI") String nomI, @Bind("quantite") Integer quantite, @Bind("dlc") Date dlc;

	@SqlUpdate("insert into ContientRec (id, nomR) values (:id, :nomR)")
	@GetGeneratedKeys
	Integer insertContientRec(@Bind("id") Integer id, @Bind("nomR") String nomR;

	@SqlUpdate("insert into ContientIngred (nomR, nomI, quantite) values (:nomR, :nomI, :quantite)")
	@GetGeneratedKeys
	Integer insertContientIngred(@Bind("nomR") String nomR,@Bind("nomI") String nomI, @Bind("quantite") Integer quantite;
*/
	@SqlQuery("select * from User where login = :login and password = :password")
	@RegisterMapperFactory(BeanMapperFactory.class)
	String verifUser(@Bind("login") String login, @Bind("password") String password);

	@SqlQuery("select * from Event where nom like '%:nom%' OR ville like '%:lieu%' ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	String verifEvent(@Bind("nom") String nom, @Bind("lieu") String lieu);
	
	/*@SqlQuery("select * from :table")
	@RegisterMapperFactory(BeanMapperFactory.class)
	String verifAllEvent(@Bind("table") String table);
	*/
	@SqlQuery("select * from Participant where id=:id and login = :login and date = :date")
	@RegisterMapperFactory(BeanMapperFactory.class)
	String verifPartic(@Bind("id") int id, @Bind("login") String login, @Bind("date") Date date);

/*
	@SqlQuery("select * from CreeRecette where nomRecette = :nomRectte")
	@RegisterMapperFactory(BeanMapperFactory.class)
	UserData verifCreeRecette(@Bind("nomRecette") String nomRecette);
	
	@SqlQuery("select * from RealRecette where login = :login and nomRecette = :nomRecette")
	@RegisterMapperFactory(BeanMapperFactory.class)
	UserData verifCreeRecette(@Bind("login") String login, @Bind("nomRecette") String nomRecette);

	@SqlQuery("select * from RealRecette where login = :login and nomI = :nomI and quantite >=1")
	@RegisterMapperFactory(BeanMapperFactory.class)
	UserData verifCreeRecette(@Bind("login") String login, @Bind("nomI") String nomI, @Bind("quantite") Integer quantite);

	@SqlQuery("select * from ContientRec where id = :id and nomR = :nomR")
	@RegisterMapperFactory(BeanMapperFactory.class)
	UserData verifCreeRecette(@Bind("id") Integer id, @Bind("nomR") String nomR);

	@SqlQuery("select * from ContientIngred where nomR = :nomR and nomI = :nomI and quantite >=1")
	@RegisterMapperFactory(BeanMapperFactory.class)
	UserData verifCreeRecette(@Bind("nomR") String nomR, @Bind("nomI") String nomI, @Bind("quantite") Integer quantite);

*/

	
	void close();
}
