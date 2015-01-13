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
		Ile ile = new Ile(univ, "Ara..terroriste",10,10);
		univ.addIle(ile,10,10);
		univ.addIle(ile,11,11);
		assertEquals(3,univ.getMaxId());
	}
	
	
	
	public void TestgetNomUnivers(){
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste",10,11);
		univ.addIle(ile,10,10);
		univ.addIle(ile,11,11);
		assertEquals( "Omega",univ.getNomUnivers());
	}
	
	public void TestToString(){
		Univers univ = new Univers("Omega");
		Ile ile = new Ile(univ, "Ara..terroriste",10,10);
		univ.addIle(ile,10,10);
		univ.addIle(ile,11,11);
		assertEquals( "l'univer Omega possede 2 ile(s).",univ.toString());
	}
	

}
