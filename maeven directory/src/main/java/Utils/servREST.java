package Utils;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.iutinfo.Requetes;
import fr.iutinfo.SQLiteConnectionData;

@Path("/cook")
public class servREST {
	private static ArrayList<String> liste;
	private static SQLiteConnection c ;
	private static Requetes r;


	/*public ArrayList<String> ParamToString(String chaine){
	 ArrayList<String> ingredients = new ArrayList<String>();
		    for(int i =0; i< chaine.length() ; i++){
		        String recup="";
		        if(chaine.charAt(i)== '-'){
	            ingredients.add(recup);	        
		        recup = "";
		        }else{
		        recup+=chaine.charAt(i);
		        }
		    }
		    return ingredients;
	}*/
	
	@GET
	@Path("/getRecettes/{mesIngredients}")
	@Produces(MediaType.TEXT_XML)
	public String getRecettes(@PathParam("mesIngredients") String mesIngredients) throws SQLException {
		List<String> results = new ArrayList<String>();
	   //ParamToString(mesIngredients);
		c=new SQLiteConnectionData();
		r=new Requetes();
		
		String Cbon ="";
		for(int i =0;i<results.size(); i++){
			Cbon+= r.executeRequete("Recettes","TxtRecette", mesIngredients).get(i)+"\n";
		}
		return "<?xml version=\"1.0\"?>" + "<result>"+Cbon+"</result>";
	}

	@GET
	@Path("/addRecettes/{name}/{nbPersonnes}/{ingredients}/{Temps}/{Descriptions}")
	@Produces(MediaType.TEXT_XML)
	public String addRecettes(@PathParam("name") String name, @PathParam("nbPersonnes") int nb,@PathParam("ingredients") String ingredients, @PathParam("Temps") String time, @PathParam("Description") String description ) throws SQLException {
		r.ajouterRecette(name, nb, time, ingredients, description);
		return "succès de l'ajout";
	}

	@GET
	@Path("/getRecettesbyName/{name}/")
	@Produces(MediaType.TEXT_XML)
	public String getRecettesbyName(@PathParam("name") String name) throws SQLException {
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
