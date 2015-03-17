package Resources;



import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Utils.User;
import Utils.Requetes;

@Path("/inscription")
@Produces(MediaType.APPLICATION_JSON)
public class InscriptionResource {
	
	@POST
	public void register(User user) {
		Requetes r = new Requetes();
		r.insertUser(user);
	}
}
