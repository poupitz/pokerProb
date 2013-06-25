package org.poupitz.dev.model;

import org.poupitz.dev.exception.CarteIdentiqueException;

public class Main implements IMain {

	/* ATTRIBUTS */
	private final Carte carte_1;
	private final Carte carte_2;

	/* CONSTRUCTEUR */
	public Main(Carte carte_1, Carte carte_2) throws CarteIdentiqueException {
		if (!carte_1.equals(carte_2)) {

			this.carte_1 = carte_1;
			this.carte_2 = carte_2;

		} else {
			throw new CarteIdentiqueException(
					"[Erreur] : Les deux cartes de la main sont identiques");
		}
	}

	/* METHODES SURCHARGEES */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carte_1 == null) ? 0 : carte_1.hashCode());
		result = prime * result + ((carte_2 == null) ? 0 : carte_2.hashCode());
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
		Main other = (Main) obj;
		if (carte_1 == null) {
			if (other.carte_1 != null)
				return false;
		} else if (!carte_1.equals(other.carte_1))
			return false;
		if (carte_2 == null) {
			if (other.carte_2 != null)
				return false;
		} else if (!carte_2.equals(other.carte_2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Main [carte_1=" + carte_1 + ", carte_2=" + carte_2 + "]";
	}

	/* GETTERS ET SETTERS */
	public Carte getCarte_1() {
		return carte_1;
	}

	public Carte getCarte_2() {
		return carte_2;
	}

}
