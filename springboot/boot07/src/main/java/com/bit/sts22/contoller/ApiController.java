package com.bit.sts22.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts22.domain.Emp;
import com.bit.sts22.service.ApiServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/emp")
@RequiredArgsConstructor
public class ApiController {
	
	private final ApiServiceImpl apiService;
	
	@GetMapping
	public ResponseEntity<?> getList(){
		return new ResponseEntity(apiService.selectAll(), HttpStatus.OK);
	}
	
	@GetMapping("/size")
	public ResponseEntity<Integer> getSize(){
		return ResponseEntity.ok(apiService.size());
	}
	
	@GetMapping("/{empno}")
	public ResponseEntity<Emp> getOne(@PathVariable int empno){
		return ResponseEntity.ok(apiService.selectOne(empno));
	}
	
	@PostMapping("/head")
	public void head(@RequestHeader("cors") String key) {
		System.out.println(key);
	}
	
	@PostMapping
	public ResponseEntity<Object> add(@RequestBody Emp emp){
		if(apiService.insert(emp)) return ResponseEntity.ok(emp);
		else return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{empno}")
	public ResponseEntity<Object> update(@PathVariable int empno, @RequestBody Emp emp){
		return ResponseEntity.ok(apiService.update(emp));
	}
	
	@DeleteMapping("/{empno}")
	public ResponseEntity<Object> delete(@PathVariable int empno){
		return ResponseEntity.ok(apiService.delete(empno));
	}
}
