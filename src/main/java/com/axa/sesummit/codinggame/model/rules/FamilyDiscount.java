package com.axa.sesummit.codinggame.model.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axa.sesummit.codinggame.model.QuoteModel;

public class FamilyDiscount implements QuoteRule {

	public static final Logger LOG = LoggerFactory.getLogger(FamilyDiscount.class);

	public static final Double DISCOUNT_FACTOR = 0.8;

	@Override
	public QuoteRule apply(QuoteModel model) {

		long countOfAdults = model.getTravellerAges().stream().filter(age -> age > 18).count();

		long countOfChildren = model.getTravellerAges().stream().filter(age -> age < 18).count();

		if (countOfAdults >= 2 && countOfChildren >= 2) {
			LOG.info("\tYou travel as a family?");
			model.addDiscount(DISCOUNT_FACTOR);
		}

		return this;
	}
}
