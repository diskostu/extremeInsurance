package com.axa.sesummit.codinggame.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.axa.sesummit.codinggame.model.QuoteRequest;

@Service
public class QuoteCalculationService {

	public static final Double QUOTE_CONSTANT = 1.8;

	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public Double calculateQuote(final QuoteRequest request) {
		int numberOfTravellers = request.getTravellerAges().size();

		LocalDate departure = LocalDate.parse(request.getDepartureDate(), FORMATTER);

		LocalDate returnDate = LocalDate.parse(request.getReturnDate(), FORMATTER);

		long dateDiff = Math.abs(ChronoUnit.DAYS.between(returnDate, departure));

		Double result = QUOTE_CONSTANT * numberOfTravellers * dateDiff;

		return result;
	}
}
