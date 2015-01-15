package fr.iutinfo;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.iutinfo.unites.SurfeurCroMagnon;

public class CromagnonSurfeurTest extends JerseyTest {
	
	@Override
	protected Application configure(){
		return new App();
	}
	Univers u;
	
	@Test
	public void testConstructeur(){
		SurfeurCroMagnon surf = new SurfeurCroMagnon();
		assertEquals(surf.getNombre(),0);
		assertEquals(surf.getForce(),10);
		assertEquals(surf.getCoutDeplacement(),1);
		assertEquals(surf.getCoutFabrication("Coquillage"),20);
		assertEquals(surf.getNiveauCaserneRequis(),1);


	}
	
	@Test
	public void testUp(){
		SurfeurCroMagnon surf = new SurfeurCroMagnon();
		surf.up();
		assertEquals(1,surf.getNombre());
	}

}