package com.bit.emp.model;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface EmpDao {
	
	List<EmpVo> selectAll() throws SQLException;
	EmpVo selectOne(int empno) throws SQLException;
	int insertOne(EmpVo bean) throws SQLException;
	int updateOne(EmpVo bean) throws SQLException;
	int deleteOne(int empno) throws SQLException;

}
