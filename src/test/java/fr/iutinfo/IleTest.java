package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.SurfeurCroMagnon;

public class IleTest extends JerseyTest{
	@Override
	protected Application configure(){
		return new App();
	}
	Univers u;
	
	@Before
	public void testInit(){
		u = new Univers("UnivTest");
	}
	
	@Test
	public void TestIleConstructeurId() throws PlacementOccupeException {
		Ile i = new Ile(u,"leon",10,10);
		assertEquals(i.getId(),1);
		Ile i2 = new Ile(u,"henry",11,11);
		assertEquals(i2.getId(),2);
	}
	
	@Test
	public void TestGetValeurDefense() throws PlacementOccupeException{
		Ile i = new Ile(u,"leon",10,10);
		i.upCococanon();
		assertEquals(i.getValeurDefense(),0);
		i.getEntrepot().setCoquillage(300);
		i.upCococanon();
		assertEquals(i.getValeurDefense(),100);
	}
	
	@Test
	public void TestUpGenerateur() throws PlacementOccupeException{
		Ile i = new Ile(u,"leon",10,10);
		assertEquals(i.getGenerateurCoquillage().getNombre(),1);
		i.getEntrepot().setCoquillage(300);
		i.upGenerateur();
		assertEquals(i.getGenerateurCoquillage().getNombre(),2);
	}
	
	@Test
	public void TestUpCococanon() throws PlacementOccupeException{
		Ile i = new Ile(u,"leon",10,10);
		assertEquals(i.getCococanon().getNombre(),0);
		i.getEntrepot().setCoquillage(300);
		i.upCococanon();
		assertEquals(i.getCococanon().getNombre(),1);
	}
	
	@Test
	public void TestUpEntrepot() throws PlacementOccupeException{
		Ile i = new Ile(u,"leon",10,10);
		assertEquals(i.getEntrepot().getNombre(),1);
		i.getEntrepot().setCoquillage(300);
		i.upEntrepot();
		assertEquals(i.getEntrepot().getNombre(),2);
	}
	
	@Test
	public void testPointsIle () throws PlacementOccupeException {
		Ile i = new Ile(u,"amaury",10,10);
		assertEquals(0, i.getPoints());
		i.upEntrepot();
		assertEquals(80, i.getPoints());
		i.upCococanon();
		assertEquals(200, i.getPoints());
		i.upGenerateur();
		assertEquals(300, i.getPoints());
		SurfeurCroMagnon scm = new SurfeurCroMagnon();
		i.addUnite(scm);
		assertEquals(305, i.getPoints());
	

	}
}
