package org.poupitz.dev.metier;

import org.poupitz.dev.model.Main;
import org.poupitz.dev.model.Plateau;

public interface ICombinaison {

	public boolean isPaire(Main main, Plateau plateau);

	public boolean isDoublePaire(Main main, Plateau plateau);

	public boolean isBrelan(Main main, Plateau plateau);

	public boolean isSuite(Main main, Plateau plateau);

	public boolean isCouleur(Main main, Plateau plateau);

	public boolean isFull(Main main, Plateau plateau);

	public boolean isCarre(Main main, Plateau plateau);

}
