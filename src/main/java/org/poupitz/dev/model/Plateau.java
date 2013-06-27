package org.poupitz.dev.model;

import java.util.HashSet;

import org.poupitz.dev.exception.CarteIdentiqueException;
import org.poupitz.dev.exception.NombreCarteException;

public class Plateau {

	/* ATTRIBUTS */
	private final HashSet<Carte> cartes;

	/* CONSTRUCTEUR */
	public Plateau() {
		cartes = new HashSet<Carte>();
	}

	/* METHODES */
	public void ajouterCarte(Carte carte) throws CarteIdentiqueException,
			NombreCarteException {
		if (!cartes.add(carte))
			throw new CarteIdentiqueException(
					"Au moins deux cartes sont identiques dans ce plateau.");

		if (cartes.size() > 5)
			throw new NombreCarteException(
					"Il ne peut pas y avoir plus de cinq cartes dans un plateau.");
	}

	@Override
	public String toString() {
		return "Plateau [cartes=" + cartes + "]";
	}

	/* GETTERS ET SETTERS */
	public HashSet<Carte> getCartes() {
		return cartes;
	}
}
