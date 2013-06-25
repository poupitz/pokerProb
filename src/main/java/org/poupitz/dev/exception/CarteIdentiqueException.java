package org.poupitz.dev.exception;

public class CarteIdentiqueException extends Exception {

	private static final long serialVersionUID = 1801203244577045151L;

	/* CONSTRUCTEURS */
	public CarteIdentiqueException() {
	}

	public CarteIdentiqueException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CarteIdentiqueException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarteIdentiqueException(String message) {
		super(message);
	}

	public CarteIdentiqueException(Throwable cause) {
		super(cause);
	}

}
