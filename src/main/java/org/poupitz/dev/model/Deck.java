package org.poupitz.dev.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	/* ATTRIBUTS */
	private List<Carte> deck = null;

	/* CONSTRUCTEUR */
	public Deck() {

		this.deck = new ArrayList<Carte>();
		genererDeck();
	}

	/* METHODES */
	public void genererDeck() {

		for (CouleurCarte couleur : CouleurCarte.values()) {

			for (ValeurCarte valeur : ValeurCarte.values()) {

				this.deck.add(new Carte(valeur, couleur));

			}

		}

		// System.out.println("Taille du deck : " + this.getDeck().size());
		// System.out.println("Deck après génération");
		// System.out.println(this.toString());

	}

	public void melangerDeck() {

		Collections.shuffle(this.getDeck());

		// System.out.println(("Deck après mélange"));
		// System.out.println(this.toString());

	}

	public void removeCarte(Carte carte) {

		this.deck.remove(carte);

	}

	/* MEHTODES SURCHARGEES */
	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deck == null) ? 0 : deck.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (deck == null) {
			if (other.deck != null)
				return false;
		} else if (!deck.equals(other.deck))
			return false;
		return true;
	}

	/* GETTERS ET SETTERS */
	public List<Carte> getDeck() {
		return deck;
	}

}
