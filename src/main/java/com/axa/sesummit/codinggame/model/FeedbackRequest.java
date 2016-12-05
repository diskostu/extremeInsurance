package com.axa.sesummit.codinggame.model;

public class FeedbackRequest {

	String message = "Congrats Cyriux: ...";

	FeedbackType type;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FeedbackType getType() {
		return type;
	}

	public void setType(FeedbackType type) {
		this.type = type;
	}

}
