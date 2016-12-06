package com.axa.sesummit.codinggame.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.sesummit.codinggame.model.Country;
import com.axa.sesummit.codinggame.model.QuoteModel;
import com.axa.sesummit.codinggame.model.rules.FamilyDiscount;
import com.axa.sesummit.codinggame.model.rules.LargeFamilyFee;
import com.axa.sesummit.codinggame.model.rules.QuoteRule;
import com.axa.sesummit.codinggame.model.rules.SingleFee;
import com.axa.sesummit.codinggame.model.rules.YoungCoupleDiscount;
import com.axa.sesummit.codinggame.model.rules.YoungGroupDiscount;

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

	public Double calculateQuote(final QuoteModel request) {
		// int numberOfTravellers = request.getTravellerAges().size();

		LOG.info("Request for quote: " + request);

		LocalDate departure = request.getDepartureDate();
		LocalDate returnDate = request.getReturnDate();

		long dateDiff = Math.abs(ChronoUnit.DAYS.between(returnDate, departure));

		Double sumOfRisks = 0.0;

		for (int age : request.getTravellerAges()) {
			Double risk = ageToRiskService.getRiskForAge(age);

			LOG.info("\tRISK: " + risk);

			sumOfRisks += risk;
		}

		Double sumOfOptions = request.getOptions().stream().mapToDouble((s) -> s.getAmount()).sum();

		Double country = Country.getValueForCode(request.getCountry());

		if (dateDiff <= 7) {
			dateDiff = 7;
		}

		if (dateDiff == 8 || dateDiff == 9) {
			dateDiff = 7;
		}

		LOG.info("Cover: " + request.getCover().getAmount());
		LOG.info("Country:" + country);
		LOG.info("SumOfRisks: " + sumOfRisks);
		LOG.info("Diff: " + dateDiff);
		LOG.info("SumOfOptions: " + sumOfOptions);
		LOG.info("Country: " + request.getCountry());

		Double result = (request.getCover().getAmount() * country * sumOfRisks * dateDiff) + sumOfOptions;

		applyRules(request);

		for (Double d : request.getDiscounts()) {
			result = result * d;
		}

		return result;
	}

	public void applyRules(QuoteModel model) {

		List<QuoteRule> rules = Arrays.asList(new FamilyDiscount(), new LargeFamilyFee(), new YoungCoupleDiscount(),
				new YoungGroupDiscount(), new SingleFee());

		rules.forEach((r) -> r.apply(model));
	}
}
