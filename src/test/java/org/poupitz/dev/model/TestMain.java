package org.poupitz.dev.model;

import org.junit.Test;
import org.poupitz.dev.exception.CarteIdentiqueException;
import org.poupitz.dev.exception.NombreCarteException;

public class TestMain {

	@Test
	public void testMainCorrecte() throws CarteIdentiqueException,
			NombreCarteException {

		/*
		 * Test en cas nominal pour assurer une non regression : normalement pas
		 * d'exception levée
		 */
		Main main = new Main();
		main.ajouterCarte(new Carte(ValeurCarte.SIX, CouleurCarte.TREFLE));
		main.ajouterCarte(new Carte(ValeurCarte.HUIT, CouleurCarte.COEUR));

	}

	@Test(expected = CarteIdentiqueException.class)
	public void testMainIncorrecteCarteIdentique()
			throws CarteIdentiqueException, NombreCarteException {

		Main main = new Main();
		main.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.CARREAU));
		main.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.CARREAU));

	}

	@Test(expected = NombreCarteException.class)
	public void testMainIncorrecteTropDeCarte() throws CarteIdentiqueException,
			NombreCarteException {

		Main main = new Main();
		main.ajouterCarte(new Carte(ValeurCarte.SIX, CouleurCarte.TREFLE));
		main.ajouterCarte(new Carte(ValeurCarte.HUIT, CouleurCarte.COEUR));
		main.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.CARREAU));

	}

}
