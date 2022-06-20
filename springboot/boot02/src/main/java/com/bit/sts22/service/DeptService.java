package com.bit.sts22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts22.domain.Dept;
import com.bit.sts22.repository.DeptDao;

@Service
public class DeptService {
	
	@Autowired
	DeptDao deptDao;
	
	public void selectAll(Model model){
		model.addAttribute("list", deptDao.findAll());
	}
	
	public void selectOen(String modelName, int deptno, Model model) {
		model.addAttribute(modelName, deptDao.findOne(deptno));
	}
	
	public void insertOen(Dept bean, Model model) {
		model.addAttribute("bean", deptDao.insertOne(bean));
	}
	
	public void updateOen(Dept bean, Model model) {
		model.addAttribute("bean", deptDao.updateOne(bean));
	}
	
	public void deleteOen(int deptno) {
		deptDao.deleteOne(deptno);
	}
	

}
