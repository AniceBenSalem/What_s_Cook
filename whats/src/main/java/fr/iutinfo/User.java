package fr.iutinfo;

public class User {
	String nom;
	String prenom;
	String mail;
	String login;
	String password;
	String password2;
	
	public User(){
		
	}
	
	public User(String nom, String prenom, String mail, String login, String password, String password2) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail=mail;
		this.login=login;
		this.password=password;
		this.password2=password2;
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
