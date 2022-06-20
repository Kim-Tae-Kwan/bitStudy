package com.bit.sts22.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts22.domain.Dept;
import com.bit.sts22.service.DeptApiService;

import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/api")
public class DeptController {
	
	@Autowired
	DeptApiService deptApiService;
	
	@CrossOrigin
	@GetMapping("/dept")
	public List<Dept> getList(){
		return deptApiService.selectAll();
	}
	
	@GetMapping("/dept/{deptno}")
	public Dept getDept(@PathVariable int deptno) {
		return deptApiService.selectOne(deptno);
	}
	
	@CrossOrigin
	@PostMapping("/dept")
	public ResponseEntity<Object> insert(@RequestBody Dept bean) {
		try {
			deptApiService.insertOne(bean);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			Map<String, String> obj = new HashMap<>();
			obj.put("err", e.getMessage());
			return ResponseEntity.status(400).body(obj);
		}
	}
	
	@PutMapping("/dept/{deptno}")
	public ResponseEntity<Object> update(@PathVariable int deptno, @RequestBody Dept dept) {
		
		try {
			if(deptApiService.updateOne(dept) > 0) {
				return ResponseEntity.ok().build();
			}else return ResponseEntity.status(400).build();
		} catch (Exception e) {
			Map<String, String> obj = new HashMap<>();
			obj.put("err", e.getMessage());
			return ResponseEntity.status(500).body(obj);
		}
	}
	
	@DeleteMapping("/dept/{deptno}")
	public ResponseEntity<Object> delete(@PathVariable int deptno) {
		
		try {
			if(deptApiService.deleteOne(deptno) > 0) {
				return ResponseEntity.ok().build();
			}else return ResponseEntity.status(400).build();
		} catch (Exception e) {
			Map<String, String> obj = new HashMap<>();
			obj.put("err", e.getMessage());
			return ResponseEntity.status(500).body(obj);
		}
	}
}
