package com.bit.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring.model.Emp02Dao;
import com.bit.spring.model.Emp03Dao;
import com.bit.spring.model.EmpDao;
import com.bit.spring.model.EmpVo;

public class EmpUpdateController implements Controller {
	EmpDao dao;
	
	public EmpUpdateController() {
		System.out.println("EmpUpdateController...");
	}
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("utf-8");
			EmpVo bean = new EmpVo(
					Integer.parseInt(request.getParameter("empno")),
					request.getParameter("ename"),
					Integer.parseInt(request.getParameter("sal")),
					request.getParameter("job")
					);
			if(dao.updateOne(bean) > 0) {
				mav.setViewName("redirect:list.bit");
			}else {
				mav.setViewName("redirect:detail.bit");
			}
			
			
			
		}else mav.setViewName("emp/add");
		
		return mav;
	}
}
