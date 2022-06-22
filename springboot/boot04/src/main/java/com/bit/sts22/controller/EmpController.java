package com.bit.sts22.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts22.domain.Emp;
import com.bit.sts22.service.EmpServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/emp")
@RequiredArgsConstructor
public class EmpController {
	
	private final EmpServiceImpl empServiceImpl;
	
	@GetMapping()
	public ResponseEntity<List<Emp>> getList(){
		return ResponseEntity.ok(empServiceImpl.selectAll());
	}
	
	@PostMapping()
	public ResponseEntity<Emp> add(@RequestBody Emp emp) {
		if(empServiceImpl.insertOne(emp) != null) return ResponseEntity.ok(emp);
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
}
