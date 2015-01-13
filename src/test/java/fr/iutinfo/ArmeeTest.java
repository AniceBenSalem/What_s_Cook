package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.iutinfo.App;
import fr.iutinfo.Armee;
import fr.iutinfo.batiments.BatimentDefensif;
import fr.iutinfo.batiments.CocoCanon;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.SurfeurCroMagnon;

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
	
	@Test
	public void testAttaquerIle() throws PlacementOccupeException {
		a=new Armee();
		a.addUnite(new SurfeurCroMagnon());
		a.addUnite(new SurfeurCroMagnon());
		Ile ile = new Ile(new Univers("omega"), "moi", 5, 5);
		BatimentDefensif def = new CocoCanon();
		
		
		assertEquals(a.getForce(),new SurfeurCroMagnon().getForce()*2);
	}
	

}
