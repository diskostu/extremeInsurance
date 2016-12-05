package com.axa.sesummit.codinggame.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuoteRequest {

	private String country;

	private String departureDate;

	private String returnDate;

	private List<Integer> travellerAges;

	private List<String> options;

	private String cover;

	public QuoteRequest() {

	}

	public QuoteRequest(String country, String departureDate, String returnDate, List<Integer> travellerAges,
			List<String> options, String cover) {
		this.country = country;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.travellerAges = travellerAges;
		this.options = options;
		this.cover = cover;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public void setTravellerAges(List<Integer> travellerAges) {
		this.travellerAges = travellerAges;
	}

	public final String getCountry() {
		return country;
	}

	public final String getDepartureDate() {
		return departureDate;
	}

	public final String getReturnDate() {
		return returnDate;
	}

	public final List<Integer> getTravellerAges() {
		return travellerAges;
	}

	public final List<String> getOptions() {
		return options;
	}

	public final String getCover() {
		return cover;
	}

}
