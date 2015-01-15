package site;

import java.io.IOException;
import java.util.Properties;

//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Messagerie {
	
	/*public static void sendMessage(String subject, String text, String destinataire, String copyDest) { 
	    
		// 1 -> Création de la session 
	    Properties properties = new Properties(); 
	    properties.setProperty("mail.transport.protocol", "smtp"); 
	    properties.setProperty("mail.smtp.host", SMTP_HOST1); 
	    properties.setProperty("mail.smtp.user", LOGIN_SMTP1); 
	    properties.setProperty("mail.from", IMAP_ACCOUNT1); 
	    Session session = Session.getInstance(properties); 
	    
	    // 2 -> Création du message 
	    MimeMessage message = new MimeMessage(session); 
	    try { 
	        message.setText(text); 
	        message.setSubject(subject); 
	        message.addRecipients(Message.RecipientType.TO, destinataire); 
	        message.addRecipients(Message.RecipientType.CC, copyDest); 
	    } catch (MessagingException e) { 
	        e.printStackTrace(); 
	    } 
	    
	    // 3 -> Envoi du message 
	    Transport transport;
	    try { 
	    	transport = session.getTransport("smtp");
	       // transport.connect(LOGIN_SMTP1, PASSWORD_SMTP1); 
	        transport.sendMessage(message, new Address[] { new InternetAddress(destinataire), new InternetAddress(copyDest) }); 
	    } catch (MessagingException e) { 
	        e.printStackTrace(); 
	    } finally { 
	        try { 
	            if (transport != null) { 
	                transport.close(); 
	            } 
	        } catch (MessagingException e) { 
	            e.printStackTrace(); 
	        } 
	    }
	}*/
}
