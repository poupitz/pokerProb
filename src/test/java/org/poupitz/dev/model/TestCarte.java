package org.poupitz.dev.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCarte {

	@Test
	public void testEqualsCarte() {

		Carte carte1 = new Carte(ValeurCarte.AS, CouleurCarte.PIQUE);
		Carte carte2 = new Carte(ValeurCarte.AS, CouleurCarte.PIQUE);
		Carte carte3 = new Carte(ValeurCarte.AS, CouleurCarte.COEUR);
		Carte carte4 = new Carte(ValeurCarte.ROI, CouleurCarte.COEUR);

		boolean result1 = carte1.equals(carte2);
		boolean result2 = carte1.equals(carte3);

		int result3 = carte4.compareTo(carte3);
		int result4 = carte1.compareTo(carte3);
		int result5 = carte3.compareTo(carte4);

		assertTrue(result1);
		assertFalse(result2);

		assertTrue(result3 < 0);
		assertTrue(result4 == 0);
		assertFalse(result5 < 0);

	}

	@Test
	public void testCompareCarte() {

		Carte carte1 = new Carte(ValeurCarte.AS, CouleurCarte.PIQUE);
		Carte carte2 = new Carte(ValeurCarte.AS, CouleurCarte.PIQUE);
		Carte carte3 = new Carte(ValeurCarte.AS, CouleurCarte.COEUR);
		Carte carte4 = new Carte(ValeurCarte.ROI, CouleurCarte.COEUR);

		int result3 = carte4.compareTo(carte3);
		int result4 = carte1.compareTo(carte3);
		int result5 = carte3.compareTo(carte4);

		assertTrue(result3 < 0);
		assertTrue(result4 == 0);
		assertFalse(result5 < 0);

	}

}
