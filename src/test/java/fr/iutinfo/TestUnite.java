package fr.iutinfo;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iutinfo.unites.SurfeurCroMagnon;

public class TestUnite {

	@Test
	public void testCoutDeplacement() {
		SurfeurCroMagnon scm = new SurfeurCroMagnon ();
		assertEquals(52, scm.getCoutDeplacement());
	}
	


}
