package requetes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	private static Requetes r ;
	private static String nomModif="", lieuModif="";
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
		public String afficheMonEvent(@PathParam("nom")String nom,@PathParam("lieu") String ville) throws SQLException, IOException {
		 Base b = new Base();
			b.open();
		
			String retour =" { \"Event\" : [";
			ResultSet rs = b.executeQry("Select * from Event where nom ='"+nom+"' AND ville ='"+ville+"';");
	
			if(rs.next())
			retour+= "{\"Nom\" : \""+rs.getString("nom")+"\" ,\"date\" : \""+rs.getString("date")+"\" , \"Lieu\" : \""+rs.getString("ville")+ "\" ,\"Desc\" : \""+rs.getString("description")+"\"}";
		while(rs.next()){
			retour+= ",{\"Nom\" : \""+rs.getString("nom")+"\" ,\"date\" : \""+rs.getString("date")+"\" , \"Lieu\" : \""+rs.getString("ville")+ "\" ,\"Desc\" : \""+rs.getString("description")+"\"}";
		}
		nomModif = nom;
		 lieuModif = ville;
		
		return retour + "]}";
		}
	 

	 @POST
		@Path("/modifier/{newdesc}/{date}/{ville}/{nom}")
		@Produces(MediaType.APPLICATION_JSON)
		public void modifEvent(@PathParam("newdesc") String newdesc, @PathParam("date") String date, @PathParam("ville") String ville, @PathParam("nom") String nom) throws SQLException, IOException {
		 Base b = new Base();
			b.open();
			String requete = "Update Event set ";
			boolean in =false;
			
			if(newdesc.length() > 0){
				requete+="description ='"+newdesc+"' ";
				in = true;
			}
			if(date.length() > 0){

				if(in){ 
					requete+=", ";
					in = false;
				}
				requete+="date ='"+date+"' ";
				
			}
			if(ville.length() > 0){
				in =true;
				if(in){ 
					requete+=", ";
					in = false;
				}
				requete+="ville ='"+ville+"' ";
				in = false;
			}
			if(nom.length() > 0){
				in = true;
				if(in){ 
					requete+=", ";
					in = false;
				}
				requete+="nom ='"+nom+"' ";
				
			}
			requete+= "where nom ='"+nomModif+"' AND ville ='"+lieuModif+"';" ;


			System.out.println(requete);
		  b.executeStmt(requete);
			
		}

	 @GET
		@Path("/suppEvent/{nom}/{lieu}")
		@Produces(MediaType.APPLICATION_JSON)
		public void supprimerUnEvent(@PathParam("nom")String nom,@PathParam("lieu") String ville) throws SQLException, IOException {
		 Base b = new Base();
		 b.open();
		 String requete = "Delete from Event where nom ='"+nom+"' and ville ='"+ville+"';";
		 b.executeStmt(requete);
		 System.out.println(requete);
		 
	 }
		 @GET
			@Path("/ParticipEvent/{Nom}/{Lieu}/{login}")
			@Produces(MediaType.APPLICATION_JSON)
			public void AjouterParticipant(@PathParam("Nom")String nom,@PathParam("Lieu") String ville, @PathParam("login") String login) throws SQLException, IOException {
			 Base b = new Base();
			 b.open();
			 System.out.println("Select id from Event where nom ='"+nom+"' AND ville ='"+ville+"';");
			 ResultSet rs = b.executeQry("Select id from Event where nom ='"+nom+"' AND ville ='"+ville+"';");
			 String id = rs.getString("id");
			 System.out.println(id);
			 
			 String requete = "Insert into Participant (id, login) values ("+id+",'"+login+"');" ;
			 b.executeStmt(requete);
			 System.out.println(requete);
	 }

}
