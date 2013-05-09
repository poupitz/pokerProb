package org.poupitz.dev.model;

public interface ICarte {

	@Override
	public int hashCode();

	public int compareTo(Object carte);

	@Override
	public boolean equals(Object carte);

}
