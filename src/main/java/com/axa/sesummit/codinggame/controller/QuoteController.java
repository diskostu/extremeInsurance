package com.axa.sesummit.codinggame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.axa.sesummit.codinggame.model.QuoteModel;
import com.axa.sesummit.codinggame.model.QuoteRequest;
import com.axa.sesummit.codinggame.model.QuoteResponse;
import com.axa.sesummit.codinggame.services.QuoteCalculationService;

@RestController
@RequestMapping("/quote")
public class QuoteController {

	public static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);

	private QuoteCalculationService qcs;

	@Autowired
	public QuoteController(final QuoteCalculationService qcs) {
		this.qcs = qcs;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody QuoteResponse getQuote(@RequestBody final QuoteRequest request)
			throws IllegalArgumentException {
		LOG.info("Incoming request: " + request.toString());

		QuoteModel model = QuoteModel.fromRequest(request);

		QuoteResponse response = new QuoteResponse();

		Double quote = qcs.calculateQuote(model);

		response.setQuote(quote);

		return response;
	}
}
