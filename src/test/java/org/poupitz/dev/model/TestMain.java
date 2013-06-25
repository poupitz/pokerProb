package org.poupitz.dev.model;

import org.junit.Test;
import org.poupitz.dev.exception.CarteIdentiqueException;

public class TestMain {

	@Test
	public void testMain() throws CarteIdentiqueException {

		/*
		 * Test en cas nominal pour assurer une non regression : normalement pas
		 * d'exception levée
		 */
		Carte carte_1 = new Carte(ValeurCarte.SIX, CouleurCarte.TREFLE);
		Carte carte_2 = new Carte(ValeurCarte.HUIT, CouleurCarte.COEUR);

		Main main = new Main(carte_1, carte_2);

	}

	@Test(expected = CarteIdentiqueException.class)
	public void testMainIncorrecteException() throws CarteIdentiqueException {

		Carte carte = new Carte(ValeurCarte.AS, CouleurCarte.CARREAU);

		Main main = new Main(carte, carte);

	}

}
