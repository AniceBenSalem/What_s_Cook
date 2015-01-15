package site;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Juste l'algo, il faut la lier avec le web désormais.
public class VerifEntree {

	          public VerifEntree(String s){
	int nombre = 0; 

	Pattern pattern = Pattern.compile("[^A-Z&&[^a-z&&[^0-9]]]"); 
	      // Les caractères à refuser: 

	Matcher matcher = pattern.matcher(s);

	          
	while(matcher.find())  
	{ 
	 nombre++; 
	} 
	if(nombre >0) 
	System.out.println("\nIl y a " + nombre + " lettre(s) (ou caractere(s)) non conforme(s) !!!");
	
	else 
	System.out.println("\nIl n'y a pas de lettre(s) (ou caractere(s)) non conforme(s) !!!"); 
	}
	}
	
	

