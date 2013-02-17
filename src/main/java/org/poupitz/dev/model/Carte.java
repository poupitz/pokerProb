package org.poupitz.dev.model;

/**
 * The Class Carte.
 *
 * @author Vincent
 */
public class Carte implements Comparable<Object>{
	
	/** The valeur. */
	private String valeur;
	
	/** The couleur. */
	private String couleur;
	
	/**
	 * Instantiates a new carte.
	 *
	 * @param valeur the valeur
	 * @param couleur the couleur
	 */
	public Carte(String valeur, String couleur){
		this.valeur = valeur;
		this.couleur = couleur;
	}
	
	
	/**
	 * Gets the valeur.
	 *
	 * @return the valeur
	 */
	public String getValeur() {
		return valeur;
	}
	
	/**
	 * Sets the valeur.
	 *
	 * @param valeur the new valeur
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	/**
	 * Gets the couleur.
	 *
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}
	
	/**
	 * Sets the couleur.
	 *
	 * @param couleur the new couleur
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	/**
	 * Decris l'objet carte
	 * @return La couleur et la valeur de la carte
	 */
	@Override
	public String toString(){
		
		return "Cette carte est " + this.getValeur() + " de " + this.getCouleur();
		
	}
	
	
	/**
	 * Définit si il y a une égalité entre deux carte.
	 *
	 * @param carte the carte
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object carte){
		
		if(!(carte instanceof Carte)){
			return false;
		}
		
		if((this.getCouleur().equals(((Carte)carte).getCouleur())) && (this.getValeur().equals(((Carte)carte).getValeur())) ){
			return true;
		}
		else {
			return false;
		}
				
	}
	
	@Override
	public int hashCode() {
		
		return 13*valeur.hashCode() + 4*couleur.hashCode();
	}


	
	// TODO A definir quand enum ordonancé mis en place
	public int compareTo(Object carte) {
		return 0;
	}

}

