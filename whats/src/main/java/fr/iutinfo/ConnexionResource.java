package fr.iutinfo;



import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/connexion")
public class ConnexionResource {
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public String verifUser(@PathParam("login") String login, @PathParam("password") String password) throws SQLException{
		Base m = new Base();
		ResultSet r = m.executeQry("Select * from test where login = '"+ login+"' and password = '"+password+"';");
		if (r.next())
			return "<?xml version=\"1.0\"?><result>ok</result>";
				
		return "<?xml version=\"1.0\"?><result>pas ok</result>";
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
