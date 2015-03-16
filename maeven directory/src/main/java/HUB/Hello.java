package HUB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cuisine.BDD;

@WebServlet(name = "testServlet", urlPatterns = { "/hello" }, initParams = { @WebInitParam(name = "simpleParam", value = "Salut") })
public class Hello extends HttpServlet {
	private static ArrayList<String> liste;
	private static BDD bdd ;	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String simpleParam = getServletConfig().getInitParameter("simpleParam");
		
		try {
			bdd = new BDD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String Cbon = bdd.executeRequete("Recettes","TxtRecette", "cassis").get(0);
		out.println("Hello World " + Cbon);
		out.close();
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
}