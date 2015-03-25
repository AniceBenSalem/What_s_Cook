package requetes;


import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
		
@Path("/post")
public class Post {
	private static Requetes r;
			

	@POST
	@Path("/ajouterPostRecette/{login}/{message}/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterPostRecette(@PathParam("login") String login, @PathParam("message") String message, @PathParam("date") String date) throws SQLException, IOException {
		r = new Requetes();
		r.ajouterPostRecette(login, message, date);
	}

}
