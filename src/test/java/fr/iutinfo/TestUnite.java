package fr.iutinfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnite {

	@Test
	public void testCoutDeplacement() {
		SurfeurCroMagnon scm = new SurfeurCroMagnon ();
		assertEquals(52, scm.coutDeplacement);
	}
	


}
