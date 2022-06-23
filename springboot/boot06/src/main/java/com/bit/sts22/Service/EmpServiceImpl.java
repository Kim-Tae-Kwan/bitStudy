package com.bit.sts22.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.sts22.domain.Emp;
import com.bit.sts22.repository.EmpRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EmpServiceImpl {
	
	@Autowired
	private EmpRepository empRepository;
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	
	public List<Emp> selectAll() {
		log.debug(session.getId());
		return empRepository.findAll();
	}
	
	public Emp insertOne(Emp bean) {
		log.debug(request.getMethod());
		log.debug(session.getId());
		if(empRepository.insertOne(bean) > 0) return bean;
		return null;
	}
}
