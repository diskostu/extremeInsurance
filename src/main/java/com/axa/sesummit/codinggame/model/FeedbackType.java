package com.axa.sesummit.codinggame.model;

public enum FeedbackType {

	WIN("WIN"), LOOSE("LOOSE"), ERROR("ERROR");

	private FeedbackType(final String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}
}
