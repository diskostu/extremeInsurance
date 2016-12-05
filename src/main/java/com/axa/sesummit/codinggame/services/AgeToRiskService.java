package com.axa.sesummit.codinggame.services;

import org.springframework.stereotype.Service;

@Service
public class AgeToRiskService {

	public Double getRiskForAge(int age) {
		if (age < 18) {
			return 1.1;
		}

		if (age >= 18 && age <= 24) {
			return 0.9;
		}

		if (age >= 25 && age <= 65) {
			return 1.0;
		}

		return 1.5;
	}
}
