package com.micro.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.jetmodel.JwtRequest;
import com.micro.jetmodel.JwtResponse;
import com.micro.jwthelper.JwtUtil;
import com.micro.service.CustomUserDetails;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class JwtController {
	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	CustomUserDetails customUserDetails;

	@Autowired
	private AuthenticationManager authManager;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		System.out.println(jwtRequest);
		try {
			this.authManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}

		UserDetails userDetails = this.customUserDetails.loadUserByUsername(jwtRequest.getUsername());
		String token = jwtUtil.generateToken(userDetails);
		System.out.println("JWT Token:  " + token);

		// need to convert into json

		return ResponseEntity.ok(new JwtResponse(token));
	}
}
