package com.bit.sts08.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.bit.sts08.repository.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class EmpServiceImplTest {

	@Autowired
	EmpService empService;
	Model model;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1Select() throws Exception {
		model = new ExtendedModelMap();
		assertNotNull(model);
		empService.selectAll(model);
		
		Map<String, Object> map = model.asMap();
		Set<Entry<String, Object>> entrys = map.entrySet();
		for(Entry<String, Object> entry : entrys) {
			log.debug(entry.getKey());
			log.debug(entry.getValue().toString());
		}
	}
	
	@Test
	@Transactional
	public void test2Insert() throws Exception {
		Emp target = Emp.builder()
				.empno(7071)
				.ename("test")
				.job("tester")
				.sal(4000)
				.build();
		
		assertEquals(target, empService.insertOne(target));
	}
	
	@Test
	public void test3Detail() throws Exception {
		Emp target = Emp.builder()
				.empno(7070)
				.ename("test")
				.job("tester")
				.sal(4000)
				.build();
		assertEquals(target, empService.detail(target.getEmpno()));
	}
	
	@Test
	@Transactional
	public void test4Update() throws Exception {
		Emp target = Emp.builder()
				.empno(7070)
				.ename("test2")
				.job("tester2")
				.sal(4000)
				.build();
		empService.update(target);
		assertEquals(target, empService.detail(target.getEmpno()));
	}
	
	@Test
	@Transactional
	public void test5Delete() throws Exception {
		Emp target = Emp.builder()
				.empno(7070)
				.ename("test")
				.job("tester")
				.sal(4000)
				.build();
		
		assertNotEquals(0, empService.delete(target.getEmpno()));
		assertEquals(null, empService.detail(target.getEmpno()));
	}
	
	
}
