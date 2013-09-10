package org.poupitz.dev.metier;

import org.junit.Test;
import org.poupitz.dev.exception.CarteIdentiqueException;
import org.poupitz.dev.exception.NombreCarteException;
import org.poupitz.dev.model.Carte;
import org.poupitz.dev.model.CouleurCarte;
import org.poupitz.dev.model.Deck;
import org.poupitz.dev.model.Main;
import org.poupitz.dev.model.ValeurCarte;

public class TestCalcul {

	@Test
	public void testCalcul() throws CarteIdentiqueException,
			NombreCarteException {

		Main main = new Main();
		main.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.COEUR));
		main.ajouterCarte(new Carte(ValeurCarte.AS, CouleurCarte.PIQUE));
		Deck deck = new Deck();

		PlateauPreFlop pla = new PlateauPreFlop(main, deck);

		pla.calculerCombinaison();

	}

}
