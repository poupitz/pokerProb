package org.poupitz.dev.metier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.poupitz.dev.exception.CarteIdentiqueException;
import org.poupitz.dev.exception.NombreCarteException;
import org.poupitz.dev.model.Carte;
import org.poupitz.dev.model.CouleurCarte;
import org.poupitz.dev.model.Main;
import org.poupitz.dev.model.Plateau;
import org.poupitz.dev.model.ValeurCarte;

public class TestCombinaison {

	@Test
	public void testIsPaire() throws CarteIdentiqueException,
			NombreCarteException {

		Main main = new Main();
		main.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.CARREAU));
		main.ajouterCarte(new Carte(ValeurCarte.CINQ, CouleurCarte.COEUR));

		Plateau plateau = new Plateau();
		plateau.ajouterCarte(new Carte(ValeurCarte.SEPT, CouleurCarte.PIQUE));
		plateau.ajouterCarte(new Carte(ValeurCarte.TROIS, CouleurCarte.CARREAU));
		plateau.ajouterCarte(new Carte(ValeurCarte.TROIS, CouleurCarte.TREFLE));
		plateau.ajouterCarte(new Carte(ValeurCarte.NEUF, CouleurCarte.COEUR));
		plateau.ajouterCarte(new Carte(ValeurCarte.VALET, CouleurCarte.COEUR));

		assertTrue(new Combinaison().isPaire(main, plateau));

	}

	@Test
	public void testIsNotPaire() throws CarteIdentiqueException,
			NombreCarteException {

		Main main = new Main();
		main.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.CARREAU));
		main.ajouterCarte(new Carte(ValeurCarte.DIX, CouleurCarte.COEUR));

		Plateau plateau = new Plateau();
		plateau.ajouterCarte(new Carte(ValeurCarte.SEPT, CouleurCarte.PIQUE));
		plateau.ajouterCarte(new Carte(ValeurCarte.TROIS, CouleurCarte.CARREAU));
		plateau.ajouterCarte(new Carte(ValeurCarte.CINQ, CouleurCarte.TREFLE));
		plateau.ajouterCarte(new Carte(ValeurCarte.DEUX, CouleurCarte.COEUR));
		plateau.ajouterCarte(new Carte(ValeurCarte.VALET, CouleurCarte.COEUR));

		assertFalse(new Combinaison().isPaire(main, plateau));

	}

	@Test
	public void testIsNotPaireButBrelan() throws CarteIdentiqueException,
			NombreCarteException {

		Main main = new Main();
		main.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.CARREAU));
		main.ajouterCarte(new Carte(ValeurCarte.CINQ, CouleurCarte.COEUR));

		Plateau plateau = new Plateau();
		plateau.ajouterCarte(new Carte(ValeurCarte.SEPT, CouleurCarte.PIQUE));
		plateau.ajouterCarte(new Carte(ValeurCarte.TROIS, CouleurCarte.CARREAU));
		plateau.ajouterCarte(new Carte(ValeurCarte.TROIS, CouleurCarte.TREFLE));
		plateau.ajouterCarte(new Carte(ValeurCarte.TROIS, CouleurCarte.COEUR));
		plateau.ajouterCarte(new Carte(ValeurCarte.VALET, CouleurCarte.COEUR));

		assertFalse(new Combinaison().isPaire(main, plateau));

	}

}
