package com.bit.sts23.boot03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.sts23.boot03.domain.Dept;
import com.bit.sts23.boot03.domain.DeptMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestServiceImpl {
	
	private final DeptMapper deptMapper;
	
	public List<Dept> selectAll(){
		return deptMapper.findAll();
	}
	
	public Dept selectOne(int deptno){
		return deptMapper.findOne(deptno);
	}
	
	public int insert(Dept dept) {
		return deptMapper.insertOne(dept);
	}
	
	public int update(Dept dept) {
		return deptMapper.updateOne(dept);
	}
	
	public int delete(int deptno) {
		return deptMapper.deleteOne(deptno);
	}
	
}
