package com.bit.sts22.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.sts22.domain.Emp;
import com.bit.sts22.domain.EmpMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ApiServiceImpl {
	
	private final EmpMapper empMapper;
	
	public List<Emp> selectAll(){
		return empMapper.findAll();
	}
	
	public Emp selectOne(int empno) {
		return empMapper.findOne(empno);
	}
	
	public int size() {
		return empMapper.findSize();
	}
	
	public boolean insert(Emp emp) {
		return empMapper.insertOne(emp) > 0 ? true : false;
	}
	public Emp update(Emp emp) {
		return empMapper.updateOne(emp) > 0 ? emp : null;
	}
	public Emp delete(int empno) {
		Emp emp = selectOne(empno);
		if(emp != null) empMapper.deleteOne(empno);
		return emp;
	}
}
