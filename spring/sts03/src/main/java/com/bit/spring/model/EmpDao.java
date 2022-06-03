package com.bit.spring.model;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao<T> {
	List<T> findAll() throws SQLException;
	T findOne(int empno) throws SQLException;
	void insertOne(T bean) throws SQLException;
	int updateOen(T bean) throws SQLException;
	int deleteOne(int num) throws SQLException;
}
