package com.bit.sts08.repository;

import java.util.List;

public interface EmpDao {
	List<Emp> findAll() throws Exception;
	Emp find(int idx) throws Exception;
	int insertOne(Emp bean) throws Exception;
	int updateOne(Emp bean) throws Exception;
	int deleteOne(int idx) throws Exception;
	int allSize() throws Exception;
	List<Emp> findMany(String val) throws Exception;
	int login(Emp bean);
}
