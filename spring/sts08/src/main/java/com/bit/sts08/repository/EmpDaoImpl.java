package com.bit.sts08.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EmpDaoImpl implements EmpDao{
	
	@Autowired
	SqlSession session;
	
	@Override
	public List<Emp> findAll() throws Exception {
		return session.selectList("emp.findAll");
	}

	@Override
	public Emp find(int idx) throws Exception {
		return session.selectOne("emp.find", idx);
	}

	@Override
	public int insertOne(Emp bean) throws Exception {
		return session.insert("emp.insertOne", bean);
	}

	@Override
	public int updateOne(Emp bean) throws Exception {
		return session.update("emp.updateOne", bean);
	}

	@Override
	public int deleteOne(int idx) throws Exception {
		return session.delete("emp.deleteOne", idx);
	}

	@Override
	public int allSize() throws Exception {
		return session.selectOne("emp.totalSize");
	}

	@Override
	public List<Emp> findMany(String val) throws Exception {
		return session.selectList("emp.findMany", val);
	}
	
	@Override
	public int login(Emp bean) {
		return session.selectOne("emp.login", bean);
	}
	
}
