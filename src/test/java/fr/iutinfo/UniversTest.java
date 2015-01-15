package fr.iutinfo;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import fr.iutinfo.exceptions.*;
import fr.iutinfo.unites.SurfeurCroMagnon;

public class UniversTest extends JerseyTest{
	
	
	@Override
    protected Application configure() {
        return new App();
        
    }
	
	@Test
	public void TestGetMaxId() throws PlacementOccupeException {
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "lala",10,10);
		univ.addIle(ile,11,11);
		assertEquals(2,univ.getMaxId());
	}
	
	@Test
	public void TestgetNomUnivers() throws PlacementOccupeException{
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste",10,11);
		univ.addIle(ile,11,11);
		assertEquals( "Omega",univ.getNomUnivers());
	}
	
	@Test
	public void TestToString() throws PlacementOccupeException{
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste",10,10);
		univ.addIle(ile,11,11);
		assertEquals( "l'univer Omega possede 2 ile(s).",univ.toString());
	}
	
	@Test
	public void TestDistanceIles() throws PlacementOccupeException {
		Univers univ = new Univers("Vinland");
		Ile ile1 = new Ile(univ, "Japon",5,5);
		Ile ile2 = new Ile(univ, "Madagascar",150,150);
		assertEquals(205,univ.distanceIles(ile1,ile2));
	}
	
	@Test(expected=PlacementOccupeException.class)
	public void testAddIle () throws PlacementOccupeException {
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "bonjourJeSuisUneIle",0,0);
		Ile ile2 = new Ile (univ, "moiAussiMaggle", 0,0);

	}
	
	@Test
	public void testTempsDeplacement () throws PlacementOccupeException {
		Univers univ = new Univers("Vinland");
		Ile ile1 = new Ile(univ, "Atlantis", 0,0);
		Ile ile2 = new Ile(univ, "Villeneuve d'Ausque",50,50);
		SurfeurCroMagnon thibault = new SurfeurCroMagnon();
		Armee armee = new Armee(ile1);
		armee.addUnite(thibault);
		assertEquals("01:10:00",univ.tempsDeplacement(ile1, ile2, armee).toString());
	}
	
}
