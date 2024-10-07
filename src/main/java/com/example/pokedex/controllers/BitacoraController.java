package com.example.pokedex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokedex.service.BitacoraService;

@RestController
public class BitacoraController {

	@Autowired
	private BitacoraService bitacoraService;

	@GetMapping("bitacora")
	public ResponseEntity<List<BitacoraEntity>> getMethodName() {
		List<BitacoraEntity> lista = bitacoraService.registros();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<BitacoraEntity>>(lista, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BitacoraEntity>>(lista, HttpStatus.FOUND);
	}

}
