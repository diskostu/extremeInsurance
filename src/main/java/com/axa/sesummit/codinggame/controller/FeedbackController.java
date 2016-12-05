package com.axa.sesummit.codinggame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.axa.sesummit.codinggame.model.FeedbackRequest;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	public static final Logger LOG = LoggerFactory.getLogger(FeedbackController.class);

	@RequestMapping(consumes = "application/json")
	public @ResponseBody String receiveFeedback(@RequestBody FeedbackRequest request) {
		LOG.info("Received request: " + request.getMessage() + " - " + request.getType().getValue());

		return "Propellerheads";
	}

}
