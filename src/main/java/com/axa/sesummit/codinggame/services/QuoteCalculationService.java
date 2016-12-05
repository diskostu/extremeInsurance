package com.axa.sesummit.codinggame.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.axa.sesummit.codinggame.model.QuoteRequest;

@Service
public class QuoteCalculationService {

	public static final Double QUOTE_CONSTANT = 1.8;

	public String calculateQuote(final QuoteRequest request) {
		int numberOfTravellers = request.getTravellerAges().size();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate departure = LocalDate.parse(request.getDepartureDate(), formatter);

		LocalDate returnDate = LocalDate.parse(request.getReturnDate(), formatter);

		long dateDiff = Math.abs(ChronoUnit.DAYS.between(returnDate, departure));

		Double result = QUOTE_CONSTANT * numberOfTravellers * dateDiff;

		return result.toString();
	}
}
