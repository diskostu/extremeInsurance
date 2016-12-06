package com.axa.sesummit.codinggame.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

public class QuoteModel {

	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static final QuoteModel fromRequest(final QuoteRequest request) throws IllegalArgumentException {
		QuoteModel model = new QuoteModel();

		if (StringUtils.isEmpty(request.getCover())) {
			throw new IllegalArgumentException("No valid Cover supplied");
		}

		try {
			if (request.getTravellerAges().isEmpty()) {
				throw new IllegalArgumentException("No Travellers submitted!");
			}

			model.setTravellerAges(request.getTravellerAges());
			model.setDepartureDate(LocalDate.parse(request.getDepartureDate(), DATE_FORMAT));
			model.setReturnDate(LocalDate.parse(request.getReturnDate(), DATE_FORMAT));

			for (Country c : Country.values()) {
				if (c.getCountryCode().equalsIgnoreCase(request.getCountry())) {
					model.setCountry(request.getCountry());
					break;
				}
			}

			if (StringUtils.isEmpty(model.getCountry())) {
				throw new IllegalArgumentException("No matching country for " + request.getCountry());
			}

			model.setOptions(request.getOptions().stream().map((o) -> {
				return Option.valueOf(o);
			}).collect(Collectors.toList()));

			model.setCover(Cover.valueOf(request.getCover()));

		} catch (Throwable t) {
			throw new IllegalArgumentException("No valid model supplied: " + t.getMessage());
		}

		return model;
	}

	private String country;

	private LocalDate departureDate;

	private LocalDate returnDate;

	private List<Integer> travellerAges;

	private List<Option> options;

	private Cover cover;

	public QuoteModel() {

	}

	public QuoteModel(String country, LocalDate departureDate, LocalDate returnDate, List<Integer> travellerAges,
			List<Option> options, Cover cover) {
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

	public void setOptions(List<Option> options) {
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

	public final List<Option> getOptions() {
		return options;
	}

	public final Cover getCover() {
		return cover;
	}

	@Override
	public String toString() {
		return "QuoteRequest [country=" + country + ", departureDate=" + departureDate + ", returnDate=" + returnDate
				+ ", travellerAges=" + travellerAges + ", options=" + options + ", cover=" + cover + "]";
	}

}
