package org.poupitz.dev.metier;

import org.poupitz.dev.exception.CarteIdentiqueException;
import org.poupitz.dev.exception.NombreCarteException;
import org.poupitz.dev.model.Main;
import org.poupitz.dev.model.Plateau;

public interface ICalcul {

	public void preFlop() throws CarteIdentiqueException, NombreCarteException;

	public void flop();

	public void turn();

	public void river();

	public void calculerCombinaison(Main main, Plateau plateau);

}
