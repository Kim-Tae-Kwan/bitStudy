package com.bit.sts12.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.bit.sts12.domain.Emp;

import lombok.Delegate;

@Mapper
public interface EmpRepo {
	
	@Select("select * from emp")
	List<Emp> findAll();
	@Select("select * from emp where empno=#{val}")
	Emp findOne(int idx);
	@Insert("insert into emp (empno, ename, sal, job, hiredate) values (#{empno}, #{ename}, #{sal}, #{job}, now())")
	int insertOne(Emp bean);
	int updateOne(Emp bean);
	
	@Delete("delete from emp where empno = #{val}")
	int deleteOne(int idx);
}
