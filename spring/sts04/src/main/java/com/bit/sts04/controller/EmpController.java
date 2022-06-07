package com.bit.sts04.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts04.model.EmpDao;
import com.bit.sts04.model.EmpVo;

@Controller
@RequestMapping("/emp/")
public class EmpController {
	@Autowired
	EmpDao<EmpVo> dao;
	
	
	@RequestMapping("list")
	public void list(Model model) throws SQLException {
		model.addAttribute("list", dao.findAll());
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws SQLException {
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String insert(@RequestParam("empno") int empno, String ename, int sal, String job) throws SQLException {
		EmpVo bean = new EmpVo(empno,sal,ename,job,null);
		dao.insertOne(bean);
		return "redirect:list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(@RequestParam("idx") int empno, Model model) throws SQLException {
		model.addAttribute("readonly", "readonly");
		model.addAttribute("displayReset", "hidden");
		model.addAttribute("action", "edit");
		model.addAttribute("method", "get");
		model.addAttribute("bean", dao.find(empno));
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(int empno, Model model) throws SQLException {
		model.addAttribute("displayDelete", "hidden");
		model.addAttribute("action", "edit");
		model.addAttribute("method", "post");
		model.addAttribute("bean", dao.find(empno));
		return "emp/detail";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String update(int empno, int sal, String ename, String job) throws SQLException {
		dao.updateOne(new EmpVo(empno, sal, ename, job, null));
		return "redirect:detail?idx=" + empno;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void delete(int empno, HttpServletResponse res) throws SQLException {
		dao.deleteOne(empno);
		res.setStatus(HttpServletResponse.SC_OK);
	}
}
