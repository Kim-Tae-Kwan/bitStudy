package com.bit.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring.model.Emp02Dao;
import com.bit.spring.model.Emp03Dao;
import com.bit.spring.model.EmpDao;
import com.bit.spring.model.EmpVo;

public class EmpDeleteController implements Controller {
	EmpDao dao;
	Logger log = Logger.getLogger(this.getClass());
	
	public EmpDeleteController() {
		System.out.println("EmpDeleteController...");
	}
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if(!request.getMethod().equals("POST")) response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		else dao.deleteOne(Integer.parseInt(request.getParameter("empno")));
		
		mav.setViewName("redirect:list.bit");
		return mav;
	}
}
