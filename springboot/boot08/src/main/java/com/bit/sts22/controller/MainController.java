package com.bit.sts22.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bit.sts22.domain.Emp;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MainController {
	
	private final RestTemplate template;
	private final String aptPath = "http://localhost:8070/api/emp";
	
	@GetMapping("/list")
	public ResponseEntity<String> list() throws URISyntaxException{
		URI url = new URI(aptPath);
		
		return template.exchange(url, HttpMethod.GET, null, String.class);
	}
	
	@GetMapping("/list/{num}")
	public ResponseEntity<?> one(@PathVariable int num) throws URISyntaxException{
		URI url = new URI(aptPath + "/" + num);
		
//		String result = template.getForObject(url, String.class);
//		return ResponseEntity.ok(result);
		
		//return template.getForEntity(url, String.class);
		ResponseEntity<String> result = template.exchange(url, HttpMethod.GET, null, String.class);
		log.info(result.getBody());
		return result;
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add() throws URISyntaxException{
		URI url = new URI(aptPath);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Emp emp = Emp.builder()
				.ename("rest")
				.pay(123456)
				.build();
		
		Map<String, Object> body = new HashMap<>();
		body.put("ename", "map3");
		body.put("pay", "9999");
		
		//HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
		//HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body);
		
		return template.postForEntity(url, body, String.class);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> update() throws URISyntaxException{
		URI url = new URI(aptPath + "/" + 1);
		
		Map<String, Object> params = new HashMap<>();
		params.put("empno", 1);
		params.put("ename", "한글2");
		params.put("pay", 4444);
		
//		template.put(url, params);
//		return ResponseEntity.ok().build();
		
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(params);
		return template.exchange(url, HttpMethod.PUT, entity, String.class);
		
	}
	
	@GetMapping("/delete/{empno}")
	public ResponseEntity<?> delete(@PathVariable int empno) throws URISyntaxException{
		URI url = new URI(aptPath + "/" + empno);
		
		return template.exchange(url, HttpMethod.DELETE, null, String.class);
	}
	
	
	@GetMapping("/head")
	public ResponseEntity<?> head() throws URISyntaxException{
		URI url = new URI("http://localhost:8070/api/emp/head");
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("cors", "ABCD");
		
		HttpEntity entity = new HttpEntity(headers);
		
		return template.postForEntity(url, entity, String.class);
		
	}
	
}
