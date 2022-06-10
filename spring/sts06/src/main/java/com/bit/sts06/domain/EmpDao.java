package com.bit.sts06.domain;

import java.util.List;

public interface EmpDao<T> {
	
	List<T> findAll() throws Exception;
	T findOne(int idx) throws Exception;
	void insertOne(T bean) throws Exception;
	int updateOne(T bean) throws Exception;
	int deleteOne(int idx) throws Exception;
	int findSize() throws Exception;
}
