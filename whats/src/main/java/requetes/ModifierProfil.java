package requetes;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/modifierProfil")
@Produces(MediaType.APPLICATION_JSON)
public class ModifierProfil {
	
	@GET
	@Path("changePassword/{login}/{oldPassword}/{newPassword}")
	public String changePassword(@PathParam("login") String login, @PathParam("oldPassword") String oldPassword, @PathParam("newPassword") String newPassword) throws SQLException, IOException {
		Requetes r = new Requetes();
		if(r.checkUser(login,oldPassword) && r.changePassword(login,newPassword))
			return "{\"cp\": true}";
		return "{\"cp\": false}";
	}
	
	@GET
	@Path("consulterPost/{login}")
	public String consulterPost(@PathParam("login") String login) throws SQLException, IOException {
		Requetes r = new Requetes();
		if(r.checkLogin(login))
			return "{\"consP\": true}";
		return "{\"consP\": false}";
	}
	
	@GET
	@Path("consulterRecettes/{login}")
	public String consulterRecettes(@PathParam("login") String login) throws SQLException, IOException {
		Requetes r = new Requetes();
		if(r.checkLogin(login))
			return "{\"cr\": true}";
		return "{\"cr\": false}";
	}
	
	@DELETE
	@Path("supprimerCompte/{login}")
	public String supprimerCompte(@PathParam("login") String login) throws SQLException, IOException{
		Requetes r = new Requetes();
		if(r.checkLogin(login)){
			r.supprimerCompte(login);
			return "{\"sc\": true}";
		}
		return "{\"sc\": false}";
	}
}

