package eshop.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SuperMathsTest {

	
	@BeforeClass
	public static void auDebutDesTest() 
	{
		System.out.println("Debut des test classe SuperMaths");
	}
	
	@Before
	public void avantChaqueTest() 
	{
		System.out.println("-----Prochain test----");
	}
	
	@Test
	public void testConstructeur() 
	{
		//Arrange
		SuperMaths s=null;
		
		//Act
		s = new SuperMaths();
		
		//Assert
		assertNotNull(s);
		/*if(s==null) 
		{
			fail();
		}*/
	}
	
	@Test
	public void testAddition() 
	{
		//Arrange
		int a=1;
		int b=5;
		int resultatAttendu=6;
		int resultat;
		SuperMaths s = new SuperMaths();
		
		//Act
		resultat=s.additionner(a, b);
		
		//Assert
		
		assertTrue(resultatAttendu==resultat);
		
		//Avec des int/double/Integer/Double... il vaut mieux utiliser assertTrue/assertFalse
		assertEquals(resultatAttendu, resultat);	
	}
	
	
	@Test
	public void testSoustraction() 
	{
		//Arrange
		int a=6;
		int b=5;
		int resultatNonAttendu=0;
		int resultat;
		SuperMaths s = new SuperMaths();
		
		//Act
		resultat=s.soustraire(a, b);
		
		//Assert
		assertFalse(resultatNonAttendu==resultat);
		
	}

}
