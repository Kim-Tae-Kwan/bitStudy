package com.bit.sts22.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		System.out.println("web : " + session.getId());
		return "index";
	}
}
