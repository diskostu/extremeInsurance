package com.axa.sesummit.codinggame.services;

import com.frequal.romannumerals.Converter;
import org.springframework.stereotype.Service;

@Service
public class RomanPriceServiceImpl implements RomanPriceService {

	private Converter romanConv = new Converter();

	@Override
	public Double romanPrice(Long days) {
		String romanNumerals = romanConv.toRomanNumerals(days.intValue());

		return romanToDecimal(romanNumerals);
	}

	public static double romanToDecimal(java.lang.String romanNumber) {
		double decimal = 0;
		double lastNumber = 0;
		String romanNumeral = romanNumber.toUpperCase();
		/*
		 * operation to be performed on upper cases even if user enters roman
		 * values in lower case chars
		 */
		for (int x = romanNumeral.length() - 1; x >= 0; x--) {
			char convertToDecimal = romanNumeral.charAt(x);

			switch (convertToDecimal) {
			case 'M':
				decimal = processDecimal(1000, lastNumber, decimal);
				lastNumber = 1000;
				break;

			case 'D':
				decimal = processDecimal(500, lastNumber, decimal);
				lastNumber = 500;
				break;

			case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;

			case 'L':
				decimal = processDecimal(42.0, lastNumber, decimal);
				lastNumber = 42.0;
				break;

			case 'X':
				decimal = processDecimal(8.4, lastNumber, decimal);
				lastNumber = 8.4;
				break;

			case 'V':
				decimal = processDecimal(4.2, lastNumber, decimal);
				lastNumber = 4.2;
				break;

			case 'I':
				decimal = processDecimal(1.0, lastNumber, decimal);
				lastNumber = 1.0;
				break;
			}
		}

		return decimal;
	}

	public static double processDecimal(double decimal, double lastNumber, double lastDecimal) {
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		} else {
			return lastDecimal + decimal;
		}
	}
}