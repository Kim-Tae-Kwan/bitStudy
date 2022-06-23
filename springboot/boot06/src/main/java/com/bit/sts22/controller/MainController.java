package com.bit.sts22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts22.Service.EmpServiceImpl;
import com.bit.sts22.domain.Emp;

@CrossOrigin
@RestController
public class MainController {
	
	@Autowired
	private EmpServiceImpl empServiceImpl;
	
	@GetMapping("/")
	public String index() {
		return "API Service는 담당자에게 문의하세요";
	}
	
	@GetMapping("/api/emp")
	public ResponseEntity<?> list(){
		return ResponseEntity.ok(empServiceImpl.selectAll());
	}
	
	@PostMapping("/api/emp")
	public ResponseEntity<?> add(@RequestBody Emp emp){
		return ResponseEntity.ok(emp);
	}
}
