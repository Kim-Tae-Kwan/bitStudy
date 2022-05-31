package com.bit.spring.model;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {

	List<EmpVo> selectAll() throws SQLException;

	EmpVo selectOne(int parseInt) throws SQLException;

	void insertOne(EmpVo bean) throws SQLException;

	int updateOne(EmpVo bean) throws SQLException;

	int deleteOne(int empno) throws SQLException;

}