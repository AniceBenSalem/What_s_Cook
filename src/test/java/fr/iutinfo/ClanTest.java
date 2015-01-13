package fr.iutinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.iutinfo.exceptions.PlacementOccupeException;

public class ClanTest {
	Ile i1;
	Ile i2;
	@Before
	public void init () throws PlacementOccupeException {
		Univers u = new Univers ("Univers");
		 i1 = new Ile (u, "Proprietaire", 10,20);
		i2 = new Ile (u, "Proprietaire 2", 15, 25);
		
	}
	
	
	/**
	 * Dans un clan de taille 1, on verifie qu'on peut ajouter un membre
	 */
	@Test
	public void testAjoutOk() {
		Clan c = new Clan ();
		c.setCapacite(1);
		assertTrue(c.addMembre(i1));
		
	}
	
	/**
	 * Dans un clan de taille 1, on verifie qu'on ne peut pas ajouter deux membres
	 */
	@Test
	public void testAjoutKo() {
		Clan c = new Clan ();
		c.setCapacite(1);
		assertTrue(c.addMembre(i1));
		assertFalse(c.addMembre(i2));
		
	}
	

}
