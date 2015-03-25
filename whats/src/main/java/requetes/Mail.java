/*package requetes;

import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import org.eclipse.persistence.internal.oxm.record.json.JSONParser.pair_return;



@Path("/poster")
@Produces(MediaType.APPLICATION_JSON)
public class Mail {
    Transport tran;
	
	@GET
	@Path("/{adresse}/{titre}/{message}")
	public String envoiMail(@PathParam("adresse") String adresse, @PathParam("titre") String titre, @PathParam("message") String message){
		Properties p = new Properties(); 
		p.setProperty("mail.transport.protocol", "smtp"); 
		p.setProperty("mail.smtp.host", "localhost");
	    p.setProperty("mail.smtp.user", "nous");
	    p.setProperty("mail.from", "whatscooking@yopmail.com");
		Session session = Session.getInstance(p);
    
		MimeMessage m = new MimeMessage(session);
    
		try { 
			m.setText(message); 
			m.setSubject(titre); 
			m.addRecipients(Message.RecipientType.TO, adresse);  
		}catch (MessagingException e){ 
			e.printStackTrace(); 
		} 
    
		try { 
			tran = session.getTransport("smtp"); 
			tran.connect("nous", "whatscooking"); 
			tran.sendMessage(m, new Address[] {new InternetAddress(adresse)}); 
		} catch (MessagingException ex) { 
			ex.printStackTrace(); 
		} finally { 
			try { 
				if (tran != null) { 
					tran.close(); 
				} 
			} catch (MessagingException e) { 
				e.printStackTrace(); 
			} 
		} 
		return "{\"b\": true}";
	}
	
	@GET
	@Path("/{adresse}/{message}")
	public String envoiMail(@PathParam("adresse") String adresse, @PathParam("message") String message){
		Properties p = new Properties(); 
		p.setProperty("mail.transport.protocol", "smtp"); 
		p.setProperty("mail.smtp.host", "localhost");
	    p.setProperty("mail.smtp.user", "nous");
	    p.setProperty("mail.from", "whatscooking@yopmail.com");
		Session session = Session.getInstance(p);
    
		MimeMessage m = new MimeMessage(session);
    
		try { 
			m.setText(message); 
			m.setSubject(""); 
			m.addRecipients(Message.RecipientType.TO, adresse);  
		}catch (MessagingException e){ 
			e.printStackTrace(); 
		} 
    
		try { 
			tran = session.getTransport("smtp"); 
			tran.connect("nous", "whatscooking"); 
			tran.sendMessage(m, new Address[] {new InternetAddress(adresse)}); 
		} catch (MessagingException ex) { 
			ex.printStackTrace(); 
		} finally { 
			try { 
				if (tran != null) { 
					tran.close(); 
				} 
			} catch (MessagingException e) { 
				e.printStackTrace(); 
			} 
		} 
		return "{\"b\": true}";
	}
}
*/