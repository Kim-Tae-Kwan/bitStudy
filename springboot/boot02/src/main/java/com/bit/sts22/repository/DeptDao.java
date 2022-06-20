package com.bit.sts22.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.sts22.domain.Dept;

@Mapper
public interface DeptDao {
	
	@Select("select * from dept order by deptno")
	List<Dept> findAll();
	
	@Select("select * from dept where deptno = #{val}")
	Dept findOne(int idx);
	
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
	int insertOne(Dept dept);
	
	@Update("update dept set dname = #{dname}, loc = #{loc} where deptno = #{deptno}")
	int updateOne(Dept dept);
	
	@Delete("delete from dept where deptno = #{deptno}")
	int deleteOne(int idx);
}
