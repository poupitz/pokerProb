package org.poupitz.dev.model;

/**
 * The Class Carte.
 * 
 */
public class Carte implements ICarte, Comparable<Object> {

	/** The valeur. */
	private ValeurCarte valeur;

	/** The couleur. */
	private CouleurCarte couleur;

	/**
	 * Instantiates a new carte.
	 * 
	 * @param valeur
	 *            the valeur
	 * @param couleur
	 *            the couleur
	 */
	public Carte(ValeurCarte valeur, CouleurCarte couleur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}

	/**
	 * Gets the valeur.
	 * 
	 * @return the valeur
	 */
	public ValeurCarte getValeur() {
		return valeur;
	}

	/**
	 * Sets the valeur.
	 * 
	 * @param valeur
	 *            the new valeur
	 */
	public void setValeur(ValeurCarte valeur) {
		this.valeur = valeur;
	}

	/**
	 * Gets the couleur.
	 * 
	 * @return the couleur
	 */
	public CouleurCarte getCouleur() {
		return couleur;
	}

	/**
	 * Sets the couleur.
	 * 
	 * @param couleur
	 *            the new couleur
	 */
	public void setCouleur(CouleurCarte couleur) {
		this.couleur = couleur;
	}

	/**
	 * Decris l'objet carte
	 * 
	 * @return La couleur et la valeur de la carte
	 */
	@Override
	public String toString() {

		return "Cette carte est " + this.getValeur() + " de "
				+ this.getCouleur();

	}

	/**
	 * Définit si il y a une égalité entre deux carte.
	 * 
	 * @param carte
	 *            the carte
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object carte) {

		if (!(carte instanceof Carte)) {
			return false;
		}

		if ((this.getCouleur().equals(((Carte) carte).getCouleur()))
				&& (this.getValeur().equals(((Carte) carte).getValeur()))) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {

		return 13 * valeur.hashCode() + 4 * couleur.hashCode();
	}

	/**
	 * Ne compare que la valeur des cartes.
	 */
	@Override
	public int compareTo(Object carte) {

		int result = this.getValeur().compareTo(((Carte) carte).getValeur());

		if (result < 0) {

			System.out
					.println("La première carte est de valeur inférieure à la deuxième.");

		} else if (result > 0) {

			System.out
					.println("La première carte est de valeur supérieure à la deuxième.");

		} else if (result == 0) {

			System.out.println("Les deux cartes sont de même valeur.");

		}

		return result;
	}

}
