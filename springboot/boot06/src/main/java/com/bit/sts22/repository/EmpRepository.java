package com.bit.sts22.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.bit.sts22.domain.Emp;

@Mapper
public interface EmpRepository {
	
	@Select("SELECT * FROM emp")
	public List<Emp> findAll();
	
	@Select("SELECT * FROM emp")
	public List<Emp> findOne(int empno);
	
	@Options(keyProperty = "empno", useGeneratedKeys = true)
	@Insert("INSERT INTO emp (ename, pay, hire_date) values (#{ename}, #{pay}, now())")
	public int insertOne(Emp emp);
}
