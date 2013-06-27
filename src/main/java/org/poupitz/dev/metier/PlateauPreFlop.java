package org.poupitz.dev.metier;

import org.poupitz.dev.model.Deck;
import org.poupitz.dev.model.Main;

public class PlateauPreFlop implements IPlateauPreFlop {

	/* ATTRIBUTS */
	private final Main main;
	private final Deck deck;

	/* CONSTRUCTEURS */
	public PlateauPreFlop(Main main, Deck deck) {
		super();
		this.main = main;
		this.deck = deck;
	}

	/* METHODES */

}
