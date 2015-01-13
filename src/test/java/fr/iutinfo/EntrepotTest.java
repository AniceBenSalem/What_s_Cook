package fr.iutinfo;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iutinfo.batiments.Entrepot;
import fr.iutinfo.exceptions.NoCoquillageException;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.ressources.Coquillage;

/**
 * Permet de tester les methodes associees a l'entrepot
 * @author dumetza
 *
 */
public class EntrepotTest {

	@Test
	public void testEnvoiRessourceAssezDeCoquillages() throws PlacementOccupeException {
		Univers u = new Univers ("Univers");
		Ile ile = new Ile (u, "proprietaire", 10,10);
		Entrepot e = new Entrepot (ile);
		e.setCoquillage(50);
		Ile ile2 = new Ile (u, "proprietaire2", 11,11);
		Entrepot e2 = new Entrepot (ile2);
		try {
			e.donnerRessource(new Coquillage(), 15, e2);
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
		Entrepot e = new Entrepot (ile);
		e.setCoquillage(50);
		Ile ile2 = new Ile (u, "proprietaire2",11,11);
		Entrepot e2 = new Entrepot (ile2);
		e.donnerRessource(new Coquillage(), 60, e2);
		
		
		
	}

}
