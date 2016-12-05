package com.axa.sesummit.codinggame.model;

import org.junit.Assert;
import org.junit.Test;

public class CountryTest {
    @Test
    public void validTest1() {
        Assert.assertEquals(0.8, Country.getValueForCode("DE"), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidTest1() {
        Country.getValueForCode("XXX");
    }
}