package com.bit.sts23.boot03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts23.boot03.domain.Dept;
import com.bit.sts23.boot03.domain.DeptMapper;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "<h1>Rest API Server</h1>";
	}
}