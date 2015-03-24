package requetes;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inscription")
@Produces(MediaType.APPLICATION_JSON)
public class InscriptionResource {
	@POST
	@Path("/{mail}/{login}/{password}")
	public String inscription(@PathParam("mail") String mail, @PathParam("login") String login, @PathParam("password") String password) throws SQLException, IOException{
		Requetes r = new Requetes();
		User u = new User(mail, login,password);
		if(!(r.checkLogin(login))){
			r.insertUser(u);
			return "{\"bouletbill\": \"true\"}";
		}
		return "{\"bouletbill\": \"false\"}";
	}
}
