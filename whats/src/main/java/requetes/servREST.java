package requetes;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/cook")
public class servREST {
	private static ArrayList<String> liste;
	private static Requetes r ;
	
	/*@GET
	@Path("/getCommentaire")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCommentaire() throws SQLException, IOException {
		return new Requetes().afficheCommentaire();
	}*/

	@GET
	@Path("/getRecettes/{mesIngredients}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRecettes(@PathParam("mesIngredients") String mesIngredients) throws SQLException, IOException {
		return new Requetes().executeRequete("Recettes", "TxtRecette", mesIngredients);
	}
	
	@GET
	@Path("/getRecettesPourFavoris/{mesIngredients}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRecettesPourFavoris(@PathParam("mesIngredients") String mesIngredients) throws SQLException, IOException {
		return new Requetes().executeRequetePourFavoris("Recettes", "TxtRecette", mesIngredients);
	}
	
	@GET
	@Path("/getRecettesPourFavorisTitre/{mesIngredients}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRecettesPourFavorisTitre(@PathParam("mesIngredients") String mesIngredients) throws SQLException, IOException {
		return new Requetes().executeRequetePourFavorisTitre("Recettes", "TxtRecette", mesIngredients);
	}
	
	@GET
	@Path("/RecetteDuJour")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRecettesDuJour() throws SQLException, IOException {
		r = new Requetes();
		return  r.recetteDuJour();
	}
	
	@GET
	@Path("/monFrigo")
	@Produces(MediaType.APPLICATION_JSON)
	public String monFrigo() throws SQLException, IOException {
		r = new Requetes();
		return  r.monFrigo();
	}
		

	@GET
	@Path("/addRecettes/{name}/{nbPersonnes}/{ingredients}/{Temps}/{Descriptions}")
	@Produces(MediaType.TEXT_XML)
	public String addRecettes(@PathParam("name") String name, @PathParam("nbPersonnes") int nb,@PathParam("ingredients") String ingredients, @PathParam("Temps") String time, @PathParam("Description") String description ) throws SQLException, IOException {
		r = new Requetes();
		r.ajouterRecette(name, nb, time, ingredients, description);
		return "<?xml version=\"1.0\"?>" + "<result> succès de l'ajout </result>";
	}
	
	@GET
	@Path("/nbRecettes")
	@Produces(MediaType.TEXT_PLAIN)
	public int getNbRecettes() throws SQLException, IOException {
		r = new Requetes();
		return r.nbRecettes();
	}

	@GET
	@Path("/getRecettesbyName/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRecettesbyName(@PathParam("name") String name) throws SQLException, IOException {
		r= new Requetes();

		return r.executeRequeteTitre("Recettes","TitreRecette" , name);
	}
	
	
	
	@GET
	@Path("/getRecettesName/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getContenuRecette(@PathParam("name") String name) throws SQLException, IOException {
		r= new Requetes();
		return r.contenu(name);
	}
	
	@GET
	@Path("/recherche/{string}")
	@Produces(MediaType. APPLICATION_JSON)
	public String recherche(@PathParam("string") String iSearch) throws SQLException, IOException {
		r = new Requetes();
		return r.searchRecettes(iSearch);
	}
	
	@GET
	@Path("/ajouterFavoris/{login}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterFavoris(@PathParam("login") String login, @PathParam("id") String id) throws SQLException, IOException {
		r = new Requetes();
		r.ajouterFavoris(login, id);
	}
	
	@GET
	@Path("/getFavoris/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFavoris(@PathParam("login") String login) throws SQLException, IOException {
		r = new Requetes();
		return  r.getFavoris(login);
	}
	
	/*@GET
	@Path("/monFrigo/{idFrigo}/{idUser}")
	@Produces(MediaType.TEXT_XML)
	public String monFrigo(@PathParam("idFrigo") int idFrigo, @PathParam("idUser") int idUser) throws SQLException {
		String frigo = r.frigo(idFrigo, idUser); 
		return "<?xml version=\"1.0\"?>" + "<result>" + frigo + "</result>";
	}*/
	

}
