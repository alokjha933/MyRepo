package com.micro.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.response.AddressResponse;

@FeignClient(url = "${address.service.url}", value = "address-feign-client")
public interface AddressFeignClient {
	@GetMapping("get-address/{id}")
	public AddressResponse getById(@PathVariable long id);
}
