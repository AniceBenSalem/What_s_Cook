package fr.iutinfo;

import static org.junit.Assert.*;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class UniversTest extends JerseyTest{

	@Test
	public void testGetMaxId() {
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste");
		univ.addIle(ile);
		univ.addIle(ile);
		assertEquals(2,univ.getMaxId());
	}
	
	public void testToString(){
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste");
		univ.addIle(ile);
		univ.addIle(ile);
		assertEquals( "l'univer Omega possede 2 ile(s).",univ.toString());
	}
	
	public void testgetNomUnivers(){
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste");
		univ.addIle(ile);
		univ.addIle(ile);
		assertEquals( "Omega",univ.getNomUnivers());
	}
	

}
