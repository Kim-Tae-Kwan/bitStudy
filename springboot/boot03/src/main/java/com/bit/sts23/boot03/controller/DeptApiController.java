package com.bit.sts23.boot03.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts23.boot03.domain.Dept;
import com.bit.sts23.boot03.service.RestServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/api/dept")
@RequiredArgsConstructor
public class DeptApiController {
	
	private final RestServiceImpl restServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Dept>> getAll(){
		List<Dept> result = restServiceImpl.selectAll();
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/{deptno}")
	public ResponseEntity<Dept> getOne(@PathVariable int deptno) {
		Dept result = restServiceImpl.selectOne(deptno);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping()
	public ResponseEntity<Object> add(@RequestBody Dept dept){
		Map<String, Object> map  = new HashMap<>();
		try {
			int result = restServiceImpl.insert(dept);
			if(result > 0) {
				map.put("result", true);
				return ResponseEntity.status(200).body(map);
			}else { 
				map.put("result", false);
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(map);
			}
		} catch (Exception e) {
			map.put("result", e.getMessage());
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(map);
		}
		
		
	}
	
	@PutMapping("/{deptno}")
	public ResponseEntity<Object> update(@PathVariable int deptno, @RequestBody Dept dept){
		Map<String, Object> map  = new HashMap<>();
		if(dept.getDeptno() == 0) dept.setDeptno(deptno);
		
		int result = restServiceImpl.update(dept);
		if(result > 0) {
			map.put("result", true);
			map.put("dept", dept);
			return ResponseEntity.ok().body(map);
		}
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/{deptno}")
	public ResponseEntity<Object> delete(@PathVariable int deptno){
		Map<String, Object> map  = new HashMap<>();
		
		int result = restServiceImpl.delete(deptno);
		if(result > 0) {
			map.put("result", true);
			return ResponseEntity.ok().build();
		}
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
	
}
