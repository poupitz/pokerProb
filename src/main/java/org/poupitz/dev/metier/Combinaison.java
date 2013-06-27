package org.poupitz.dev.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.poupitz.dev.model.Carte;
import org.poupitz.dev.model.CouleurCarte;
import org.poupitz.dev.model.Main;
import org.poupitz.dev.model.Plateau;
import org.poupitz.dev.model.ValeurCarte;

public class Combinaison implements ICombinaison {

	/* ATTRIBUTS */
	private boolean isPaire = false;
	private boolean isDoublePaire = false;
	private boolean isBrelan = false;
	private boolean isFull = false;
	private boolean isCarre = false;
	private boolean isCouleur = false;

	// Pour ne jouer qu'une fois l'algo
	private boolean doublonCalc = false;

	/* METHODES */
	@Override
	public boolean isPaire(Main main, Plateau plateau) {
		if (!doublonCalc)
			combinaisonAvecDoublon(main, plateau);
		return this.isPaire;
	}

	@Override
	public boolean isDoublePaire(Main main, Plateau plateau) {
		if (!doublonCalc)
			combinaisonAvecDoublon(main, plateau);
		return this.isDoublePaire;
	}

	@Override
	public boolean isBrelan(Main main, Plateau plateau) {
		if (!doublonCalc)
			combinaisonAvecDoublon(main, plateau);
		return this.isBrelan;
	}

	@Override
	public boolean isSuite(Main main, Plateau plateau) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCouleur(Main main, Plateau plateau) {
		combinaisonCouleur(main, plateau);
		return this.isCouleur;
	}

	@Override
	public boolean isFull(Main main, Plateau plateau) {
		if (!doublonCalc)
			combinaisonAvecDoublon(main, plateau);
		return this.isFull;
	}

	@Override
	public boolean isCarre(Main main, Plateau plateau) {
		if (!doublonCalc)
			combinaisonAvecDoublon(main, plateau);
		return this.isCarre;
	}

	private void combinaisonAvecDoublon(Main main, Plateau plateau) {

		/* DECLARATION */
		List<ValeurCarte> cartes = new ArrayList<ValeurCarte>();
		HashSet<ValeurCarte> valeurCartes = new HashSet<ValeurCarte>();
		Map<ValeurCarte, Integer> nbre_cartesDoublonMemeValeur = new HashMap<ValeurCarte, Integer>();
		int nbre_doublon_valeur = 0;

		/* INITIALISATION */
		for (Carte carte : main.getCartes()) {

			cartes.add(carte.getValeur());

		}

		for (Carte carte : plateau.getCartes()) {

			cartes.add(carte.getValeur());

		}

		for (ValeurCarte valeurCarte : cartes) {

			if (!valeurCartes.add(valeurCarte)) {

				nbre_doublon_valeur++;

				if (nbre_cartesDoublonMemeValeur.get(valeurCarte) != null) {

					int val = nbre_cartesDoublonMemeValeur.get(valeurCarte);
					nbre_cartesDoublonMemeValeur.remove(valeurCarte);
					nbre_cartesDoublonMemeValeur.put(valeurCarte, val + 1);

				} else {
					nbre_cartesDoublonMemeValeur.put(valeurCarte, 1);
				}

			}

		}

		/* TRAITEMENT */
		int nbre_ValeurCartesDoublon = nbre_cartesDoublonMemeValeur.size();

		switch (nbre_doublon_valeur) {
		case 1:

			if (nbre_ValeurCartesDoublon == 1)
				this.isPaire = true;

			break;
		case 2:

			if (nbre_ValeurCartesDoublon == 1)
				this.isBrelan = true;

			if (nbre_ValeurCartesDoublon == 2)
				this.isDoublePaire = true;

			break;
		case 3:

			if (nbre_ValeurCartesDoublon == 1)
				this.isCarre = true;

			if (nbre_ValeurCartesDoublon == 2)
				this.isFull = true;

			if (nbre_ValeurCartesDoublon == 3)
				this.isDoublePaire = true;

			break;
		case 4:

			/*
			 * Dans ce cas il faut faire la différence entre carré + paire et
			 * brelan + brelan
			 */
			if (nbre_ValeurCartesDoublon == 2) {

				int val_max = 0;

				for (Map.Entry<ValeurCarte, Integer> val : nbre_cartesDoublonMemeValeur
						.entrySet()) {

					if (val.getValue() > val_max)
						val_max = val.getValue();

				}

				// val_max vaut soit 3 soit 2
				if (val_max == 3)
					this.isCarre = true;
				else
					this.isFull = true;

			}

			if (nbre_ValeurCartesDoublon == 3)
				this.isFull = true;

			break;
		case 5:
			this.isCarre = true;

		default:
			break;
		}

		this.doublonCalc = true;

	}

	/**
	 * Permet de déterminer si il y a une couleur possible parmis la combinaison
	 * d'une main et d'un plateau de 5 cartes.
	 * 
	 * @param main
	 * @param plateau
	 */
	private void combinaisonCouleur(Main main, Plateau plateau) {

		/* DECLARATION */
		List<CouleurCarte> cartes = new ArrayList<CouleurCarte>();
		HashSet<CouleurCarte> valeurCartes = new HashSet<CouleurCarte>();
		Map<CouleurCarte, Integer> nbre_cartesDoublonMemeCouleur = new HashMap<CouleurCarte, Integer>();
		int nbre_doublon_couleur = 0;

		/* INITIALISATION */
		for (Carte carte : main.getCartes()) {

			cartes.add(carte.getCouleur());

		}

		for (Carte carte : plateau.getCartes()) {

			cartes.add(carte.getCouleur());

		}

		for (CouleurCarte couleurCarte : cartes) {

			if (!valeurCartes.add(couleurCarte)) {

				nbre_doublon_couleur++;

				if (nbre_cartesDoublonMemeCouleur.get(couleurCarte) != null) {

					int col = nbre_cartesDoublonMemeCouleur.get(couleurCarte);
					nbre_cartesDoublonMemeCouleur.remove(couleurCarte);
					nbre_cartesDoublonMemeCouleur.put(couleurCarte, col + 1);

				} else {
					nbre_cartesDoublonMemeCouleur.put(couleurCarte, 1);
				}

			}

		}

		/* TRAITEMENT */

		if (nbre_doublon_couleur > 3) {
			int col_max = 0;

			for (Map.Entry<CouleurCarte, Integer> col : nbre_cartesDoublonMemeCouleur
					.entrySet()) {

				if (col.getValue() > col_max)
					col_max = col.getValue();

			}

			if (col_max >= 4)
				this.isCouleur = true;

		}
	}
}
