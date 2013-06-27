package org.poupitz.dev.model;

import org.junit.Test;
import org.poupitz.dev.exception.CarteIdentiqueException;
import org.poupitz.dev.exception.NombreCarteException;

public class TestPlateau {

	@Test
	public void testPlateauCorrect() throws CarteIdentiqueException,
			NombreCarteException {

		Plateau plateau = new Plateau();

		plateau.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.CARREAU));
		plateau.ajouterCarte(new Carte(ValeurCarte.CINQ, CouleurCarte.COEUR));
		plateau.ajouterCarte(new Carte(ValeurCarte.SEPT, CouleurCarte.PIQUE));
		plateau.ajouterCarte(new Carte(ValeurCarte.DAME, CouleurCarte.COEUR));
		plateau.ajouterCarte(new Carte(ValeurCarte.TROIS, CouleurCarte.TREFLE));
	}

	@Test(expected = CarteIdentiqueException.class)
	public void testPlateauIncorrect() throws CarteIdentiqueException,
			NombreCarteException {

		Plateau plateau = new Plateau();

		plateau.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.CARREAU));
		plateau.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.CARREAU));

	}

}
