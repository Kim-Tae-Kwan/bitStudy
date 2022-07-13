package com.bit.sts34.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/")
	public ResponseEntity<?> login(String name){
		// DB user check
		//return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		// login -> token
		System.out.println(name);
		String token = tokenService.createToken(name, System.currentTimeMillis() + 1000 * 30);
		return ResponseEntity.ok(token);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(HttpServletRequest req){
		
		String token = req.getHeader(HttpHeaders.AUTHORIZATION);
		if(tokenService.getUser(token).equals("err")) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
		
		Map<String, Object> item1 = Map.of("sabun", 1, "ename", "kim1", "pay", 1000);
		Map<String, Object> item2 = Map.of("sabun", 2, "ename", "kim2", "pay", 2000);
		Map<String, Object> item3 = Map.of("sabun", 3, "ename", "kim3", "pay", 3000);
		Map<String, Object> item4 = Map.of("sabun", 4, "ename", "kim4", "pay", 4000);
		return ResponseEntity.ok(List.of(item1, item2, item3, item4));
		
	}
	
}
