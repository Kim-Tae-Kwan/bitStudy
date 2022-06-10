package com.bit.sts06.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmpDaoTest {
	static EmpDao<EmpVo> empDao;
	//Logger log = org.slf4j.LoggerFactory.getLogger(getClass());
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		empDao = context.getBean(EmpDao.class);
	}

	@Before
	public void setUp() throws Exception {
	}

	public void test() throws Exception {
		assertNotNull(empDao);
		assertNotNull(empDao.findAll());
		
		for(EmpVo bean : empDao.findAll()) {
			log.debug(bean.toString());
		}
	}
	
	public void test2() throws Exception {
		assertNotNull(empDao);
		assertNotNull(empDao.findOne(1));
	}
	
	@Test
	@Transactional()
	public void test3() throws Exception{
		assertNotNull(empDao);
		EmpVo bean = EmpVo.builder()
							.empno(795)
							.ename("test")
							.sal(4000)
							.job("tester")
							.build();
		int before = empDao.findAll().size();
		empDao.insertOne(bean);
		assertEquals(before + 1, empDao.findAll().size());
		throw new RuntimeException();
	}
	
	public void test4() throws Exception{
		log.debug(empDao.findSize() + ""); 
	}
}
