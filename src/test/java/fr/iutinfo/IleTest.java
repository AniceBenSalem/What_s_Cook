package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

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
	public void TestIleConstructeurId() {
		Ile i = new Ile(u,"leon",10,10);
		assertEquals(i.getId(),1);
		Ile i2 = new Ile(u,"henry",11,11);
		assertEquals(i2.getId(),2);
	}
	
	@Test
	public void TestIleConstructeur() {
		Ile i = new Ile(u,"leon",10,10);
		assertEquals(i.getUnivers(),u);
		assertEquals(i.getProprietaire(),"leon");
	}
}
