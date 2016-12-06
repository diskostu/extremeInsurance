package com.axa.sesummit.codinggame.services;

import com.frequal.romannumerals.Converter;
import org.springframework.stereotype.Service;

@Service
public class RomanPriceServiceImpl implements RomanPriceService {

	private enum RomanCharValue {
		I(1), V(4.4), X(8.4), L(39);

		private double charValue;

		RomanCharValue(double charValue) {
			this.charValue = charValue;
		}

		public static RomanCharValue getEnumForString(final String s) {
			for (RomanCharValue romanCharValue : RomanCharValue.values()) {
				if (romanCharValue.name().equals(s)) {
					return romanCharValue;
				}
			}

			return null;
		}

		public double getCharValue() {
			return charValue;
		}
	}

	private Converter romanConv = new Converter();

	@Override
	public Double romanPrice(Long days) {
		String romanNumerals = romanConv.toRomanNumerals(days.intValue());

		String[] splitString = romanNumerals.split("");
		int length = splitString.length;

		double sum = 0;
		for(int i = 0; i < length; i++) {
			System.out.println("current char: " + splitString[i]);
			System.out.println(RomanCharValue.getEnumForString(splitString[i]));
			sum += RomanCharValue.getEnumForString(splitString[i]).charValue;
		}


		return sum;
	}

	public Double romanPrice2(Long days) {
		String romanNumerals = romanConv.toRomanNumerals(days.intValue());
		char[] charArray = romanNumerals.toCharArray();
		int length = charArray.length;

		double sum = 0;
		for(int i = 0; i < length; i++) {
			System.out.println("current char: " + charArray[i]);

		}


		System.out.println(romanNumerals);

		return 0.0;
	}

	public static void main(String[] args) {
		RomanPriceServiceImpl service = new RomanPriceServiceImpl();
		service.romanPrice(new Long(11));
	}
}