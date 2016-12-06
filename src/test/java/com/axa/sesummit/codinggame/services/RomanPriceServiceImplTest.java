package com.axa.sesummit.codinggame.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.axa.sesummit.codinggame.TravelInsuranceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TravelInsuranceApplication.class)
public class RomanPriceServiceImplTest {

	@Autowired
	private RomanPriceService service;

	@Test
	public void shouldReturnOneOnRomanI() {
		long days = 1;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf(1.0).equals(price), "Should return 1.0!");
	}

	@Test
	public void shouldReturnThreeOnRomanIII() {
		long days = 3;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf(3.0).equals(price), "Should return 3.0!");
	}

	@Test
	public void shouldSubtractFiveMinusOneOnRomanIV() {
		long days = 4;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf(4.4 - 1.0).equals(price), "Should return 3.4!");
	}

	@Test
	public void shouldCalculateRomanV() {
		long days = 5;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf(4.4).equals(price), "Should return 4.4!");
	}

	@Test
	public void shouldCalculateRomanVII() {
		long days = 7;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf(4.4 + 2.0).equals(price), "Should return 6.4!");
	}

	@Test
	public void shouldCalculateRomanVIIII() {
		long days = 9;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf(8.4 - 1.0).equals(price), "Should return 7.4!");
	}

	@Test
	public void shouldCalculateRomanXIV() {
		long days = 14;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf(8.4 + 4.4 - 1.0).equals(price), "Should return 8.4 + 4.4 - 1.0!");
	}

	@Test
	public void shouldCalculateRomanXXXIX() {
		long days = 39;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf((3.0 * 8.4) + (8.4 - 1.0)).equals(price),
				"Should return (3.0 * 8.4) + (8.4 - 1.0)!");
	}

	@Test
	public void shouldCalculateRomanXLI() {
		long days = 41;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf((39.0 - 8.4) + 1.0).equals(price), "Should return (39.0 - 8.4) + 1.0");
	}

	@Test
	public void shouldCalculateRomanLXXVII() {
		long days = 77;

		Double price = service.romanPrice(days);

		Assert.isTrue(Double.valueOf(39.0 + (2.0 * 8.4) + 4.4 + 2.0).equals(price));
	}
}
