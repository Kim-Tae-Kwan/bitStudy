package com.bit.sts11.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@MapperScan(basePackages = {"com.bit.sts11.repository"})
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/scott");
		dataSource.setUsername("user01");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		
		return sessionFactoryBean.getObject();
	}
	
//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		JdbcTemplate jdbcTemplate = new JdbcTemplate();
//		jdbcTemplate.setDataSource(dataSource());
//		
//		return jdbcTemplate;
//	}
	
//	@Bean
//	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource());
//		
//		Resource[] resource = new Resource[1];
//		resource[0] = new ClassPathResource("/mapper/DeptMapper.xml");
//		sessionFactoryBean.setMapperLocations(resource);
//
//		return sessionFactoryBean.getObject();
//	}
//	
//	@Bean
//	public SqlSession sqlSession() throws Exception {
//		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean());
//		return sessionTemplate;
//	}
}
