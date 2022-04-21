package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public SampleResponse Sample(@RequestParam String name) {
		System.out.println("working");
		SampleResponse response = new SampleResponse();
		response.setId(1);
		response.setMessage("Your name is " + name);
		return response;

	}

	@RequestMapping(value = "/sample1", method = RequestMethod.GET)
	public SampleResponse Sample() {
		System.out.println("working");
		SampleResponse response = new SampleResponse();
		response.setId(1);
		response.setMessage("Your name is " + "ALOK");
		return response;

	}
}