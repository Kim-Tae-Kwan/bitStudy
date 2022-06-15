package com.bit.sts12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bit.sts12.service.EmpService;

import lombok.Getter;

@Controller
public class HomeController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/")
	public String list(Model model) {
		empService.selectAll(model);
		return "home";
	}
	
	@GetMapping("/{idx}")
	public String one(@PathVariable int idx, Model model) {
		//empService.selectOne(idx, model);
		//return "home";

		empService.delete(idx);
		return "redirect:./";
	}
}
