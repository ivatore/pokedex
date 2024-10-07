package com.example.pokedex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokedex.service.BitacoraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Pokemon SOAP API BITACORA", description = "API de bitacora para listar el consumo un servicio SOAP que obtiene información de PokéAPI")
public class BitacoraController {

	@Autowired
	private BitacoraService bitacoraService;

	@Operation(summary = "Bitacora de peticiones", description = "lista los envíos de solicitud SOAP para obtener la información de un Pokémon desde PokéAPI", responses = {
			@ApiResponse(responseCode = "404", description = "Pokemon salvaje no localizado(sera legendario?)"),
			@ApiResponse(responseCode = "302", description = "Pokemon salvaje encotrado en la pokedex") })

	@GetMapping("bitacora")
	public ResponseEntity<List<BitacoraEntity>> getMethodName() {
		List<BitacoraEntity> lista = bitacoraService.registros();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<BitacoraEntity>>(lista, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BitacoraEntity>>(lista, HttpStatus.FOUND);
	}

}
