package com.bit.sts07.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDaoImpl01 implements DeptDao {

	@Autowired
	SqlSession session;
	
	@Override
	public List<DeptVo> findAll() throws Exception {
		return session.selectList("dept.selectAll");
	}

	@Override
	public DeptVo find(int idx) throws Exception {
		return session.selectOne("dept.selectOne", idx);
	}

	@Override
	public void insertOne(DeptVo bean) throws Exception {
		session.insert("dept.addOne", bean);
	}

	@Override
	public int updateOne(DeptVo bean) throws Exception {
		return session.update("dept.updateOne", bean);
	}

	@Override
	public int deleteOne(int idx) throws Exception {
		return session.delete("dept.deleteOne", idx);
	}

	@Override
	public int allSize() throws Exception {
		return 0;
	}

}
