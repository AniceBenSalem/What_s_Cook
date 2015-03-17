package Resources;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Utils.Requetes;
import Utils.User;




@Path("/connexion")
@Produces(MediaType.APPLICATION_JSON)
public class ConnexionResource {
	
	@GET
	public boolean connexion(User user) {
		Requetes r = new Requetes();
		if(r.checkUser(user)) {
			return true;
		}
		return false;
	}
}
