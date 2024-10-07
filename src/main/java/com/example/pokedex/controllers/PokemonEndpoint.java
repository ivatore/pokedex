package com.example.pokedex.controllers;

import java.time.Instant;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.pokedex.entity.PokemonResponse;
import com.example.pokedex.service.PokeApiService;
import com.example.soap.pokemon.PokemonRequest;

import jakarta.servlet.http.HttpServletRequest;

@Endpoint
public class PokemonEndpoint {

	private static final Logger log = LoggerFactory.getLogger(PokemonEndpoint.class);

	private static final String NAMESPACE_URI = "http://example.com/soap/pokemon";

	@Autowired
	private HttpServletRequest req;

	@Autowired
	private PokeApiService pokeApiService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PokemonRequest")
	@ResponsePayload
	public PokemonResponse getPokemonInfo(@RequestPayload PokemonRequest reques) {
		log.info(NAMESPACE_URI);
		req.setAttribute("startTime", Instant.now());
		// Consumir la API REST de PokeAPI
		String jsonResponse = pokeApiService.getPokemonData(reques.getName());

		JSONObject pokemonJson = new JSONObject(jsonResponse);

		PokemonResponse response = pokeApiService.consultPokedexFormat(pokemonJson, req);

		return response;
	}
}
