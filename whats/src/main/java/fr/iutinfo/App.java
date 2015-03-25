package fr.iutinfo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.filter.LoggingFilter;

import requetes.ConnexionResource;
import requetes.Evenement;
import requetes.InscriptionResource;
//import requetes.Mail;
import requetes.Post;
import requetes.User;
import requetes.servREST;

@ApplicationPath("/v1/")
public class App extends Application {

	@Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> s = new HashSet<Class<?>>();

    	s.add(LoggingFilter.class);
    	s.add(servREST.class);
    	s.add(User.class);
    	//s.add(Mail.class);
    	s.add(Evenement.class);
    	s.add(ConnexionResource.class);
    	s.add(InscriptionResource.class);
    	s.add(Post.class);
    	return s;
    }
  /*  
    public static DBI dbi;
	static {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:bdd"/*+System.getProperty("java.io.tmpdir")+System.getProperty("file.separator")+"data.db");
		dbi = new DBI(ds);
    }*/
}
