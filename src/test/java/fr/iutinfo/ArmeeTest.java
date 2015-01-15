package fr.iutinfo;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import fr.iutinfo.App;
import fr.iutinfo.Armee;
import fr.iutinfo.batiments.BatimentDefensif;
import fr.iutinfo.batiments.CocoCanon;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.SurfeurCroMagnon;

public class ArmeeTest extends JerseyTest{
	Univers u;
	Armee a;
	Ile i,i2;
	
	@Before
	public void init() throws PlacementOccupeException{
		a=new Armee(i);
		
		
		//Initialise 2 ile avec 1000000 coquillages
	}

	@Override
    protected Application configure() {
        return new App();
    }

	@Test
	public void testAddUnite() {
		a.addUnite(new SurfeurCroMagnon());
		a.addUnite(new SurfeurCroMagnon());
		assertEquals(a.getStack().size(),2);
	}
	
	@Test
	public void testGetPV() {
		a=new Armee(i);
		a.addUnite(new SurfeurCroMagnon());
		a.addUnite(new SurfeurCroMagnon());
		assertEquals(a.getPV(),new SurfeurCroMagnon().getPV()*2);
	}
	
	@Test
	public void testGetForce() {
		a=new Armee(i);
		a.addUnite(new SurfeurCroMagnon());
		a.addUnite(new SurfeurCroMagnon());
		assertEquals(a.getForce(),new SurfeurCroMagnon().getForce()*2);
	}
	
	@Test
	public void testAttaquerIlePerdu() throws PlacementOccupeException {
		u=new Univers("test");
		i = new Ile(u,"leon",1,1);
		i.getEntrepot().setCoquillage(1000000);
		i2 = new Ile(u,"un mechant",2,2);
		i2.getEntrepot().setCoquillage(1000000);
		i.upCococanon(); //Cococanon lvl 1 = 100 pv
		for(int i = 0;i<2;i++){
			i2.upCromagnonSurfeur();
		} // cree 2 cromagnon = 42pv, 10force
		i2.putAllSurfeurCromagnonArmee();
		assertFalse(i2.getArmee().attaquerIle(i)); //on attend un echec de l'attaque
		assertTrue(i2.getArmee().getStack().isEmpty()); // tous morts
		
	}
	
	@Test
	public void testAttaquerIleGagner() throws PlacementOccupeException {
		u=new Univers("test");
		i = new Ile(u,"leon",1,1);
		i.getEntrepot().setCoquillage(1000000);
		i2 = new Ile(u,"un mechant",2,2);
		i2.getEntrepot().setCoquillage(1000000);
		i.upCococanon(); //Cococanon lvl 1 = 100 pv
		System.out.println(i.getValeurDefense());
		for(int i = 0;i<11;i++){
			i2.upCromagnonSurfeur();
		} // cree 11 cromagnon = 42pv, 10force (total = 462pv et 110 force)
		i2.putAllSurfeurCromagnonArmee();
		System.out.println(i2.getArmee().getForce());
		boolean test =i2.getArmee().attaquerIle(i);
		assertFalse(i2.getArmee().getStack().isEmpty()); // tous morts
		assertTrue(test); //on attend une reussite de l'attaque

	}
	
	public void testAttaquerIle3() throws PlacementOccupeException {
	a = new Armee(i);
	for (int i = 0; i < 9; i++) {
		a.addUnite(new SurfeurCroMagnon());	
	}
	Ile ile = new Ile(new Univers("omega"), "moi", 5, 5);
	ile.upCococanon();
	ile.upCococanon();
	//assertEquals("Match null", a.attaquerIle(ile));
	}
}
