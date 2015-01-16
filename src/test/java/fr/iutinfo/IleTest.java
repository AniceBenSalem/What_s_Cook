package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.iutinfo.batiments.CocoCanon;
import fr.iutinfo.exceptions.PlacementOccupeException;
public class IleTest extends JerseyTest{
	@Override
	protected Application configure(){
		return new App();
	}
	Univers u;
	public static Ile i,i2;
	
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
	public void TestGetValeurDefense() throws PlacementOccupeException, SQLException{
		i.getCococanon().setNombre(0);
		assertEquals(i.getValeurDefense(),0);
		i.getEntrepot().setCoquillage(300);
		i.upCococanon();
		assertEquals(i.getValeurDefense(),((CocoCanon)i.getCococanon()).getPv());
	}
	
	@Test
	public void TestUpGenerateur() throws PlacementOccupeException, SQLException{
		i.getGenerateurCoquillage().setNombre(1);
		assertEquals(i.getGenerateurCoquillage().getNombre(),1);
		i.getEntrepot().setCoquillage(300);
		i.upGenerateurCoquillage();
		assertEquals(i.getGenerateurCoquillage().getNombre(),2);
	}
	
	@Test
	public void TestUpCococanon() throws PlacementOccupeException, SQLException{
		i.getCococanon().setNombre(0);
		assertEquals(i.getCococanon().getNombre(),0);
		i.getEntrepot().setCoquillage(300);
		i.upCococanon();
		assertEquals(i.getCococanon().getNombre(),1);
	}
	
	@Test
	public void TestUpSurfeur() throws PlacementOccupeException, SQLException{
		//i.getSurfeur().setNombre(0);
		assertEquals(i.getSurfeur().getNombre(),0);
		i.getEntrepot().setCoquillage(300);
		i.upCromagnonSurfeur();
		assertEquals(1,i.getSurfeur().getNombre());
	}
	
	@Test
	public void TestUpEntrepot() throws PlacementOccupeException, SQLException{
		Ile i = new Ile(u,"leon");
		assertEquals(i.getEntrepot().getNombre(),1);
		i.getEntrepot().setCoquillage(300);
		i.upEntrepot();
		assertEquals(i.getEntrepot().getNombre(),2);
	}
	
	@Test
	public void testPutSurfeur() throws PlacementOccupeException, SQLException{
		u=new Univers("test");
		Ile i = new Ile(u,"leon");
		i.getEntrepot().setCoquillage(1000000);	
		i.upCromagnonSurfeur();
		i.putSurfeurCromagnonArmee();
		assertEquals(1,i.getArmee().getStack().size());
	}
	
	@Test
	public void testPointsIle () throws PlacementOccupeException, SQLException {
		Ile i = new Ile(u,"amaury");
		assertEquals(0, i.getPoints());
		i.getEntrepot().setCoquillage(300);
		i.upEntrepot();
		assertEquals(80, i.getPoints());
		i.getEntrepot().setCoquillage(300);
		i.upCococanon();
		assertEquals(200, i.getPoints());
		i.getEntrepot().setCoquillage(300);
		i.upGenerateurCoquillage();
		assertEquals(300, i.getPoints());



	

	}
}
