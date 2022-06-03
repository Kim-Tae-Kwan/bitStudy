package com.bit.emp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class EmpDaoImpl2 extends JdbcDaoSupport implements EmpDao {

	@Override
	public List<EmpVo> selectAll() throws SQLException {
		String sql = "select * from emp";
		
		RowMapper<EmpVo> rowMapper = new RowMapper<EmpVo>() {
			
			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"),
						rs.getString("ename"),
						rs.getInt("sal"),
						null,
						rs.getDate("hiredate")
						);
			}
		};
		
		return getJdbcTemplate().query(sql, rowMapper);
	}

	@Override
	public EmpVo selectOne(int empno) throws SQLException {
		String sql = "select * from emp where empno=?";
		
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
		
		return getJdbcTemplate().queryForObject(sql, rowMapper, empno);
	}

	@Override
	public int insertOne(EmpVo bean) throws SQLException {
		String sql = "insert into emp (empno, ename, sal, job, hiredate) values (?,?,?,?,now())";
		return getJdbcTemplate().update(sql, bean.getEmpno(), bean.getEname(), bean.getSal(), bean.getJob());
		
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		String sql = "update emp set ename=?, sal=?, job=? where empno=?";
		return getJdbcTemplate().update(sql, bean.getEname(), bean.getSal(), bean.getJob(), bean.getEmpno());
	}

	@Override
	public int deleteOne(int empno) throws SQLException {
		String sql = "delete from emp where empno=?";
		return getJdbcTemplate().update(sql, empno);
	}

	
	
}
