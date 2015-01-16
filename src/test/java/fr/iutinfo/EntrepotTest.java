package fr.iutinfo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.BeforeClass;
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
	
	@BeforeClass
	public static void  before() throws PlacementOccupeException, SQLException{
		if(IleTest.i==null){
			IleTest.i=new Ile(new Univers("test"),"test");
			IleTest.i.getGenerateurCoquillage().stopGenererRessource();
		}
		if(IleTest.i2==null){
			IleTest.i2=new Ile(new Univers("test"),"test2");
			IleTest.i2.getGenerateurCoquillage().stopGenererRessource();
		}
	}
	
	@Before
	public void init() throws PlacementOccupeException, SQLException{
		u = new Univers("test");
		i = new Ile(u,"test");
		i.getEntrepot().setCoquillage(200);
		i.getGenerateurCoquillage().stopGenererRessource();
	}
	
	@Test
	public void retirerRessourceTestOK() throws SQLException{
		i.getEntrepot().setCoquillage(200);
		i.getEntrepot().retirer("Coquillage", 50);
		assertEquals(150,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void retirerRessourceTestNegatif() throws SQLException{
		i.getEntrepot().setCoquillage(20);
		i.getEntrepot().retirer("Coquillage", 50);
		assertEquals(0,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void retirerRessourceTestMauvaiseRessource() throws SQLException{
		i.getEntrepot().setCoquillage(200);
		i.getGenerateurCoquillage().stopGenererRessource();
		i.getEntrepot().retirer("Coquillage", 50);
		assertEquals(150,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void ajouterRessourceTestOK() throws SQLException{
		i.getEntrepot().setCoquillage(200);
		i.getEntrepot().setCapacite(300);
		i.getEntrepot().ajouter("Coquillage", 50);
		assertEquals(250,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void ajouterRessourceTestMauvaiseRessource() throws PlacementOccupeException, SQLException{
		i=new Ile(new Univers("test"),"test");
		i.getGenerateurCoquillage().stopGenererRessource();
		i.getEntrepot().setCoquillage(200);
		assertEquals(200,i.getEntrepot().getCoquillage());
		i.getEntrepot().ajouter("trolololo", 50);
		assertEquals(200,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void ajouterRessourceTestZero() throws PlacementOccupeException, SQLException{
		i=new Ile(new Univers("test"),"test");
		i.getGenerateurCoquillage().stopGenererRessource();
		i.getEntrepot().setCoquillage(200);
		assertEquals(200,i.getEntrepot().getCoquillage());
		i.getEntrepot().ajouter("Coquillage", 0);
		assertEquals(200,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void testEnvoiRessourceAssezDeCoquillages() throws PlacementOccupeException, SQLException {
		Univers a = new Univers ("lala");
		Ile i = new Ile (a, "a");
		Univers u = new Univers ("Univers");
		Ile ile = new Ile (u, "proprietaire");
		Entrepot e = new Entrepot (i);
		e.setCoquillage(50);
		Ile ile2 = new Ile (u, "proprietaire2");
		Entrepot e2 = new Entrepot (i);
		try {
			e.donnerRessource("Coquillage", 15, e2);
		} catch (NoCoquillageException e1) {
			e1.printStackTrace();
		}
		
		assertEquals(35, e.getCoquillage());
		assertEquals(15, e2.getCoquillage());
	}
	
	@Test(expected=NoCoquillageException.class)
	public void testEnvoiRessourcePasAssezCoquillages () throws NoCoquillageException, PlacementOccupeException, SQLException {
		Univers u = new Univers ("Univers");
		Ile ile = new Ile (u, "proprietaire");
		Entrepot e = new Entrepot (ile);
		e.setCoquillage(50);
		Ile ile2 = new Ile (u, "proprietaire2");
		Entrepot e2 = new Entrepot (ile2);
		e.donnerRessource("Coquillage", 60, e2);	
		
	}

}
