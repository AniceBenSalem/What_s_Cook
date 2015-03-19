package fr.iutinfo;



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



@Path("/cook")
public class servREST {
	private static ArrayList<String> liste;
	private static Requetes r ;


	@GET
	@Path("/getRecettes/{mesIngredients}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getRecettes(@PathParam("mesIngredients") String mesIngredients) throws SQLException {
		List<String> results = new ArrayList<String>();
		Base b = new Base();

		ResultSet r =b.executeQry("SELECT * FROM Recettes where TxtRecette like '%"+mesIngredients+"%';");
	
	   //ParamToString(mesIngredients);
		String Cbon ="";
		while (r.next()){
			Cbon+=r.getString("NumRecette")+"---"+r.getString("TitreRecette")+"---"+r.getString("TxtRecette")+"\n";
		}
		return "<result>"+Cbon+"</result>";
	}
	
	@GET
	@Path("/RecetteDuJour")
	@Produces(MediaType.TEXT_HTML)
	public String getRecettesDuJour() throws SQLException {
		r = new Requetes();
		return "<result>"+r.RecetteDuJour()+"</result>";
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
	@Produces(MediaType.TEXT_XML)
	public String getNbRecettes() throws SQLException {
		r = new Requetes();
		return "<?xml version=\"1.0\"?>" + "<result>" +r.nbRecettes() + "</result>";
	}

	@GET
	@Path("/getRecettesbyName/{name}/")
	@Produces(MediaType.TEXT_XML)
	public String getRecettesbyName(@PathParam("name") String name) throws SQLException {
		r= new Requetes();
		String hummm = r.executeRequete("Recettes","TitreRecette" , name).get(0);
		return "<?xml version=\"1.0\"?>" + "<result>" + hummm + "</result>";
	}
	
	@POST
	@Path("/liste/{string}")
	@Produces(MediaType.TEXT_XML)
	public String liste(@PathParam("string") String s) {
		liste.add(s);
		return "<?xml version=\"1.0\"?>" + "<result>" + liste.toString() + "</result>";
	}
	
	@GET
	@Path("/monFrigo/{idFrigo}/{idUser}")
	@Produces(MediaType.TEXT_XML)
	public String monFrigo(@PathParam("idFrigo") int idFrigo, @PathParam("idUser") int idUser) throws SQLException {
		String frigo = r.Frigo(idFrigo, idUser); 
		return "<?xml version=\"1.0\"?>" + "<result>" + frigo + "</result>";
	}
}
