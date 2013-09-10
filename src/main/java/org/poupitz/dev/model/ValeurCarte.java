package org.poupitz.dev.model;

public enum ValeurCarte {

	DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, AS;

	public ValeurCarte getNext() {
		return this.ordinal() < ValeurCarte.values().length - 1 ? ValeurCarte
				.values()[this.ordinal() + 1] : null;
	}
}
