package org.poupitz.dev.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestDeck {

	@Test
	public void testGenererDeck() {

		Deck deck = new Deck();

		assertTrue(deck.getDeck().size() == 52);

	}

	@Test
	public void testMelangerDeck() {

		Deck deck_1 = new Deck();
		Deck deck_2 = new Deck();

		assertTrue(deck_1.equals(deck_2));

		deck_2.melangerDeck();

		assertTrue(!deck_1.equals(deck_2));

	}

}
