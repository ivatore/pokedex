package com.example.pokedex.testultils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.pokedex.entity.PokemonResponse;
import com.example.soap.pokemon.PokemonRequest;

@Service
public class PokemonClient {
	@Autowired
	private WebServiceTemplate webServiceTemplate;

	public PokemonClient(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}

	public PokemonResponse getPokemonInfo(String name) {
		PokemonRequest request = new PokemonRequest();
		request.setName(name);

		return (PokemonResponse) webServiceTemplate.marshalSendAndReceive(request);
	}
}
