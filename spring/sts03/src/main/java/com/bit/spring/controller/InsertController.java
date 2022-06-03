package com.bit.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.bit.spring.model.EmpDao;
import com.bit.spring.model.EmpVo;

public class InsertController extends AbstractCommandController {
	
	@Autowired
	EmpDao<EmpVo> dao;
	
	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println(errors.hasErrors());
		EmpVo bean = (EmpVo) command;
		dao.insertOne(bean);
		return new ModelAndView("redirect:list");
	}
	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
			throws Exception {
		EmpVo bean = (EmpVo) command;
		if(bean.getEname().isEmpty()) {
			ObjectError error = new ObjectError("ename", "ename is empty");
			errors.addError(error );
		}
		
		System.out.println(errors);
	}
}
