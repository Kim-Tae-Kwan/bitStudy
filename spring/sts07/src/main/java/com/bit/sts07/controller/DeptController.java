package com.bit.sts07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts07.model.DeptDao;
import com.bit.sts07.model.DeptVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	DeptDao deptDao;
	
	@GetMapping("/")
	public String list(Model model) throws Exception {
		model.addAttribute("list", deptDao.findAll());
		return "list";
	}
	
	@GetMapping("/{deptno}")
	public String detail(@PathVariable int deptno, Model model) throws Exception {
		model.addAttribute("bean", deptDao.find(deptno));
		return "detail";
	}
	
	@GetMapping("/add")
	public String add(Model model) throws Exception {
		return "add";
	}
	
	@GetMapping("/{deptno}/edit")
	public String add(@PathVariable int deptno, Model model) throws Exception {
		model.addAttribute("bean", deptDao.find(deptno));
		return "edit";
	}
	
	@PostMapping("/add")
	public String insert(Model model, @ModelAttribute DeptVo bean) throws Exception {
		deptDao.insertOne(bean);
		return "redirect:./";
	}
	
	@PutMapping("/{deptno}")
	public String update(@ModelAttribute DeptVo bean, Model model) throws Exception {
		deptDao.updateOne(bean);
		return "redirect:./";
	}
	
	@DeleteMapping("/{deptno}")
	public String delete(@PathVariable int deptno, Model model) throws Exception {
		deptDao.deleteOne(deptno);
		return "redirect:./";
	}
	
}
