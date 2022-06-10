package com.bit.sts07.model;

import java.util.List;

public interface EmpDao {
	List<EmpVo> findAll() throws Exception;
	EmpVo find(int idx) throws Exception;
	void insertOne(EmpVo bean) throws Exception;
	int updateOne(EmpVo bean) throws Exception;
	int deleteOne(int idx) throws Exception;
	int allSize() throws Exception;
}
