package com.axa.sesummit.codinggame.model;

public enum Cover {

	Basic("Basic", 1.8);

	private Cover(final String value, Double amount) {
		this.value = value;
		this.amount = amount;
	}

	private String value;

	private Double amount;

	public String getValue() {
		return value;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmount() {
		return amount;
	}

}
