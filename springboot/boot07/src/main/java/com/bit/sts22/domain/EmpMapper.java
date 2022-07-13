package com.bit.sts22.domain;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpMapper {
	
	@Select("select * from emp")
	public List<Emp> findAll();
	
	@Select("select * from emp where empno = #{empno}")
	public Emp findOne(int empno);
	
	@Select("select count(*) from emp")
	public int findSize();
	
	@Options(keyColumn = "empno", useGeneratedKeys = true)
	@Insert("insert into emp (ename, pay, hire_date) values (#{ename}, #{pay}, now())")
	public int insertOne(Emp emp);
	
	@Update("update emp set ename = #{ename}, pay = #{pay} where empno = #{empno}")
	public int updateOne(Emp emp);
	
	@Delete("delete from emp where empno = #{empno}")
	public int deleteOne(int empno);
}
