package com.mvc.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.impl.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

	
}
