package fr.iutinfo;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class UniversTest extends JerseyTest{
	
	
	@Override
    protected Application configure() {
        return new App();
        
    }
	
	@Test
	public void TestGetMaxId() {
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste");
		univ.addIle(ile);
		univ.addIle(ile);
		assertEquals(3,univ.getMaxId());
	}
	
	
	
	public void TestgetNomUnivers(){
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste");
		univ.addIle(ile);
		univ.addIle(ile);
		assertEquals( "Omega",univ.getNomUnivers());
	}
	
	public void TestToString(){
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste");
		univ.addIle(ile);
		univ.addIle(ile);
		assertEquals( "l'univer Omega possede 2 ile(s).",univ.toString());
	}
	

}
