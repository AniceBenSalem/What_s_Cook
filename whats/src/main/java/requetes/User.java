package requetes;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.iutinfo.InitBDD;


@Path("/user")
public class User {
	String mail;
	String login;
	String password;
	String password2;
	InitBDD b;
	public User(){
		
	}
	

	@GET
	@Path("/setUser/{mail}/{login}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public void addUser(@PathParam("mail") String mail,@PathParam("login") String login, @PathParam("password") String password) throws SQLException {
		b=new InitBDD();
		b.setUser(mail, login, password);
	}
	
	public User(String mail, String login, String password) {
		this.mail=mail;
		this.login=login;
		this.password=password;
	}
	
	public String getMail(){
		return this.mail;
	}
	
	public void setMail(String mail){
		this.mail=mail;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public void setLogin(String login){
		this.login=login;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String toString(){
		return this.mail+" login : "+this.login+" password :"+this.password;
	}
}
