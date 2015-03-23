package requetes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.iutinfo.InitBDD;



@Path("/event")

public class Evenement {
	InitBDD b;

	@GET
	@Path("/getEvenement/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEvent(@PathParam("id") int id) throws SQLException {
		b= new InitBDD();
		return b.getEvenement(id);
	}
	
	
	/*@POST*/ @GET
	@Path("/setEvenement/{nom}/{date}/{login}")
	@Produces(MediaType.TEXT_PLAIN)
	public String setEvent(@PathParam("nom")String nom,@PathParam("date")String date, @PathParam("login")String login) throws SQLException {
		b= new InitBDD();
		b.setEvenement(nom, date, login, "panama");
		return "ok";
	}
	
	

}
