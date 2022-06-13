package com.bit.sts08.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bit.sts08.repository.Emp;

public interface EmpService {

	void selectAll(Model model) throws Exception;
	void select(Model model, int idx) throws Exception;
	Emp insertOne(Emp bean) throws Exception;
	Emp detail(int empno) throws Exception;
	Emp update(Emp bean) throws Exception;
	boolean delete(int idx) throws Exception;
	boolean login(Emp bean, HttpServletRequest req);
	void logout(HttpServletRequest req);

}