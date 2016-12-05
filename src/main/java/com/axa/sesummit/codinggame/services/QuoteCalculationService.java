package com.axa.sesummit.codinggame.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.sesummit.codinggame.model.Option;
import com.axa.sesummit.codinggame.model.QuoteRequest;

@Service
public class QuoteCalculationService {

	public static final Logger LOG = LoggerFactory.getLogger(QuoteCalculationService.class);

	public static final Double QUOTE_CONSTANT = 1.8;

	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private AgeToRiskService ageToRiskService;

	@Autowired
	public QuoteCalculationService(final AgeToRiskService ageToRiskService) {
		this.ageToRiskService = ageToRiskService;
	}

	public Double calculateQuote(final QuoteRequest request) {
		// int numberOfTravellers = request.getTravellerAges().size();

		LocalDate departure = request.getDepartureDate();
		LocalDate returnDate = request.getReturnDate();

		long dateDiff = Math.abs(ChronoUnit.DAYS.between(returnDate, departure));

		int sumOfRisks = request.getTravellerAges().stream().mapToInt(Integer::intValue).sum();

		Double sumOfOptions = request.getOptions().stream().mapToDouble((s) -> Option.valueOf(s).getAmount()).sum();
		// LOG.info(sumOfRisks + " - " + sumOfOptions);
		// Options

		// Country and Options
		Double result = (request.getCover().getAmount() * 22.0 * sumOfRisks * dateDiff) + sumOfOptions;

		return result;
	}

}
