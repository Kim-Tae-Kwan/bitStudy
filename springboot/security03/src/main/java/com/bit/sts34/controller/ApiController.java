package com.bit.sts34.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts34.service.TokenServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
	
	private final TokenServiceImpl tokenService; 
	
	@GetMapping("/create")
	public String create() {
		return tokenService.createToken();
	}
	
	@GetMapping("/check")
	public String check(@RequestParam String token) {
		return tokenService.getUser(token);
	}
}
