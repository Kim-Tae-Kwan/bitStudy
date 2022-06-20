package com.bit.sts22.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts22.domain.Dept;
import com.bit.sts22.service.DeptService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MainController {
	
	@Autowired
	private DeptService deptService;
	
	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "Hello World";
	}
	
	@GetMapping("/ex01")
	public String ex01(Model model) {
		model.addAttribute("msg", "환영합니다.");
		return "ex01";
	}
	
	@GetMapping("/dept")
	public String list(Model model) {
		deptService.selectAll(model);
		return "list";
	}
	
	@GetMapping("/dept/add")
	public String add() {
		return "add";
	}
	
	@PostMapping("/dept")
	public String insert(@ModelAttribute Dept bean, Model model) {
		log.debug(bean);
		deptService.insertOen(bean, model);
		return "redirect:dept";
	}
	
	@GetMapping("/dept/{deptno}")
	public String detail(@PathVariable int deptno, Model model) {
		deptService.selectOen("bean", deptno, model);
		return "detail";
	}
	
	@PutMapping("/dept/{deptno}")
	public String update(@PathVariable int deptno, @ModelAttribute Dept dept, Model model) {
		deptService.updateOen(dept, model);
		return "redirect:./";
	}
	
	@DeleteMapping("/dept/{deptno}")
	public String delete(@PathVariable int deptno, @ModelAttribute Dept dept) {
		deptService.deleteOen(deptno);
		return "redirect:./";
	}
}
