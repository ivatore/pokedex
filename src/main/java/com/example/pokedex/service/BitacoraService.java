package com.example.pokedex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pokedex.controllers.BitacoraEntity;
import com.example.pokedex.repository.BitacoraRepository;

@Service
public class BitacoraService {

	@Autowired
	private BitacoraRepository bitacoraRepository;

	public void registrarEvento(BitacoraEntity bitacora) {
		bitacoraRepository.save(bitacora);
	}

	public List<BitacoraEntity> registros() {
		return bitacoraRepository.findAll().isEmpty() ? new ArrayList<>() : bitacoraRepository.findAll();
	}

}
