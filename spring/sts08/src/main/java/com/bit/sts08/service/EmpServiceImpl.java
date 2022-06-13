package com.bit.sts08.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bit.sts08.repository.Emp;
import com.bit.sts08.repository.EmpDao;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpDao empDao;
	
	@Override
	public void selectAll(Model model) throws Exception {
		model.addAttribute("list", empDao.findAll());
		model.addAttribute("total", empDao.allSize());
	}
	
	@Override
	public void select(Model model, int idx) throws Exception {
		model.addAttribute("bean", empDao.find(idx));
	}
	
	@Override
	@Transactional
	public Emp insertOne(Emp bean) throws Exception {
		empDao.insertOne(bean);
		return empDao.find(bean.getEmpno());
	}
	
	@Override
	public Emp detail(int empno) throws Exception {
		return empDao.find(empno);
	}
	
	@Override
	public Emp update(Emp bean) throws Exception {
		empDao.updateOne(bean);
		return empDao.find(bean.getEmpno());
	}
	
	@Override
	public boolean delete(int idx) throws Exception {
		return empDao.deleteOne(idx) > 0;
	}
	
	@Override
	public boolean login(Emp bean, HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(empDao.login(bean) > 0) {
			session.setAttribute("result", true);
			session.setAttribute("user", bean.getEname());
			return true;
		}
		
		return false;
	}
	
	@Override
	public void logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
	}
}
