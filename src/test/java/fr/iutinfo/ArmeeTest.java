package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class ArmeeTest extends JerseyTest{
	Armee a;
	@Override
    protected Application configure() {
        return new App();
    }
	
	@Test
	public void testAddUnite() {
		a=new Armee();
		a.addUnite(new SurfeurCroMagnon());
		a.addUnite(new SurfeurCroMagnon());
		assertEquals(a.getStack().size(),2);
	}
	
	@Test
	public void testSubitDegats() {
		a=new Armee();
		a.addUnite(new SurfeurCroMagnon());
		a.addUnite(new SurfeurCroMagnon());
		a.subitDegats(10);
		assertEquals((new SurfeurCroMagnon().getPV()*2)-10,a.getPV());
		a.subitDegats(100);
		assertEquals(a.getStack().size(),0);
	}
	
	@Test
	public void testGetPV() {
		a=new Armee();
		a.addUnite(new SurfeurCroMagnon());
		a.addUnite(new SurfeurCroMagnon());
		assertEquals(a.getPV(),new SurfeurCroMagnon().getPV()*2);
	}
	
	@Test
	public void testGetForce() {
		a=new Armee();
		a.addUnite(new SurfeurCroMagnon());
		a.addUnite(new SurfeurCroMagnon());
		assertEquals(a.getForce(),new SurfeurCroMagnon().getForce()*2);
	}

}
