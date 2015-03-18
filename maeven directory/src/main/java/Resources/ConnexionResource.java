package Resources;



import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Utils.Base;




@Path("/connexion")
@Produces(MediaType.APPLICATION_JSON)
public class ConnexionResource {
	@GET
	@Path("/{login}/{password}")
	public boolean verifUser(@PathParam("login") String login, @PathParam("password") String password) throws SQLException{
		Base m = new Base();
		m.open();
		ResultSet r = m.executeQry("Select login,password from User where login = '"+ login+"' and password = '"+password+"';");
		if (r != null)
			return r.next();
		m.close();
		
		return false;
	}
	
/*	@GET
	public boolean connexion(User user) {
		Requetes r = new Requetes();
		if(r.checkUser(user)) {
			return true;
		}
		return false;
	}*/
}
