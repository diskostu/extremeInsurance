package com.axa.sesummit.codinggame.services;

import com.frequal.romannumerals.Converter;
import org.springframework.stereotype.Service;

@Service
public class RomanPriceServiceImpl implements RomanPriceService {


    private enum RomanCharValue {
        // @formatter:off
        I(1), II(2), III(3), IV(4.2 - 1), V(4.2),
        VI(4.2 + 1), VII(4.2 + 1 + 1), VIII(4.2 + 1 + 1 + 1), IX(8.4 - 1), X(8.4),
        XI(8.4+1), XII(8.4+1+1), XIII(8.4+1+1+1), XIV(8.4 + 4.2 - 1), XV(8.4 + 4.2),
        XVI(8.4 + 4.2 + 1), XVII(8.4 + 4.2 + 1 + 1), XVIII(8.4 + 4.2 + 1 + 1 + 1),
        XIX(8.4 + 8.4 - 1), XX(8.4 + 8.4),
        L(42);
        // @formatter:on

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

        if (days.intValue() <= 20) {
            return RomanCharValue.getEnumForString(romanNumerals).getCharValue();
        } else {
            return getValueForRomanNumber(romanNumerals);
        }
    }

    public Double romanPriceWithSubtraction(Long days) {
        String romanNumerals = romanConv.toRomanNumerals(days.intValue());

        return getValueForRomanNumber(romanNumerals);
    }

    private double getValueForRomanNumber(final String romanNumber) {
        String[] splitString = romanNumber.split("");
        int length = splitString.length;

        double sum = 0;
        for (int i = 0; i < length; i++) {
            String currentChar = splitString[i];
            sum += RomanCharValue.getEnumForString(currentChar).charValue;
        }


        return 0.0;
    }

    public static void main(String[] args) {
        RomanPriceServiceImpl service = new RomanPriceServiceImpl();
        Double aDouble = service.romanPrice(new Long(11));

        System.out.println("Result: " + aDouble);
    }
}