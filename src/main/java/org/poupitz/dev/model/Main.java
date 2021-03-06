package org.poupitz.dev.model;

import java.util.HashSet;

import org.poupitz.dev.exception.CarteIdentiqueException;
import org.poupitz.dev.exception.NombreCarteException;

public class Main {

	/* ATTRIBUTS */
	private final HashSet<Carte> cartes;

	/* CONSTRUCTEURS */
	public Main() {
		cartes = new HashSet<Carte>();
	}

	/* METHODES */
	public void ajouterCarte(Carte carte) throws CarteIdentiqueException,
			NombreCarteException {
		if (!cartes.add(carte))
			throw new CarteIdentiqueException(
					"Les deux cartes de la main sont identiques.");

		if (cartes.size() > 2) {
			throw new NombreCarteException(
					"Il ne peut pas y avoir plus de deux cartes dans une main.");

		}
	}

	@Override
	public String toString() {
		return "Main [cartes=" + cartes + "]";
	}

	/* GETTERS ET SETTERS */
	public HashSet<Carte> getCartes() {
		return cartes;
	}
}
