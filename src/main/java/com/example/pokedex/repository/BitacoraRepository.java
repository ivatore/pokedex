package com.example.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pokedex.controllers.BitacoraEntity;

@Repository
public interface BitacoraRepository extends JpaRepository<BitacoraEntity, Long> {

}