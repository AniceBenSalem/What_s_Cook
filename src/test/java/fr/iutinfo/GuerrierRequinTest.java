package fr.iutinfo;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.iutinfo.unites.GuerrierRequin;

public class GuerrierRequinTest extends JerseyTest {
	
	@Override
	protected Application configure(){
		return new App();
	}
	Univers u;
	
	@Test
	public void testConstructeur(){
		GuerrierRequin Gr = new GuerrierRequin();
		assertEquals(Gr.getNombre(),0);
		assertEquals(Gr.getForce(),10);
		assertEquals(Gr.getCoutDeplacement(),1);
		assertEquals(Gr.getCoutFabrication("Coquillage"),20);
		assertEquals(Gr.getNiveauCaserneRequis(),1);
	}
	
	@Test
	public void testUp(){
		GuerrierRequin Gr = new GuerrierRequin();
		Gr.up();
		assertEquals(1,Gr.getNombre());
	}

}
