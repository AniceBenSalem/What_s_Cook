package requetes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.iutinfo.InitBDD;



@Path("/event")

public class Evenement {
	InitBDD b;
	private static Requetes r ;

	@GET
	@Path("/getEvenement/")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEvent(/*@PathParam("nom") String nom,@PathParam("lieu") String lieu*/) throws SQLException, IOException {
		Base b = new Base();
		b.open();
		String retour =" { \"Event\" : [";
		ResultSet rs = b.executeQry("Select * from Event;");
	if(rs.next())
		retour+= "{\"Nom\" : \""+rs.getString("nom")+"\" ,\"date\" : \""+rs.getString("date")+"\" , \"Lieu\" : \""+rs.getString("ville")+ "\" ,\"Desc\" : \""+rs.getString("description")+"\"}";
	while(rs.next()){
		retour+= ",{\"Nom\" : \""+rs.getString("nom")+"\" ,\"date\" : \""+rs.getString("date")+"\" , \"Lieu\" : \""+rs.getString("ville")+ "\" ,\"Desc\" : \""+rs.getString("description")+"\"}";
	}
	return retour + "]}";
	
	
	}
	
	
	/*@POST*/ @GET
	@Path("/setEvenement/{nom}/{date}/{description}/{lieu}")
	@Produces(MediaType.APPLICATION_JSON)
	public String setEvent(@PathParam("nom")String nom,@PathParam("date")String date, @PathParam("description")String description, @PathParam("lieu") String ville) throws SQLException, IOException {
		b= new InitBDD();
		r = new Requetes();
		
		return r.insertEvent(nom, date, description, ville);
	}
	
	 @GET
		@Path("/modifEvent/{nom}/{lieu}")
		@Produces(MediaType.APPLICATION_JSON)
		public String modifEvent(@PathParam("nom")String nom,@PathParam("lieu") String ville) throws SQLException, IOException {
		 Base b = new Base();
			b.open();
			String retour =" { \"Event\" : [";
			ResultSet rs = b.executeQry("Select * from Event where nom ='"+nom+"' AND ville ='"+ville+"';");
		System.out.println("Select * from Event where nom ='"+nom+"' AND ville ='"+ville+"';");
			if(rs.next())
			retour+= "{\"Nom\" : \""+rs.getString("nom")+"\" ,\"date\" : \""+rs.getString("date")+"\" , \"Lieu\" : \""+rs.getString("ville")+ "\" ,\"Desc\" : \""+rs.getString("description")+"\"}";
		while(rs.next()){
			retour+= ",{\"Nom\" : \""+rs.getString("nom")+"\" ,\"date\" : \""+rs.getString("date")+"\" , \"Lieu\" : \""+rs.getString("ville")+ "\" ,\"Desc\" : \""+rs.getString("description")+"\"}";
		}
		return retour + "]}";
		}

}
