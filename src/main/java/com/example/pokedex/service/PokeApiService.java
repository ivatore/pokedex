package com.example.pokedex.service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;

import com.example.soap.pokemon.PokemonResponse;

@Service
public class PokeApiService {

	@Autowired
	private RestTemplate restTemplate;

	public String getPokemonData(String pokemonName) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
		return restTemplate.getForObject(url, String.class);
	}

	public PokemonResponse consultPokedexFormat(JSONObject pokemonJson) {
		// Construir la respuesta SOAP
		PokemonResponse response = new PokemonResponse();
		response.setName(pokemonJson.getString("name"));
		response.setId(pokemonJson.getInt("id"));
		response.setBaseExperience(pokemonJson.getInt("base_experience"));

		// Abilities
		List<String> abilities = new ArrayList<>();
		JSONArray abilitiesArray = pokemonJson.getJSONArray("abilities");
		for (int i = 0; i < abilitiesArray.length(); i++) {
			abilities.add(abilitiesArray.getJSONObject(i).getJSONObject("ability").getString("name"));
		}
		response.setAbilities(abilities);

		// Held Items
		List<String> heldItems = new ArrayList<>();
		JSONArray heldItemsArray = pokemonJson.getJSONArray("held_items");
		for (int i = 0; i < heldItemsArray.length(); i++) {
			heldItems.add(heldItemsArray.getJSONObject(i).getJSONObject("item").getString("name"));
		}
		response.setHeldItems(heldItems);

		// Location Area Encounters
		response.setLocationAreaEncounters(pokemonJson.getString("location_area_encounters"));

		TransportContext context = TransportContextHolder.getTransportContext();
		try {
			System.out.println(context.getConnection().getUri().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return response;
	}
}