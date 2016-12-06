package com.axa.sesummit.codinggame.services;

import com.axa.sesummit.codinggame.model.Country;
import com.axa.sesummit.codinggame.model.QuoteModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
		final List<Integer> travellerAges = request.getTravellerAges();

		long dateDiff = Math.abs(ChronoUnit.DAYS.between(returnDate, departure));

		Double sumOfRisks = 0.0;


		for (int age : travellerAges) {
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

		if (getFamilyDiscount(travellerAges)) {
			result = result * 0.8; // 20% Discount for Families
		}

		if (isChildrenCharge(travellerAges)) {
			result = result * 1.15; // 15% Family charges
		}

		if (isYoungCouples(travellerAges) || isYoungAdultGroup(travellerAges)) {
			result = result * 0.9; // 10% for young couples
		}

		if (isAlone(travellerAges)) {
			result = result * 1.05; // 5% penalty for single person
		}

		return result;
	}

	public boolean getFamilyDiscount(List<Integer> ageList) {
		long countOfAdults = ageList.stream().filter(age -> age > 18).count();

		long countOfChildren = ageList.stream().filter(age -> age < 18).count();

		if (countOfAdults >= 2 && countOfChildren >= 2) {
			LOG.info("\tYou travel as a family?");
			return true;
		}

		return false;
	}

	public boolean isChildrenCharge(List<Integer> ageList) {
		long countOfAdults = ageList.stream().filter(age -> age > 18).count();

		long countOfChildren = ageList.stream().filter(age -> age < 18).count();

		if (countOfAdults < countOfChildren) {
			LOG.info("\tYou are charge because of too much children?");
			return true;
		}

		return false;
	}

	public boolean isYoungCouples(List<Integer> ageList) {
		long countOfYoungCouples = ageList.stream().filter(age -> age >= 18 && age <= 24).count();

		if (countOfYoungCouples == 2) {
			LOG.info("\tYeah, young couple?");
			return true;
		}

		return false;
	}

	public boolean isYoungAdultGroup(List<Integer> ageList) {
		long countOfYoungCouples = ageList.stream().filter(age -> age >= 18 && age <= 24).count();

		if (countOfYoungCouples >= 5) {
			LOG.info("\tYeah, a young adult group?");
			return true;
		}

		return false;
	}

	public boolean isAlone(List<Integer> ageList) {
		if (ageList.size() == 1) {
			LOG.info("\tA lone traveller!");
			return true;
		}

		return false;
	}
}
