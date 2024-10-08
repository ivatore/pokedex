package com.example.pokedex.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	WebServiceTemplate webServiceTemplate() {
		return new WebServiceTemplate();
	}
}
