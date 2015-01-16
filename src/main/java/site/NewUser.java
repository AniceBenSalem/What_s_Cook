package site;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.iutinfo.Ile;

// pour les servlets
@WebServlet("servlet/NewUser")
public class NewUser extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		try{
			PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			out.println(html());
			
			if(req.getParameter("newLogin").equals("") || req.getParameter("newPassword").equals("") || req.getParameter("newPassword1").equals("") || req.getParameter("newMail").equals(""))
				res.sendRedirect("../NewUser.jsp");
			else{
			
				System.out.println("On est la");
				//Enregistrement du driver
				Class.forName("org.sqlite.JDBC");

				//Connexion a la base
				String url = "jdbc:sqlite:vinland.db";
				String nom = null;
				String mdp = null;
				Connection con = DriverManager.getConnection(url, nom, mdp);
				
				System.out.println("On est ici");
				//Instanciation de l'ile
				
				
				Ile ile = new Ile(null, req.getParameter("newLogin"));
				
				/*
				try {
					ile.ajouterABDD();
				}
				
				catch (Exception e) {
					System.out.println("PB ajout ile " + e.getMessage());
				}
				
				*/
				//execution de la requete
				Statement stmt = con.createStatement();
				System.out.println("New user : login =  " + req.getParameter("newLogin"));
				out.println("Compte cree :-)" + "bienvenue " +req.getParameter("newLogin"));
				String query = "Insert into users values('" + req.getParameter("newLogin") + "','" + req.getParameter("newPassword") + "','" + req.getParameter("newMail") + "','user'," + ile.getId() + ")";
				int update = stmt.executeUpdate(query);
							
				
				System.out.println("On est a cet endroit");
				HttpSession session = req.getSession();
				session.setAttribute("proprietaire",  req.getParameter("newLogin"));
				
				res.sendRedirect("../MonIleJsp.jsp");
				con.close();
			
			}
		}catch(Exception e){
			System.out.println("Probleme redirection ou requete");
				System.out.println(e.getMessage());
		}	
	}

	public String html() {
		return "<head>"
				+ "<meta charset=\"utf-8\" />"
				+ "<LINK rel=\"stylesheet\" href=\"../style.css\" type=\"text/css\">"
				+ "<link rel=\"icon\" type=\"image/png\" href=\"../IMG/favicon.png\" />"
				+ "<head><title>Nouvel utilisateur</title></head>" + "</head>"
				+ "<body>" +

				"</body>";
	}

}