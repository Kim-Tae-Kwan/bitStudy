package com.bit.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring.model.EmpDao;
import com.bit.spring.model.EmpVo;

public class AddController implements Controller {

	@Autowired
	EmpDao<EmpVo> dao;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse response) throws Exception {
		String url;
		
		if(req.getMethod().equals("GET")) {
			url = "add";
		}else {
			url = "redirect:list";
			dao.insertOne(new EmpVo(
					Integer.parseInt(req.getParameter("empno")), 
					req.getParameter("ename"),
					Integer.parseInt(req.getParameter("sal")),
					req.getParameter("job"),
					null
					));
		}
		
		return new ModelAndView(url);
	}

}
