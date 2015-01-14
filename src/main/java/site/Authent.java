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
			try (Connection con = DriverManager.getConnection(url, name, passwd)) {
System.out.println("coucou1");
				//execution de la requete
				Statement stmt = con.createStatement();
				String query = "select * from users Where login = '" + req.getParameter("login") + "' AND password = '" + req.getParameter("password") + "'";
				ResultSet rs = stmt.executeQuery(query);
System.out.println("coucou2");
				PrintWriter out = res.getWriter();
				res.setContentType("text/html");
				out.println("<head><link rel=\"icon\" type=\"image/png\" href=\"../IMG/favicon.png\" /><title>Authentification</title></head>"); //Iconne
System.out.println("coucou3");
				if(rs.next()){
					session.setAttribute("role",rs.getString("role"));
					if(session.getAttribute("url") != null)
						res.sendRedirect((String) session.getAttribute("url"));
					else
						res.sendRedirect("Menu");    //A modifier
				}else{
					res.sendRedirect("../index.html");
					//session.setAttribute("idTrue",rs.getString("false"));
				}
System.out.println("coucou4");
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
