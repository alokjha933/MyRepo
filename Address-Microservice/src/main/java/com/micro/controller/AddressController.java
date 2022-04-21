package com.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.request.CreateRequestAddress;
import com.micro.response.AddressResponse;
import com.micro.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	AddressService addressServ;

	@PostMapping("/create-address")
	public AddressResponse postAddress(@RequestBody CreateRequestAddress createReqAddress) {
		return addressServ.createAddress(createReqAddress);
	}

	@GetMapping("/get-address/{id}")
	public AddressResponse getAddressByID(@PathVariable long id) {
		return addressServ.getAddressById(id);
	}
}
