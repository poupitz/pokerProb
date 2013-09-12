package org.poupitz.dev.metier;

import org.poupitz.dev.exception.CarteIdentiqueException;
import org.poupitz.dev.exception.NombreCarteException;
import org.poupitz.dev.model.Carte;
import org.poupitz.dev.model.Deck;
import org.poupitz.dev.model.Main;
import org.poupitz.dev.model.Plateau;

public class Calcul implements ICalcul {

	/* ATTRIBUTS */
	private final Main main;
	private final Deck deck;

	private int compteurQuinteFlush = 0;
	private int compteurCarre = 0;
	private int compteurFull = 0;
	private int compteurFlush = 0;
	private int compteurSuite = 0;
	private int compteurBrelan = 0;
	private int compteurDoublePaire = 0;
	private int compteurPaire = 0;
	private int compteurKicker = 0;
	private int compteurTot = 0;

	/* CONSTRUCTEURS */
	public Calcul(Main main, Deck deck) {
		super();
		this.main = main;
		this.deck = deck;

		for (Carte carte : main.getCartes()) {

			this.deck.removeCarte(carte);
		}
	}

	/* METHODES */
	@Override
	public void preFlop() throws CarteIdentiqueException, NombreCarteException {

		int nbCartes = this.deck.getDeck().size();
		// int nbCartes = 6;

		compteurQuinteFlush = 0;
		compteurCarre = 0;
		compteurFull = 0;
		compteurFlush = 0;
		compteurSuite = 0;
		compteurBrelan = 0;
		compteurDoublePaire = 0;
		compteurPaire = 0;
		compteurKicker = 0;
		compteurTot = 0;

		for (int i = 0; i <= nbCartes - 4; i++) {

			for (int j = i + 1; j < nbCartes - 3; j++) {

				for (int k = j + 1; k < nbCartes - 2; k++) {

					for (int l = k + 1; l < nbCartes - 1; l++) {

						for (int m = l + 1; m < nbCartes; m++) {

							compteurTot++;

							Plateau plat = new Plateau();
							plat.ajouterCarte(this.deck.getDeck().get(i));
							plat.ajouterCarte(this.deck.getDeck().get(j));
							plat.ajouterCarte(this.deck.getDeck().get(k));
							plat.ajouterCarte(this.deck.getDeck().get(l));
							plat.ajouterCarte(this.deck.getDeck().get(m));

							calculerCombinaison(main, plat);
						}

					}

				}

			}
		}

		System.out.println("Sur  : " + compteurTot
				+ " possibilités de tirages, il y a ");
		System.out.println("- " + compteurQuinteFlush + " quintes flush, soit "
				+ (double) 100 * compteurQuinteFlush / compteurTot + " %");
		System.out.println("- " + compteurCarre + " carrés, soit "
				+ (double) 100 * compteurCarre / compteurTot + " %");
		System.out.println("- " + compteurFull + " fulls, soit " + (double) 100
				* compteurFull / compteurTot + " %");
		System.out.println("- " + compteurFlush + " flushs, soit "
				+ (double) 100 * compteurFlush / compteurTot + " %");
		System.out.println("- " + compteurSuite + " suites, soit "
				+ (double) 100 * compteurSuite / compteurTot + " %");
		System.out.println("- " + compteurBrelan + " brelans, soit "
				+ (double) 100 * compteurBrelan / compteurTot + " %");
		System.out.println("- " + compteurDoublePaire
				+ " doubles paires, soit " + (double) 100 * compteurDoublePaire
				/ compteurTot + " %");
		System.out.println("- " + compteurPaire + " paires, soit "
				+ (double) 100 * compteurPaire / compteurTot + " %");
		System.out.println("- " + compteurKicker + " kickers, soit "
				+ (double) 100 * compteurKicker / compteurTot + " %");

	}

	@Override
	public void flop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void river() {
		// TODO Auto-generated method stub

	}

	@Override
	public void calculerCombinaison(Main main, Plateau plat) {

		Combinaison comb = new Combinaison();

		if (comb.isCouleur(main, plat) && comb.isSuite(main, plat))
			compteurQuinteFlush++;
		else if (comb.isCarre(main, plat))
			compteurCarre++;
		else if (comb.isFull(main, plat))
			compteurFull++;
		else if (comb.isCouleur(main, plat))
			compteurFlush++;
		else if (comb.isSuite(main, plat))
			compteurSuite++;
		else if (comb.isBrelan(main, plat))
			compteurBrelan++;
		else if (comb.isDoublePaire(main, plat))
			compteurDoublePaire++;
		else if (comb.isPaire(main, plat))
			compteurPaire++;
		else
			compteurKicker++;

	}

}
