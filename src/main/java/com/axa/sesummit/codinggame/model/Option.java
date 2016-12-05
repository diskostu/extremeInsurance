package com.axa.sesummit.codinggame.model;

public enum Option {

	Skiing("Skiing", 24.0), Medical("Medical", 72.0), Medicalconditions("Medicalconditions", 72.0), Scuba("Scuba",
			36.0), Sports("Sports", 25.0), SportsAndActivities("SportsAndActivities", 25.0), Yoga("Yoga", -3.0);

	private Option(final String value, Double amount) {
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
