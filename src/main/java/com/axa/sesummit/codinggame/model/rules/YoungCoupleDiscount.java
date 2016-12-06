package com.axa.sesummit.codinggame.model.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axa.sesummit.codinggame.model.QuoteModel;

public class YoungCoupleDiscount implements QuoteRule {

	public static final Logger LOG = LoggerFactory.getLogger(YoungCoupleDiscount.class);

	public static final Double DISCOUNT_FACTOR = 0.9;

	@Override
	public QuoteRule apply(QuoteModel model) {

		long countOfYoungCouples = model.getTravellerAges().stream().filter(age -> age >= ADULT_AGE && age <= YOUNG_AGE)
				.count();

		if (countOfYoungCouples == 2) {
			model.addDiscount(DISCOUNT_FACTOR);
			LOG.info("\tYeah, a young couple?");
		}

		return this;
	}
}
