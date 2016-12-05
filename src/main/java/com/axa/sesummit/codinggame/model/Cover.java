package com.axa.sesummit.codinggame.model;

public enum Cover {

	Basic("Basic");

	private Cover(final String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}
	
}
