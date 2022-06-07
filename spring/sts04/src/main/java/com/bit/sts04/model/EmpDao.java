package com.bit.sts04.model;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao<T> {
	List<T> findAll() throws SQLException;
	T find(int empno) throws SQLException;
	void insertOne(T bean) throws SQLException;
	int updateOne(T bean) throws SQLException;
	int deleteOne(int empno) throws SQLException;
}
