package com.axa.sesummit.codinggame.model;

/**
 * Created by diskostu on 05.12.16.
 */
public enum Country {
	Estonia("xxx", 1.3), Finland("xxx", 0.8), Slovakia("xxx", 0.7), Luxembourg("xxx", 1.3), Croatia("xxx",
			1.3), Austria("xxx", 0.9), Greece("xxx", 0.6), Latvia("xxx", 0.6), SouthAfrica("xxx",
					1.6), DominicanRepublic("xxx", 1.3), Ireland("xxx", 1.1), Czechia("xxx", 1.2), Italy("xxx",
							1.2), Macedonia("xxx", 1.6), Denmark("xxx", 1.2), Bulgaria("xxx", 1.1), France("xxx",
									1.0), Slovenia("xxx", 0.8), IsleofMan("xxx", 1.2), Malta("xxx", 1.2), Poland("xxx",
											1.4), HeardIslandAndMcDonaldIslands("xxx", 0.7), Portugal("xxx",
													0.5), Hungary("xxx", 1.1), Sweden("xxx", 1.2), Swaziland("xxx",
															3.7), TaiwanProvinceOfChina("xxx",
																	1.6), UnitedKingdomOfGreat("xxx", 1.1), Netherlands(
																			"xxx",
																			0.7), Panama("xxx", 1.6), Egypt("xxx",
																					0.9), Pitcairn("xxx", 1.2), Mexico(
																							"xxx", 1.6), Qatar("xxx",
																									1.6), Cyprus("xxx",
																											1.6), Romania(
																													"xxx",
																													1.3), Belgium(
																															"xxx",
																															0.9), Thailand(
																																	"xxx",
																																	1.6), Spain(
																																			"xxx",
																																			1.1), DemocraticPeoplesRepublicOfKorea(
																																					"xxx",
																																					6.9), Chad(
																																							"xxx",
																																							1.3), Lithuania(
																																									"xxx",
																																									0.7), WallisAndFutuna(
																																											"xxx",
																																											1.5), Uruguay(
																																													"xxx",
																																													1.6), Germany(
																																															"xxx",
																																															0.8);
	// @formatter:on

	private double value;
	private String countryCode;

	Country(final double value, final String countryCode) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public double getValueForCode(final String code) {
		for (final Country country : Country.values()) {
			if (country.getCountryCode().equals(code)) {
				return country.getValue();
			}
		}

		throw new IllegalArgumentException("No country found for code " + code);
	}
}
