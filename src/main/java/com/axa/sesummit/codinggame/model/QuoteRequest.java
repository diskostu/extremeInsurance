package com.axa.sesummit.codinggame.model;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
public class QuoteRequest {

	private String country;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate departureDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate returnDate;

	private List<Integer> travellerAges;

	private List<String> options;

	private Cover cover;

	public QuoteRequest() {

	}

	public QuoteRequest(String country, LocalDate departureDate, LocalDate returnDate, List<Integer> travellerAges,
			List<String> options, Cover cover) {
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

	public void setCover(final Cover cover) {
		this.cover = cover;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public void setTravellerAges(List<Integer> travellerAges) {
		this.travellerAges = travellerAges;
	}

	public final String getCountry() {
		return country;
	}

	public final LocalDate getDepartureDate() {
		return departureDate;
	}

	public final LocalDate getReturnDate() {
		return returnDate;
	}

	public final List<Integer> getTravellerAges() {
		return travellerAges;
	}

	public final List<String> getOptions() {
		return options;
	}

	public final Cover getCover() {
		return cover;
	}

}
