package org.poupitz.dev.model;

public class Carte implements Comparable<Object> {

	/* ATTRIBUTS */
	private ValeurCarte valeur;
	private CouleurCarte couleur;

	/* CONSTRUCTEUR */
	public Carte(ValeurCarte valeur, CouleurCarte couleur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}

	/* METHODES */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
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
		Carte other = (Carte) obj;
		if (couleur != other.couleur)
			return false;
		if (valeur != other.valeur)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carte [valeur=" + valeur + ", couleur=" + couleur + "]";
	}

	/**
	 * Ne compare que la valeur des cartes.
	 */
	@Override
	public int compareTo(Object carte) {

		return this.getValeur().compareTo(((Carte) carte).getValeur());
	}

	/* GETTERS ET SETTERS */
	public ValeurCarte getValeur() {
		return valeur;
	}

	public void setValeur(ValeurCarte valeur) {
		this.valeur = valeur;
	}

	public CouleurCarte getCouleur() {
		return couleur;
	}

	public void setCouleur(CouleurCarte couleur) {
		this.couleur = couleur;
	}

}
