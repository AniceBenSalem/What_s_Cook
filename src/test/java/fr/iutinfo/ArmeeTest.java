package fr.iutinfo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import fr.iutinfo.App;
import fr.iutinfo.Armee;
import fr.iutinfo.exceptions.PlacementOccupeException;
import fr.iutinfo.unites.SurfeurCroMagnon;

public class ArmeeTest extends JerseyTest{
	Univers u;
	Armee a;
	Ile i,i2;
	
	@Before
	public void init() throws PlacementOccupeException, SQLException{
		a=new Armee(i);
		u=new Univers("test");
		i=new Ile(u,"test1");
		i2=new Ile(u,"test2");
		i.getGenerateurCoquillage().stopGenererRessource();
		i2.getGenerateurCoquillage().stopGenererRessource();

	}

	@Override
    protected Application configure() {
        return new App();
    }
	
	@Test
	public void testVol() throws PlacementOccupeException{
		i.setPoints(100);
		i.getEntrepot().setCoquillage(100);
		i2.setPoints(100);
		i2.getEntrepot().setCoquillage(0);
		i2.getArmee().volRessource(i);
		assertEquals(40,i2.getEntrepot().getCoquillage());
		assertEquals(60,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void testVolPetitRatio() throws PlacementOccupeException{
		i.setPoints(100);
		i2.setPoints(15030);
		
		i.getEntrepot().setCoquillage(100);
		i2.getEntrepot().setCoquillage(0);

		i2.getArmee().volRessource(i);
		
		assertEquals(0,i2.getEntrepot().getCoquillage());
		assertEquals(100,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void testVolMoyenRatio() throws PlacementOccupeException{
		i.setPoints(110);
		i2.setPoints(100);
		
		i.getEntrepot().setCoquillage(100);
		i2.getEntrepot().setCoquillage(0);

		i2.getArmee().volRessource(i);
		
		assertNotEquals(0,i2.getEntrepot().getCoquillage());
		assertNotEquals(100,i.getEntrepot().getCoquillage());
	}
	
	@Test
	public void testVolGrosRatio() throws PlacementOccupeException{
		i2.setPoints(100);
		i.setPoints(15000);
		
		//i2 (peu de points) attaque i (beaucoup de points) = i2 vole beaucoup de ressources 
		i.getEntrepot().setCoquillage(100);
		i2.getEntrepot().setCoquillage(0);
		i2.getArmee().volRessource(i);
		assertEquals(40,i2.getEntrepot().getCoquillage());
		assertEquals(60,i.getEntrepot().getCoquillage());
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
	public void testAttaquerIlePerdu() throws PlacementOccupeException, SQLException {
		u=new Univers("test");
		i = new Ile(u,"leon");
		i.getEntrepot().setCoquillage(1000000);
		i2 = new Ile(u,"un mechant");
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
	public void testAttaquerIleGagner() throws PlacementOccupeException, SQLException {
		u=new Univers("test");
		i = new Ile(u,"leon");
		i.getEntrepot().setCoquillage(1000000);
		i2 = new Ile(u,"un mechant");
		i2.getEntrepot().setCoquillage(1000000);
		i.upCococanon(); //Cococanon lvl 1 = 100 pv
		for(int i = 0;i<11;i++){
			i2.upCromagnonSurfeur();
		} // cree 11 cromagnon = 42pv, 10force (total = 462pv et 110 force)
		i2.putAllSurfeurCromagnonArmee();
		boolean test =i2.getArmee().attaquerIle(i);
		assertFalse(i2.getArmee().getStack().isEmpty()); // tous morts
		assertTrue(test); //on attend une reussite de l'attaque

	}
	
	public void testAttaquerIle3() throws PlacementOccupeException, SQLException {
	a = new Armee(i);
	for (int i = 0; i < 9; i++) {
		a.addUnite(new SurfeurCroMagnon());	
	}
	Ile ile = new Ile(new Univers("omega"), "moi");
	ile.upCococanon();
	ile.upCococanon();
	//assertEquals("Match null", a.attaquerIle(ile));
	}
}
