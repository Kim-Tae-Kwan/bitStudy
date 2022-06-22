package com.bit.sts22.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.sts22.domain.Emp;
import com.bit.sts22.repository.EmpRepository;

@Service
public class EmpServiceImpl {
	
	@Autowired
	private EmpRepository empRepository;
	
	public List<Emp> selectAll() {
		return empRepository.findAll();
	}
	
	public Emp insertOne(Emp bean) {
		if(empRepository.insertOne(bean) > 0) return bean;
		return null;
	}
}
