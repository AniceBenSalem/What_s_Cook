package fr.iutinfo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.GuerrierRequin;

public class GuerrierRequinTest extends JerseyTest {
	
	@Override
	protected Application configure(){
		return new App();
	}
	Univers u;
	
	@BeforeClass
	public static void before() throws PlacementOccupeException, SQLException{
		if(IleTest.i==null){
			IleTest.i=new Ile(new Univers("test"),"test");
			IleTest.i.getGenerateurCoquillage().stopGenererRessource();
		}
		if(IleTest.i2==null){
			IleTest.i2=new Ile(new Univers("test"),"test2");
			IleTest.i2.getGenerateurCoquillage().stopGenererRessource();
		}
	}
	
	@Test
	public void testConstructeur(){
		GuerrierRequin Gr = new GuerrierRequin();
		assertEquals(Gr.getNombre(),0);
		assertEquals(Gr.getForce(),40);
		assertEquals(Gr.getCoutDeplacement(),2);
		assertEquals(Gr.getCoutFabrication("Coquillage"),50);
		assertEquals(Gr.getNiveauCaserneRequis(),3);
	}
	
	@Test
	public void testUp(){
		GuerrierRequin Gr = new GuerrierRequin();
		Gr.up();
		assertEquals(1,Gr.getNombre());
	}

}
