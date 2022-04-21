package com.mvc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.impl.model.Alien;

@RestController
public class AlienRESTController {

	@Autowired
	AlienRepo alienRepo;

	@GetMapping("aliens")
//	@ResponseBody
	public List<Alien> getAliens() {
		List<Alien> alien = alienRepo.findAll();
		return alien;
	}

	@GetMapping("aliens/{aid}")
	// @ResponseBody
	public Alien getAlienById(@PathVariable int aid) {

		Alien alien = alienRepo.findById(aid).orElse(new Alien(0, ""));
		return alien;
	}

	@PostMapping("aliens")
	// @ResponseBody
	public Alien addAlien(Alien alien) {

		alienRepo.save(alien);
		return alien;
	}
}
