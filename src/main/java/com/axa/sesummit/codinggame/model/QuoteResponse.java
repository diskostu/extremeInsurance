package com.axa.sesummit.codinggame.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuoteResponse {

	private Double quote;
	
	public QuoteResponse () {
		
	}

	public QuoteResponse(final Double quote) {
		this.quote = quote;
	}

	public Double getQuote() {
		return quote;
	}

	public void setQuote(Double quote) {
		this.quote = quote;
	}
}
