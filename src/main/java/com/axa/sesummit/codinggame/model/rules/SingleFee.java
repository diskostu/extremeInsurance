package com.axa.sesummit.codinggame.model.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axa.sesummit.codinggame.model.QuoteModel;

public class SingleFee implements QuoteRule {

	public static final Logger LOG = LoggerFactory.getLogger(SingleFee.class);

	public static final Double DISCOUNT_FACTOR = 1.05;

	@Override
	public QuoteRule apply(QuoteModel model) {
		if (model.getTravellerAges().size() == 1) {
			LOG.info("\tYou travel alone - poor single!");
			model.addDiscount(DISCOUNT_FACTOR);
		}

		return this;
	}
}
