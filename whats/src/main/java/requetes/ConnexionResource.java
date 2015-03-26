package requetes;





import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/connexion")

public class ConnexionResource {
	
	@GET
	@Path("/{login}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public String connexion(@PathParam("login") String login, @PathParam("password") String password) throws SQLException, IOException {
		Requetes r = new Requetes();
		if(r.checkUser(login,password))
			return "{\"boulet1\": true}";
		return "{\"boulet1\": false}";
	}

@GET
@Path("/android/{login}/{password}")
@Produces(MediaType.TEXT_PLAIN)
public String connexionA(@PathParam("login") String login, @PathParam("password") String password) throws SQLException, IOException {
	Requetes r = new Requetes();
	if(r.checkUser(login,password))
		return "yes";
	return "no";
}
}
