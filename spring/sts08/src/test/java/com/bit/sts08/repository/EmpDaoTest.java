package com.bit.sts08.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDaoTest {

	@Autowired
	EmpDao empDao;
	static int total;
	static Emp bean;
	
	@BeforeClass
	public static void start() {
		bean = Emp.builder()
				.empno(7777)
				.ename("test")
				.sal(4000)
				.job("tester")
				.build();
	}
	
	@Test
	public void test1FindAll() throws Exception {
		assertNotNull(empDao.findAll());
		total = empDao.findAll().size();
	}
	
	@Test
	public void test2FindOne() throws Exception {
		assertNotNull(empDao.find(1));
		log.debug(empDao.find(1).toString());
	}
	
	@Test
	@Transactional
	public void test2insertOne() throws Exception {
		assertNotEquals(0, empDao.insertOne(bean));
		log.debug(empDao.find(bean.getEmpno()).toString());
	}
	
	@Test
	@Transactional
	public void test3UpdateOne() throws Exception {
		Emp emp = empDao.find(1);
		assertNotNull(emp);
		emp.setEname("edit");
		assertTrue(empDao.updateOne(emp) > 0);
		assertEquals(emp.getEname(), empDao.find(emp.getEmpno()).getEname());
		assertEquals(emp.getJob(), empDao.find(emp.getEmpno()).getJob());
		assertEquals(emp.getSal(), empDao.find(emp.getEmpno()).getSal());
	}
	
	@Test
	@Transactional
	public void test4DeleteOne() throws Exception {
		assertTrue(empDao.deleteOne(1) > 0);
		assertNull(empDao.find(1));
	}
	
	@Test
	public void test5AllSize() throws Exception {
		assertEquals(total, empDao.allSize());
	}
	
	@Test
	@Transactional
	public void test6FindMany() throws Exception {
		
		for(Emp bean : empDao.findMany("еб")) {
			log.debug(bean.toString());
		}
	}
	
	

}

