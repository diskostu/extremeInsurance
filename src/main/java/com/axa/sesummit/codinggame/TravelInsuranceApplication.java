package com.axa.sesummit.codinggame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.axa.sesummit.codinggame")
public class TravelInsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelInsuranceApplication.class, args);
	}
}
