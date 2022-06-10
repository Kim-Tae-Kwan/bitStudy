package com.bit.sts07.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl01 implements EmpDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	RowMapper<EmpVo> mapper = new RowMapper<EmpVo>() {
		
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return EmpVo.builder()
					.empno(rs.getInt("empno"))
					.ename(rs.getString("ename"))
					.sal(rs.getInt("sal"))
					.job(rs.getString("job"))
					.hiredate(rs.getTimestamp("hiredate"))
					.build();
		}
	};
	
	@Override
	public List<EmpVo> findAll() throws Exception {
		String sql = "select * from emp";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public EmpVo find(int idx) throws Exception {
		String sql = "select * from emp where empno=?";
		return jdbcTemplate.queryForObject(sql, mapper, idx);
	}

	@Override
	public void insertOne(EmpVo bean) throws Exception {
		String sql = "insert into emp (empno, ename, sal, job, hiredate) "
				+ "values (?,?,?,?,now())";
		jdbcTemplate.update(sql, bean.getEmpno(), bean.getEname(), bean.getSal(), bean.getJob());
	}

	@Override
	public int updateOne(EmpVo bean) throws Exception {
		String sql = "update emp set ename=?, sal=?, job=? where empno=?";
		return jdbcTemplate.update(sql, bean.getEname(), bean.getSal(), bean.getJob(), bean.getEmpno());
	}

	@Override
	public int deleteOne(int idx) throws Exception {
		String sql = "delete from emp where empno=?";
		return jdbcTemplate.update(sql, idx);
	}

	@Override
	public int allSize() throws Exception {
		return 0;
	}
	
}
