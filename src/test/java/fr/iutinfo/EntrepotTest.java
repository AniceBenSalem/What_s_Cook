package fr.iutinfo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Permet de tester les methodes associees a l'entrepot
 * @author dumetza
 *
 */
public class EntrepotTest {

	@Test
	public void testEnvoiRessourceAssezDeCoquillages() {
		Univers u = new Univers ("Univers");
		Ile ile = new Ile (u, "proprietaire");
		Entrepot e = new Entrepot (ile);
		e.setCoquillage(50);
		Ile ile2 = new Ile (u, "proprietaire2");
		Entrepot e2 = new Entrepot (ile2);
		try {
			e.donnerRessource(new Coquillage(), 15, e2);
		} catch (NoCoquillageException e1) {
			e1.printStackTrace();
		}
		
		assertEquals(35, e.coquillage);
		assertEquals(15, e2.coquillage);
	}
	
	@Test(expected=NoCoquillageException.class)
	public void testEnvoiRessourcePasAssezCoquillages () throws NoCoquillageException {
		Univers u = new Univers ("Univers");
		Ile ile = new Ile (u, "proprietaire");
		Entrepot e = new Entrepot (ile);
		e.setCoquillage(50);
		Ile ile2 = new Ile (u, "proprietaire2");
		Entrepot e2 = new Entrepot (ile2);
		e.donnerRessource(new Coquillage(), 60, e2);
		
		
		
	}

}
