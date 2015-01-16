package site;

import java.io.*;
import javax.servlet.*; // pour les servlets
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/servlet/Deconnexion")

public class Deconnexion extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try{
			//Session
			HttpSession session = req.getSession(true);
			session.invalidate();
			res.sendRedirect("../index.html");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}