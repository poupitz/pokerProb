package org.poupitz.dev.metier;

import java.util.HashSet;

import org.poupitz.dev.model.Carte;
import org.poupitz.dev.model.Main;
import org.poupitz.dev.model.Plateau;
import org.poupitz.dev.model.ValeurCarte;

public class Combinaison implements ICombinaison {

	@Override
	public boolean isPaire(Main main, Plateau plateau) {

		HashSet<ValeurCarte> cartes = new HashSet<ValeurCarte>();

		for (Carte carte : main.getCartes()) {

			cartes.add(carte.getValeur());

		}

		for (Carte carte : plateau.getCartes()) {

			cartes.add(carte.getValeur());

		}

		if (cartes.size() == 6)
			return true;
		else
			return false;
	}

	@Override
	public boolean isDoublePaire(Main main, Plateau plateau) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBrelan(Main main, Plateau plateau) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSuite(Main main, Plateau plateau) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCouleur(Main main, Plateau plateau) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull(Main main, Plateau plateau) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCarre(Main main, Plateau plateau) {
		// TODO Auto-generated method stub
		return false;
	}

}
