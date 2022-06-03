package com.bit.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


public class EmpDaoImpl4 implements EmpDao {
	JdbcTemplate jdbcTemplate;
	PlatformTransactionManager transactionManager;
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
	
	public EmpDaoImpl4(JdbcTemplate jdbcTemplate, PlatformTransactionManager transactionManager) {
		this.jdbcTemplate = jdbcTemplate;
		this.transactionManager = transactionManager;
	}
	
	@Override
	public List<EmpVo> selectAll() throws SQLException {
		String sql = "select * from emp";
		
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				return con.prepareStatement(sql);
			}
		};
		
		return jdbcTemplate.query(psc, rowMapper);
		
	}

	@Override
	public EmpVo selectOne(int empno) throws SQLException {
		String sql = "select * from emp=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, empno);
	}

	@Override
	public int insertOne(EmpVo bean) throws SQLException {
		
		TransactionStatus status=null;
		TransactionDefinition definition=new DefaultTransactionDefinition();
		status=transactionManager.getTransaction(definition);
		
		try {
			PreparedStatementCreator psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println("첫번째 conn:"+conn.hashCode());
					String sql="insert into emp (empno,ename,sal,job,hiredate) value (?,?,?,?,now())";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, bean.getEmpno());
					pstmt.setString(2, bean.getEname());
					pstmt.setInt(3, bean.getSal());
					pstmt.setString(4, bean.getJob());
					return pstmt;
				}
			};
			
			jdbcTemplate.update(psc);
			
			psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println("두번째 conn:"+conn.hashCode());
					String sql="insert into emp (empno,ename,sal,job,hiredate) value (?,?,?,?,now())";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, bean.getEmpno());
					pstmt.setString(2, bean.getEname());
					pstmt.setInt(3, bean.getSal());
					pstmt.setString(4, bean.getJob());
					return pstmt;
				}
			};
			jdbcTemplate.update(psc);
			
			transactionManager.commit(status);
			
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		return 1;
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
