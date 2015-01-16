package site;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/Authent")

public class Authent extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try{
			//Creation de la session
			HttpSession session = req.getSession( true );
			session.setAttribute("identificateur",req.getParameter("login"));
			session.setMaxInactiveInterval(10*60*60);

			//Enregistrement du driver
			Class.forName("org.sqlite.JDBC");			

			//Connexion a la base
			String url = "jdbc:sqlite:vinland.db";
			String name = null;
			String passwd = null;
			try (Connection con = ConnectionSQL.getCon()) {
				//execution de la requete
				Statement stmt = con.createStatement();
				String query = "select * from users Where login = '" + req.getParameter("login") + "' AND password = '" + req.getParameter("password") + "'";
				ResultSet rs = stmt.executeQuery(query);
				PrintWriter out = res.getWriter();
				res.setContentType("text/html");
				
				
				out.println("<head><link rel=\"icon\" type=\"image/png\" href=\"../IMG/favicon.png\" /><title>Authentification</title></head>"); //Iconne
				out.println("<body><a href='../MonIleJsp.jsp'>Mon ile</a></body>");
				if(rs.next()){
					session.setAttribute("role",rs.getString("role"));
					
					
					/*On se connecte et on envoie les parametres dans la session pour la JSP*/
					String login = req.getParameter("login");
					System.out.println("Authent, login user = " + login) ;
					session.setAttribute("login", login);
					
					
					/*On est authentifie on va sur la jsp MonIleJsp.jsp*/
					if(session.getAttribute("url") != null)
						res.sendRedirect((String) session.getAttribute("url"));
					else
						//res.sendRedirect("Menu");    //A modifier
						res.sendRedirect("../MonIleJsp.jsp"); // test Amaury : authentifie donc MonIleJsp.jsp
				}else{
					res.sendRedirect("../index.html");
					//session.setAttribute("idTrue",rs.getString("false"));
				}
				//fermeture des espaces
				con.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}catch(Exception e){
			System.out.println("Probème : " + e.getMessage());
		}
	}

}
