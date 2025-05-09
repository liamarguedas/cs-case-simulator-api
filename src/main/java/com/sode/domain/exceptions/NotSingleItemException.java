package com.sode.domain.exceptions;

public class NotSingleItemException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotSingleItemException(String msg) {
		super(msg);
	}

}
