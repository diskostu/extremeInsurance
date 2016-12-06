package com.axa.sesummit.codinggame.model.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axa.sesummit.codinggame.model.QuoteModel;

public class YoungGroupDiscount implements QuoteRule {

	public static final Logger LOG = LoggerFactory.getLogger(YoungGroupDiscount.class);

	public static final Double DISCOUNT_FACTOR = 0.9;

	@Override
	public QuoteRule apply(QuoteModel model) {

		long count = model.getTravellerAges().stream().filter(age -> age >= ADULT_AGE && age <= YOUNG_AGE).count();

		if (count >= 5) {
			model.addDiscount(DISCOUNT_FACTOR);
			LOG.info("\tYeah, a young adult group?");
		}

		return this;
	}
}
