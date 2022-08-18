package com.realestate.property.exceptions;

public class PropertyNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public PropertyNotFoundException(String message) {
		super(message);
	}
}
