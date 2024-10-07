package com.example.pokedex.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.pokedex.service.PokeApiService;
import com.example.soap.pokemon.PokemonRequest;
import com.example.soap.pokemon.PokemonResponse;

@Endpoint
public class PokemonEndpoint {

	private static final String NAMESPACE_URI = "http://example.com/soap/pokemon";

	@Autowired
	private PokeApiService pokeApiService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PokemonRequest")
	@ResponsePayload
	public PokemonResponse getPokemonInfo(@RequestPayload PokemonRequest reques) {
		System.out.println("------------------------------------");
		System.out.println(reques.getName());
		System.out.println("------------------------------------");

		// Consumir la API REST de PokeAPI
		String jsonResponse = pokeApiService.getPokemonData(reques.getName());
		JSONObject pokemonJson = new JSONObject(jsonResponse);

		PokemonResponse response = pokeApiService.consultPokedexFormat(pokemonJson);

		return response;
	}
}
