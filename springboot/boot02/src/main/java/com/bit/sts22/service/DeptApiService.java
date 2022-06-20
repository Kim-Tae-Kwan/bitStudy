package com.bit.sts22.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts22.domain.Dept;
import com.bit.sts22.repository.DeptDao;

@Service
public class DeptApiService {
	@Autowired
	DeptDao deptDao;
	
	public List<Dept> selectAll(){
		return deptDao.findAll();
	}
	
	public Dept selectOne(int deptno) {
		return deptDao.findOne(deptno);
	}
	
	public int insertOne(Dept bean) {
		return deptDao.insertOne(bean);
	}
	
	public int updateOne(Dept bean) {
		return deptDao.updateOne(bean);
	}
	
	public int deleteOne(int deptno) {
		return deptDao.deleteOne(deptno);
	}
}
