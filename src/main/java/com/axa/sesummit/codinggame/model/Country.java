package com.axa.sesummit.codinggame.model;

public enum Country {
	Estonia("EE", 1.3), Finland("FI", 0.8), Slovakia("SV", 0.7), Luxembourg("LU", 1.3), Croatia("HR", 1.3), Austria(
			"AU", 0.9), Austria2("AT", 0.9), Greece("GR", 0.6), Greece2("EL", 0.6), Latvia("LV", 0.6), SouthAfrica("ZA",
					1.6), DominicanRepublic("DO", 1.3), Ireland("IE", 1.1), Czechia("CZ", 1.2), Italy("IT",
							1.2), Macedonia("MK", 1.6), Denmark("DK", 1.2), Bulgaria("BG", 1.1), France("FR",
									1.0), Slovenia("SI", 0.8), IsleofMan("IM", 1.2), Malta("MT", 1.2), Poland("PL",
											1.4), HeardIslandAndMcDonaldIslands("xxx", 0.7), Portugal("PT",
													0.5), Hungary("HU", 1.1), Sweden("SE", 1.2), Swaziland("SZ",
															3.7), TaiwanProvinceOfChina("TW",
																	1.6), UnitedKingdomOfGreat("GB",
																			1.1), UnitedKingdomOfGreat2("UK",
																					1.1), Netherlands("NL",
																							0.7), Panama("PA",
																									1.6), Egypt("EG",
																											0.9), Pitcairn(
																													"PN",
																													1.2), Mexico(
																															"MX",
																															1.6), Qatar(
																																	"QA",
																																	1.6), Cyprus(
																																			"CY",
																																			1.6), Romania(
																																					"RO",
																																					1.3), Belgium(
																																							"BE",
																																							0.9), Thailand(
																																									"TH",
																																									1.6), Spain(
																																											"ES",
																																											1.1), DemocraticPeoplesRepublicOfKorea(
																																													"KR",
																																													6.9), Chad(
																																															"TD",
																																															1.3), Lithuania(
																																																	"LT",
																																																	0.7), WallisAndFutuna(
																																																			"WF",
																																																			1.5), Uruguay(
																																																					"UY",
																																																					1.6), Germany(
																																																							"DE",
																																																							0.8);

	private String countryCode;
	private double value;

	Country(final String countryCode, final double value) {
		this.countryCode = countryCode;
		this.value = value;

	}

	public double getValue() {
		return value;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public static double getValueForCode(final String code) {
		if (code == null || code.length() != 2) {
			throw new IllegalArgumentException("Invalid country code: " + code);
		}

		for (final Country country : Country.values()) {
			if (country.getCountryCode().equals(code)) {
				return country.getValue();
			}
		}

		throw new IllegalArgumentException("No country found for code " + code);
	}
}