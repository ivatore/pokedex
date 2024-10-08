package com.example.pokedex;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.pokedex.entity.PokemonResponse;
import com.example.pokedex.testultils.PokemonClient;
import com.example.soap.pokemon.PokemonRequest;

class PokemonClientTest {

	@Mock
	private WebServiceTemplate webServiceTemplate;

	@InjectMocks
	private PokemonClient pokemonClient;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); 
	}

	@Test
	void testGetPokemonInfo() {
		PokemonResponse mockResponse = new PokemonResponse();
		mockResponse.setName("Simulated Pokémon Info for Pikachu");
		when(webServiceTemplate.marshalSendAndReceive(any(PokemonRequest.class))).thenReturn(mockResponse);
		PokemonResponse response = pokemonClient.getPokemonInfo("pikachu");
		assertNotNull(response);
		assertEquals("Simulated Pokémon Info for Pikachu", response.getName());
		verify(webServiceTemplate, times(1)).marshalSendAndReceive(any(PokemonRequest.class));
	}
}
