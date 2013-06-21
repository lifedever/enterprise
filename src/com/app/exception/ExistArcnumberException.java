package com.app.exception;

import com.sqds.exception.SqdsException;

public class ExistArcnumberException extends SqdsException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExistArcnumberException() {
		super();
	}

	public ExistArcnumberException(String exception) {
		super(exception);
	}
}
