package com.bit.sts08.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts08.repository.Emp;
import com.bit.sts08.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/")
	public String list(Model model) throws Exception {
		empService.selectAll(model);
		return "list";
	}
	
	@GetMapping("/{empno}")
	public String detail(@PathVariable int empno, Model model) throws Exception {
		empService.select(model, empno);
		return "detail";
	}
	
	@GetMapping("/add")
	public String add() throws Exception {
		return "add";
	}
	
	@GetMapping("/login/")
	public String loginForm() {
		return "login";
	}
	
	@GetMapping("/logout/")
	public String logout(HttpServletRequest req) {
		empService.logout(req);
		return "redirect:../";
	}
	
	@PostMapping("/login/")
	public String login(@ModelAttribute Emp bean, HttpServletRequest req) {
		
		if(empService.login(bean,req)) return "redirect:../";
		else return "login";
	}
	
	@PostMapping("/add")
	public String insert(@ModelAttribute("bean") Emp bean, Model model) throws Exception{
		
		try {
			empService.insertOne(bean);
			return "redirect:./";
		} catch (Exception e) {
			model.addAttribute("err", e);
			return "add";
		}
	}
	
	@PutMapping("/")
	public String update(@ModelAttribute Emp bean, Model model) throws Exception {
		empService.update(bean);
		return "redirect:./" + bean.getEmpno();
	}
	
	
}
