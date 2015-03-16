package cuisine;
public class User {
	String mail;
	String login;
	String password;
	
	public User(){
		
	}
	
	public User( String mail, String login, String password){
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
