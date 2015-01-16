package fr.iutinfo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.iutinfo.exceptions.*;
import fr.iutinfo.unites.SurfeurCroMagnon;

public class UniversTest extends JerseyTest{
	
	@BeforeClass
	public void before() throws PlacementOccupeException, SQLException{
		if(IleTest.i==null){
			IleTest.i=new Ile(new Univers("test"),"test");
			IleTest.i.getGenerateurCoquillage().stopGenererRessource();
		}
		if(IleTest.i2==null){
			IleTest.i2=new Ile(new Univers("test"),"test2");
			IleTest.i2.getGenerateurCoquillage().stopGenererRessource();
		}
	}
	
	@Override
    protected Application configure() {
        return new App();
        
    }
	
//	@Test
//	public void TestGetMaxId() throws PlacementOccupeException, SQLException {
//		Univers univ = new Univers("Omega");
//		Ile ile = new Ile(univ, "lala");
//		univ.addIle(ile,11,11);
//		assertEquals(2,univ.getMaxId());
//	}
	
//	@Test
//	public void TestgetNomUnivers() throws PlacementOccupeException, SQLException{
//		Univers univ = new Univers("Omega");
//		Ile ile = new Ile(univ, "Ara..terroriste");
//		univ.addIle(ile,11,11);
//		assertEquals( "Omega",univ.getNomUnivers());
//	}
	
//	@Test
//	public void TestToString() throws PlacementOccupeException, SQLException{
//		Univers univ = new Univers("Omega");
//		Ile ile = new Ile(univ, "Ara..terroriste");
//		univ.addIle(ile,11,11);
//		assertEquals( "l'univer Omega possede 2 ile(s).",univ.toString());
//	}
	
//	@Test(expected=PlacementOccupeException.class)
//	public void testAddIle () throws PlacementOccupeException, SQLException {
//		Univers univ = new Univers("Omega");
//		Ile ile = new Ile(univ, "bonjourJeSuisUneIle");
//		Ile ile2 = new Ile (univ, "moiAussiMaggle");
//
//	}
	
}
