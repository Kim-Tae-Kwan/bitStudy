package com.bit.sts34.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	@RequestMapping("/")
	public String index(@AuthenticationPrincipal User user) throws SQLException {
		System.out.println(user);
		return "home";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
