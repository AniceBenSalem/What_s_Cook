package HUB;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import jersey.repackaged.org.objectweb.asm.Handle;

import org.glassfish.jersey.filter.LoggingFilter;
import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

@ApplicationPath("/v1/")
public class App extends Application {
	public static DBI dbi;
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(UserResource.class);
		s.add(LoggingFilter.class);
		s.add(UserDBResource.class);
		return s;
	}
	
	
	public void CreationTables() throws IOException, URISyntaxException{
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:bdd");
		dbi = new DBI(ds);
		org.skife.jdbi.v2.Handle h = dbi.open();
		
		
		File fichier = new File("dump.sql");
		System.out.println("fichier existe ? "+fichier.exists());
		
		
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		new App().CreationTables();
		
	}
}