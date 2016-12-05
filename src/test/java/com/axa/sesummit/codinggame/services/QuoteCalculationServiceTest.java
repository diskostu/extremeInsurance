package com.axa.sesummit.codinggame.services;

import com.axa.sesummit.codinggame.model.QuoteRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuoteCalculationServiceTest {

    /**
     * The input is the same as in the first example here: https://github.com/arolla/Extreme-Insurance/blob/master/README.md
     */
    @Test
    public void calculateQuote() throws Exception {
        final String country = "DE";
        final String departureDate = "2016-11-15";
        final String returnDate = "2016-12-15";
        final Integer[] travellerAges = {32, 39};
        final String[] options = {"MedicalConditions"};
        final String cover = "Basic";

        final QuoteRequest request = new QuoteRequest(country, departureDate, returnDate, Arrays.asList(travellerAges), Arrays.asList(options), cover);

        final String result = new QuoteCalculationService().calculateQuote(request);
        Assert.assertEquals("108.0", result);
    }
}