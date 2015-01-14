package site;

import java.io.*;
import javax.servlet.*; // pour les servlets
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
@WebServlet("/servlet/NewUser")

public class NewUser extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try{
			PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			out.println(html());
			
			if(req.getParameter("newLogin").equals("") || req.getParameter("newPassword").equals("") || req.getParameter("newPassword1").equals("") || req.getParameter("newMail").equals("") || req.getParameter("newAge").equals(""))
				res.sendRedirect("../NewUser.jsp");
			else{
				if(!req.getParameter("newPassword").equals(req.getParameter("newPassword1")))
					res.sendRedirect("../NewUser.jsp");
				
				//Enregistrement du driver
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");			

				//Connexion a la base
				String url = "jdbc:odbc:Personne";
				String nom = null;
				String mdp = null;
				Connection con = DriverManager.getConnection(url, nom, mdp);
				
				//execution de la requete
				Statement stmt = con.createStatement();
				String query = "Insert into user(login,password,role,prenom,nom,mail,age) values('" + req.getParameter("newLogin") + "','" + req.getParameter("newPassword") + "','user','" + req.getParameter("newPrenom") + "','" + req.getParameter("newNom") + "','" + req.getParameter("newMail") + "'," + req.getParameter("newAge") + ")";
				int update = stmt.executeUpdate(query);
				
				con.close();
			}
		}catch(Exception e){
				System.out.println(e.getMessage());
		}	
	}
	
	public String html(){
		return 	"<head>" + 
					"<meta charset=\"utf-8\" />" + 
					"<LINK rel=\"stylesheet\" href=\"../style.css\" type=\"text/css\">" + 
					"<link rel=\"icon\" type=\"image/png\" href=\"../IMG/favicon.png\" />" +
					"<head><title>Nouvel utilisateur</title></head>" + 
				"</head>" +
				"<body>" +
					
				"</body>";
	}
	
}