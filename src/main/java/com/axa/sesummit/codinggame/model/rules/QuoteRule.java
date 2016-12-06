package com.axa.sesummit.codinggame.model.rules;

import com.axa.sesummit.codinggame.model.QuoteModel;

@FunctionalInterface
public interface QuoteRule {

	public static final int ADULT_AGE = 18;
	
	public static final int YOUNG_AGE = 24;

	QuoteRule apply(final QuoteModel model);

	default QuoteModel build(final QuoteModel model) {
		return model;
	};
}
