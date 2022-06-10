package com.bit.sts07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts07.model.EmpDao;
import com.bit.sts07.model.EmpVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	EmpDao empDao;
	
	@RequestMapping("/test")
	public Object test() {
		
		return new EmpVo();
	}
	
	@GetMapping("/emp")
	public List<EmpVo> list() throws Exception {
		return empDao.findAll();
	}
	
	@GetMapping("/emp/{empno}")
	public EmpVo detail(@PathVariable int empno) throws Exception {
		return empDao.find(empno);
	}
	
	@PostMapping("/emp")
	public void add(EmpVo bean) throws Exception {
		empDao.insertOne(bean);
	}
	
	@PutMapping("/emp/{empno}")
	public void update(@PathVariable int empno, @RequestBody EmpVo bean) throws Exception {
		
		int result = 0;
		try {
			result = empDao.updateOne(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result == 0) throw new IllegalArgumentException();
	}
}
