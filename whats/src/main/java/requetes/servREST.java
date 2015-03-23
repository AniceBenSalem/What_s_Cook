package requetes;



import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/cook")
public class servREST {
	private static ArrayList<String> liste;
	private static Requetes r ;


	@GET
	@Path("/getRecettes/{mesIngredients}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRecettes(@PathParam("mesIngredients") String mesIngredients) throws SQLException {
		return new Requetes().executeRequete("Recettes", "TxtRecette", mesIngredients);
	}
	
	@GET
	@Path("/RecetteDuJour")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRecettesDuJour() throws SQLException {
		r = new Requetes();
		return  r.recetteDuJour();
	}
	
	@GET
	@Path("/monFrigo")
	@Produces(MediaType.APPLICATION_JSON)
	public String monFrigo() throws SQLException {
		r = new Requetes();
		return  r.monFrigo();
	}
		

	@GET
	@Path("/addRecettes/{name}/{nbPersonnes}/{ingredients}/{Temps}/{Descriptions}")
	@Produces(MediaType.TEXT_XML)
	public String addRecettes(@PathParam("name") String name, @PathParam("nbPersonnes") int nb,@PathParam("ingredients") String ingredients, @PathParam("Temps") String time, @PathParam("Description") String description ) throws SQLException {
		r = new Requetes();
		r.ajouterRecette(name, nb, time, ingredients, description);
		return "<?xml version=\"1.0\"?>" + "<result> succès de l'ajout </result>";
	}
	@GET
	@Path("/nbRecettes")
	@Produces(MediaType.TEXT_PLAIN)
	public int getNbRecettes() throws SQLException {
		r = new Requetes();
		return r.nbRecettes();
	}

	@GET
	@Path("/getRecettesbyName/{name}/")
	@Produces(MediaType.TEXT_XML)
	public String getRecettesbyName(@PathParam("name") String name) throws SQLException {
		r= new Requetes();
		String hummm = r.executeRequete("Recettes","TitreRecette" , name);
		return "<?xml version=\"1.0\"?>" + "<result>" + hummm + "</result>";
	}
	
	@GET
	@Path("/recherche/{string}")
	@Produces(MediaType.TEXT_XML)
	public String recherche(@PathParam("string") String iSearch) throws SQLException {
		r = new Requetes();
		return "<?xml version=\"1.0\"?>" + "<result>" + r.searchRecettes(iSearch) + "</result>";
	}
	
	/*@GET
	@Path("/monFrigo/{idFrigo}/{idUser}")
	@Produces(MediaType.TEXT_XML)
	public String monFrigo(@PathParam("idFrigo") int idFrigo, @PathParam("idUser") int idUser) throws SQLException {
		String frigo = r.frigo(idFrigo, idUser); 
		return "<?xml version=\"1.0\"?>" + "<result>" + frigo + "</result>";
	}*/
	

}
