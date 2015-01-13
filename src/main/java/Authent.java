package site;

import java.io.*;
import javax.servlet.*; // pour les servlets
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
@WebServlet("/servlet/Authent")

public class Authent extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("coucou");
		try{
			//Creation de la session
			HttpSession session = req.getSession( true );
			session.setAttribute("identificateur",req.getParameter("login"));
			session.setMaxInactiveInterval(6*60);
				
			//Enregistrement du driver
			Class.forName("org.sqlite.JDBC");			

			//Connexion a la base
			String url = "jdbc:sqlite:vinland.db";
			String nom = null;
			String mdp = null;
			try (Connection con = DriverManager.getConnection(url, nom, mdp)) {
			
				//execution de la requete
				Statement stmt = con.createStatement();
				String query = "select * from users Where login = '" + req.getParameter("login") + "' AND password = '" + req.getParameter("password") + "'";
				ResultSet rs = stmt.executeQuery(query);
	
				PrintWriter out = res.getWriter();
				res.setContentType("text/html");
				out.println("<head><link rel=\"icon\" type=\"image/png\" href=\"../IMG/favicon.png\" /><title>Authentification</title></head>");
				
				if(rs.next()){
					session.setAttribute("role",rs.getString("role"));
					if(session.getAttribute("url") != null)
						res.sendRedirect((String) session.getAttribute("url"));
					else
						res.sendRedirect("Menu");
				}else
					System.out.println("coucou");
					res.sendRedirect("../login.html");
				
				//fermeture des espaces
				con.close();
			}catch(Exception e){
                System.out.println("Problem requete");
                System.out.println(e.getMessage());
            }
		}catch(Exception e){
			System.out.println("Probème : " + e.getMessage());
		}
	}
	
}
