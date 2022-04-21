package com.micro.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.entity.Address;
import com.micro.repository.AddressRepository;
import com.micro.request.CreateRequestAddress;
import com.micro.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepo;

	public AddressResponse createAddress(CreateRequestAddress requestAddress) {
		Address add = new Address();
		add.setCity(requestAddress.getCity());
		add.setStreet(requestAddress.getStreet());
		addressRepo.save(add);
		return new AddressResponse(add);
	}

	public AddressResponse getAddressById(long id) {
		List<Address> addList = addressRepo.findById(id).stream().collect(Collectors.toList());
		return new AddressResponse(addList.get(0));
	}
}
