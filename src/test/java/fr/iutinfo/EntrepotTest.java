package fr.iutinfo;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import fr.iutinfo.batiments.Entrepot;
import fr.iutinfo.exceptions.NoCoquillageException;
import fr.iutinfo.exceptions.PlacementOccupeException;

/**
 * Permet de tester les methodes associees a l'entrepot
 * @author dumetza
 *
 */
public class EntrepotTest extends JerseyTest {
	
	Ile i;
	Univers u;
	
	@Override
    protected Application configure() {
        return new App();
        
    }
	
	@Before
	public void init() throws PlacementOccupeException{
		u = new Univers("test");
		i = new Ile(u,"test",1,1);
		i.getEntrepot().setCoquillage(200);
		i.getGenerateurCoquillage().stopGenererRessource();
	}
	
	@Test
	public void retirerRessourceTestOK(){
		i.getEntrepot().setCoquillage(200);
		i.getEntrepot().retirer("Coquillage", 50);
		assertEquals(150,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void retirerRessourceTestNegatif(){
		i.getEntrepot().setCoquillage(20);
		i.getEntrepot().retirer("Coquillage", 50);
		assertEquals(0,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void retirerRessourceTestMauvaiseRessource(){
		i.getEntrepot().setCoquillage(200);
		i.getGenerateurCoquillage().stopGenererRessource();
		i.getEntrepot().retirer("Coquillage", 50);
		assertEquals(150,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void ajouterRessourceTestOK(){
		i.getEntrepot().setCoquillage(200);
		i.getEntrepot().ajouter("Coquillage", 50);
		assertEquals(250,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void ajouterRessourceTestMauvaiseRessource() throws PlacementOccupeException{
		i=new Ile(new Univers("test"),"test",1,1);
		i.getGenerateurCoquillage().stopGenererRessource();
		i.getEntrepot().setCoquillage(200);
		assertEquals(200,i.getEntrepot().getCoquillage());
		i.getEntrepot().ajouter("trolololo", 50);
		assertEquals(200,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void ajouterRessourceTestZero() throws PlacementOccupeException{
		i=new Ile(new Univers("test"),"test",1,1);
		i.getGenerateurCoquillage().stopGenererRessource();
		i.getEntrepot().setCoquillage(200);
		assertEquals(200,i.getEntrepot().getCoquillage());
		i.getEntrepot().ajouter("Coquillage", 0);
		assertEquals(200,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void testEnvoiRessourceAssezDeCoquillages() throws PlacementOccupeException {
		Univers u = new Univers ("Univers");
		Ile ile = new Ile (u, "proprietaire", 10,10);
		Entrepot e = new Entrepot ();
		e.setCoquillage(50);
		Ile ile2 = new Ile (u, "proprietaire2", 11,11);
		Entrepot e2 = new Entrepot ();
		try {
			e.donnerRessource("Coquillage", 15, e2);
		} catch (NoCoquillageException e1) {
			e1.printStackTrace();
		}
		
		assertEquals(35, e.getCoquillage());
		assertEquals(15, e2.getCoquillage());
	}
	
	@Test(expected=NoCoquillageException.class)
	public void testEnvoiRessourcePasAssezCoquillages () throws NoCoquillageException, PlacementOccupeException {
		Univers u = new Univers ("Univers");
		Ile ile = new Ile (u, "proprietaire",10,10);
		Entrepot e = new Entrepot ();
		e.setCoquillage(50);
		Ile ile2 = new Ile (u, "proprietaire2",11,11);
		Entrepot e2 = new Entrepot ();
		e.donnerRessource("Coquillage", 60, e2);	
		
	}

}
