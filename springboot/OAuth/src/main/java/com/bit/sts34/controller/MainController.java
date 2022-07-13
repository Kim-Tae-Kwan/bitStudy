package com.bit.sts34.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts34.service.TokenServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	TokenServiceImpl tokenService;
	@Autowired
	HttpServletResponse resp;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String username, String password) {
		//DB
		//success -> token 발행
		Cookie cookie = new Cookie("jtoken", tokenService.createToken(username, System.currentTimeMillis() + 1000 * 60));
		resp.addCookie(cookie);
		return "redirect:/";
	}
	
	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<?> getList(HttpServletRequest req) throws IOException {
	    Cookie[] cookies = req.getCookies();
	    
	    for(Cookie cookie : cookies) {
	    	if(cookie.getName().equals("jtoken")) {
	    		String token = cookie.getValue();
	    		if(tokenService.getUser(token).equals("err")) {
	    			resp.sendRedirect("/login");
	    			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	    		}
	    		
	    		
	    		Map<String, Object> item1 = Map.of("sabun", 1, "ename", "kim1", "pay", 1000);
	    		Map<String, Object> item2 = Map.of("sabun", 2, "ename", "kim2", "pay", 2000);
	    		Map<String, Object> item3 = Map.of("sabun", 3, "ename", "kim3", "pay", 3000);
	    		Map<String, Object> item4 = Map.of("sabun", 4, "ename", "kim4", "pay", 4000);
	    		return ResponseEntity.ok(List.of(item1, item2, item3, item4));
	    	}
	    }
	    
	    resp.sendRedirect("/login");
	    return null;
		
	}
}
