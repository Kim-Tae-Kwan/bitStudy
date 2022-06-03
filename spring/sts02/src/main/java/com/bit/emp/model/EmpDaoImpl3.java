package com.bit.emp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class EmpDaoImpl3 implements EmpDao {
	JdbcTemplate jdbcTemplate;
	RowMapper<EmpVo> rowMapper = new RowMapper<EmpVo>() {
		
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(
					rs.getInt("empno"),
					rs.getString("ename"),
					rs.getInt("sal"),
					rs.getString("job"),
					rs.getDate("hiredate")
					);
		}
	};
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<EmpVo> selectAll() throws SQLException {
		String sql = "select * from emp";
		return jdbcTemplate.query(sql, rowMapper);
		
	}

	@Override
	public EmpVo selectOne(int empno) throws SQLException {
		String sql = "select * from emp=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, empno);
	}

	@Override
	public int insertOne(EmpVo bean) throws SQLException {
		String sql = "insert into emp (empno, ename, sal, job, hiredate) values (?,?,?,?,now())";
		return jdbcTemplate.update(sql, bean.getEmpno(), bean.getEname(), bean.getSal(), bean.getJob());
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		String sql = "update emp set ename=?, sal=?, job=? where empno=?";
		return jdbcTemplate.update(sql, bean.getEname(), bean.getSal(), bean.getJob(), bean.getEmpno());
	}

	@Override
	public int deleteOne(int empno) throws SQLException {
		String sql = "delete from emp where empno=?";
		return jdbcTemplate.update(sql, empno);
	}
}
