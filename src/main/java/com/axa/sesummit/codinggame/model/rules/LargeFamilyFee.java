package com.axa.sesummit.codinggame.model.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axa.sesummit.codinggame.model.QuoteModel;

public class LargeFamilyFee implements QuoteRule {

	public static final Logger LOG = LoggerFactory.getLogger(LargeFamilyFee.class);

	public static final Double DISCOUNT_FACTOR = 1.15;

	@Override
	public QuoteRule apply(QuoteModel model) {

		long countOfAdults = model.getTravellerAges().stream().filter(age -> age > ADULT_AGE).count();

		long countOfChildren = model.getTravellerAges().stream().filter(age -> age < ADULT_AGE).count();

		if (countOfAdults < countOfChildren) {
			LOG.info("\tYou are charge because of too much children?");
			model.addDiscount(DISCOUNT_FACTOR);
		}

		return this;
	}
}
