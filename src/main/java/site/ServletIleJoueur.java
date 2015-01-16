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

@WebServlet("servlet/ServletIleJoueur")

public class ServletIleJoueur extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try{
			//Creation de la session
			HttpSession session = req.getSession();

			//Enregistrement du driver
			Class.forName("org.sqlite.JDBC");			

			//Connexion a la base
			String url = "jdbc:sqlite:vinland.db";
			String name = null;
			String passwd = null;
			try (Connection con = DriverManager.getConnection(url, name, passwd)) {
				//execution de la requete
				Statement stmt = con.createStatement();
				String query = "select * from ile Where id = " + session.getAttribute("idIle");
				ResultSet rs = stmt.executeQuery(query);
				PrintWriter out = res.getWriter();
				rs.next();
				req.setAttribute("proprietaire", rs.getString("proprietaire"));
				
				/*
				 *  ATTRIBUTS ENTREPOT
				 */
				
				query="select * from entrepot where id ="+session.getAttribute("idIle");
				rs=stmt.executeQuery(query);
				rs.next();
				req.setAttribute("entrepotcoquillage", rs.getInt("coquillage"));
				req.setAttribute("entrepotcoquillagemax", rs.getInt("capacite"));
					res.sendRedirect("MonIleJsp.jsp");
					//session.setAttribute("idTrue",rs.getString("false"));
				//fermeture des espaces
				con.close();
				this.getServletContext().getRequestDispatcher("../MonIleJsp.jsp").forward(req,res);
			}catch(Exception e){
				System.out.println("Problem requete");
				System.out.println(e.getMessage());
			}
		}catch(Exception e){
			System.out.println("Probème : " + e.getMessage());
		}
	}

}
