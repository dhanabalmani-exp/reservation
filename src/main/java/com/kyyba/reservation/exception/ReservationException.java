package com.kyyba.reservation.exception;

public class ReservationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3709619779021605709L;

	/**
	 * Default constructor
	 */
	public ReservationException() {
	}

	/**
	 * Constructor with "message" and "cause" parameters
	 *
	 * @param message
	 *            exception message
	 * @param cause
	 *            Throwable instance
	 */
	public ReservationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with "message" parameter
	 *
	 * @param message
	 *            exception message
	 */
	public ReservationException(String message) {
		super(message);
	}

	/**
	 * Constructor with "cause" parameter
	 *
	 * @param cause
	 *            Throwable instance
	 */
	public ReservationException(Throwable cause) {
		super(cause);
	}

}
