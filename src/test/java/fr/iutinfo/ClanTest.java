package fr.iutinfo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import fr.iutinfo.exceptions.PlacementOccupeException;

public class ClanTest {
	Ile i1;
	Ile i2;
	Ile i3;

	@Before
	public void init() throws PlacementOccupeException, SQLException {
		Univers u = new Univers("Univers");
		i1 = new Ile(u, "Proprietaire", 10, 20);
		i2 = new Ile(u, "Proprietaire 2", 15, 25);
		i3 = new Ile(u, "Proprietaire 2", 11, 25);

	}

	@Test
	public void testAjoutOk() {
		Clan c = new Clan();
		c.setCapacite(1);
		assertTrue(c.addMembre(i1));

	}

	@Test
	public void testAjoutKo() {
		Clan c = new Clan();
		c.setCapacite(1);
		assertTrue(c.addMembre(i1));
		assertFalse(c.addMembre(i2));

	}

	@Test
	public void testRemoveOk() {
		Clan c = new Clan();
		c.setCapacite(2);
		c.addMembre(i1);
		c.addMembre(i2);
		assertTrue(c.removeMembre(i2));
		//assertEquals(1, c.getNombreMembres());
	}

	@Test
	public void testRemoveKo() {
		Clan c = new Clan();
		c.setCapacite(2);
		c.addMembre(i1);
		c.addMembre(i2);
		assertFalse(c.removeMembre(i3));
		//assertEquals(2, c.getNombreMembres());
	}
}
