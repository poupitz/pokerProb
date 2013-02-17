package org.poupitz.dev.model;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestCarte {
	
	@Test
	public void testEqualsCarte() {
		
		Carte carte1 = new Carte("As", "Pique");
		Carte carte2 = new Carte("As", "Pique");
		Carte carte3 = new Carte("As", "Coeur");
		
		boolean result1 = carte1.equals(carte2);
		boolean result2 = carte1.equals(carte3);
		
				
		assertTrue(result1);
		assertFalse(result2);
		
	}

}
