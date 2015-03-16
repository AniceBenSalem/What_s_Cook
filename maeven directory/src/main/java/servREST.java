

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
	private static BDD bdd ;


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
	   //ParamToString(mesIngredients);
		bdd.connexion();
		String Cbon = bdd.executeRequete("Recettes","TxtRecette", mesIngredients).get(0);
		return "<?xml version=\"1.0\"?>" + "<result>"+Cbon+"</result>";
	}

	@GET
	@Path("/addx/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	public String addXML(@PathParam("a") double a, @PathParam("b") double b) {
		return "<?xml version=\"1.0\"?>" + "<result>" + (a + b) + "</result>";
	}

	@GET
	@Path("/subx/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	public String subXML(@PathParam("a") double a, @PathParam("b") double b) {
		return "<?xml version=\"1.0\"?>" + "<result>" + (a - b) + "</result>";
	}
	
	@POST
	@Path("/liste/{string}")
	@Produces(MediaType.TEXT_XML)
	public String liste(@PathParam("string") String s) {
		liste.add(s);
		return "<?xml version=\"1.0\"?>" + "<result>" + liste.toString() + "</result>";
	}
	
	@GET
	@Path("/liste")
	@Produces(MediaType.TEXT_XML)
	public String liste1() {
		return "<?xml version=\"1.0\"?>" + "<result>" + liste.toString() + "</result>";
	}
}
