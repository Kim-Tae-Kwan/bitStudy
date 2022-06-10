package com.bit.sts05.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao<EmpVo> {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	RowMapper<EmpVo> mapper = new RowMapper<EmpVo>() {
		
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(
					rs.getInt("empno"),
					rs.getInt("sal"),
					rs.getString("ename"),
					rs.getString("job"),
					rs.getTimestamp("hiredate")
					);
		}
	};
	
	@Override
	public List<EmpVo> findAll() throws SQLException {
		String sql = "select * from emp";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public EmpVo findOne(int idx) throws SQLException {
		String sql = "select * from emp where empno = ?";
		return jdbcTemplate.queryForObject(sql, mapper, idx);
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		String sql = "insert into emp (empno, ename, sal, job, hiredate) values (?,?,?,?,now())";
		jdbcTemplate.update(sql, bean.getEmpno(), bean.getEname(), bean.getSal(), bean.getJob());
	}

	@Override
	public int updateOne(EmpVo t) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int idx) throws SQLException {
		return 0;
	}

}
