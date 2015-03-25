package requetes;


import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
		
@Path("/post")
public class Post {
	private static Requetes r;
			

	@GET
	@Path("/ajouterPostRecette/{login}/{message}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterPostRecette(@PathParam("login") String login, @PathParam("message") String message) throws SQLException, IOException {
		r = new Requetes();
		r.ajouterPost(login, message);
	}
	
	@GET
	@Path("/getPost")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPost() throws SQLException, IOException {
		r = new Requetes();
		return  r.getPost();
	}
}
