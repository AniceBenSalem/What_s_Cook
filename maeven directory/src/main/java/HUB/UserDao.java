package HUB;

import java.sql.Date;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {


	@SqlUpdate("CREATE TABLE User(mail TEXT, login TEXT, password TEXT, constraint loginUser_pk PRIMARY KEY(login));")
	void createUser();

	@SqlUpdate("CREATE TABLE Event(id INT AUTOINCREMENT, nom TEXT, date DATE, login TEXT, passwordEv TEXT, recette TEXT, constraint idEvent_pk PRIMARY KEY(ID));")
	void createEvent();

	@SqlUpdate("CREATE TABLE Participant(id INT, login TEXT, ingredient TEXT, constraint fk_idPartic FOREIGN KEY (id) REFERENCES Event(id) ON UPDATE CASCADE, constraint fk_loginPart FOREIGN KEY (login) REFERENCES User(login) ON UPDATE CASCADE, constraint pk_Participant PRIMARY KEY(id,login));")
	void createParticipant();

/*
	@SqlUpdate("CREATE TABLE CreeRecette(login TEXT, nomRecette TEXT,ingredient TEXT, methode TEXT, temps INT, constraint fk_loginCree FOREIGN KEY(login) REFERENCES User(login) ON UPDATE CASCADE, constraint fk_nomRecette FOREIGN KEY nomRecette REFERENCES (nomRecette) ON UPDATE CASCADE, constraint pk_CreeRecette PRIMARY KEY(mail, nomRecette));")

	@SqlUpdate("CREATE TABLE RealRecette(login TEXT, nomRecette TEXT, temps INT, constraint fk_loginReal FOREIGN KEY(login) REFERENCES User(login) ON UPDATE CASCADE, constraint fk_nomRecette FOREIGN KEY nomRecette REFERENCES (nomRecette) ON UPDATE CASCADE, constraint pk_CreeRecette PRIMARY KEY(mail, nomRecette));")

	@SqlUpdate("CREATE TABLE PossIngred(login TEXT, nomI TEXT, quantite INT, dlc DATE, constraint fk_loginPoss FOREIGN KEY(login) REFERENCES User(login) ON UPDATE CASCADE, constraint fk_nomI FOREIGN KEY (nomI) REFERENCES(nomI) ON UPDATE CASCADE, constraint pk_PossIngred PRIMARY KEY (mail, nomI));")

	@SqlUpdate(CREATE TABLE ContientRec(id INT, nomR TEXT, constraint fk_idCont FOREIGN KEY(id) REFERENCES Event(id), constraint fk_nomR FOREIGN KEY Recette(nomR) ON UPDATE CASCADE, constraint pk_ContientRec PRIMARY KEY (id,nomR));")

	@SqlUpdate(CREATE TABLE ContientIngred(nomR TEXT, nomI TEXT, quantite INT, constraint fk_nomR FOREIGN KEY Recette(nomR) ON UPDATE CASCADE, constraint fk_idCont FOREIGN KEY(nomI) REFERENCES Event(nomI) ON UPDATE CASCADE, constraint pk_ContientRec PRIMARY KEY (nomR, nomI));")
*/

	@SqlUpdate("insert into User (mail, login, password) values (:mail, :login, :password)")
	@GetGeneratedKeys
	int insertUser(@Bind("mail") String mail, @Bind("login") String login, @Bind("password") String password);

/*	@SqlUpdate("insert into Event (nom, date, login, passwordEv, recette) values (:nom, :date, :login, :passwordEv, :recette)")
	@GetGeneratedKeys
	int insertUser(@Bind("nom") String nom,@Bind("date") Date date, @Bind("login") String login, @Bind("passwordEv") String passwordEv, @Bind("recette") String recette);

	@SqlUpdate("insert into Participant (id, login, ingredient) values (:id, :login, :ingredient)")
	@GetGeneratedKeys
	int insertUser(@Bind("id") int id,@Bind("login") String login, @Bind("ingredient") String ingredient);
*/
/*
	@SqlUpdate("insert into CreeRecette (login, nomRecette, ingredient, methode, temps) values (:login, :nomRecette, :ingredient, :methode, :temps)")
	@GetGeneratedKeys
	int insertUser(@Bind("login") String login,@Bind("nomRecette") String nomRecette, @Bind("ingredient") String ingredient, @Bind("methode") String methode, @Bind("temps") int temps;

	@SqlUpdate("insert into RealRecette (login, nomRecette, temps) values (:login, :nomRecette, :temps)")
	@GetGeneratedKeys
	int insertUser(@Bind("login") String login,@Bind("nomRecette") String nomRecette, @Bind("temps") int temps;

	@SqlUpdate("insert into PossIngred (login, nomI, quantite, dlc) values (:login, :nomI, :quantite, :dlc)")
	@GetGeneratedKeys
	int insertUser(@Bind("login") String login,@Bind("nomI") String nomI, @Bind("quantite") int quantite, @Bind("dlc") Date dlc;

	@SqlUpdate("insert into ContientRec (id, nomR) values (:id, :nomR)")
	@GetGeneratedKeys
	int insertUser(@Bind("id") int id, @Bind("nomR") String nomR;

	@SqlUpdate("insert into RealRecette (nomR, nomI, quantite) values (:nomR, :nomI, :quantite)")
	@GetGeneratedKeys
	int insertUser(@Bind("nomR") String nomR,@Bind("nomI") String nomI, @Bind("quantite") int quantite;
*/
	@SqlQuery("select * from User where login = :login and password = :password")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User verifUser(@Bind("login") String login, @Bind("password") String password);

	@SqlQuery("select * from Event where nom = :nom and date = :date")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User verifEvent(@Bind("nom") String nom, @Bind("date") Date date);

	@SqlQuery("select * from Participant where id=:id and login = :login and date = :date")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User verifPartic(@Bind("id") String id, @Bind("login") String login, @Bind("date") Date date);

/*
	@SqlQuery("select * from CreeRecette where login = :login")
	@RegisterMapperFactory(BeanMapperFactory.class)
	UserData verifCreeRecette(@Bind("login") String login);






*/}