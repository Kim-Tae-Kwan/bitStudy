package com.bit.sts06.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts06.domain.EmpDao;
import com.bit.sts06.domain.EmpVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	EmpDao<EmpVo> empDao;
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public void list(HttpServletResponse res) throws Exception{
		res.setContentType("application/json; charset=utf-8");
		PrintWriter out = res.getWriter();

		JsonArray arr=new JsonArray();
		for(EmpVo bean: empDao.findAll()) {
			JsonObject json = new JsonObject();
			json.addProperty("empno", bean.getEmpno());
			json.addProperty("ename", bean.getEname());
			json.addProperty("sal", bean.getSal());
			json.addProperty("job", bean.getJob());
			json.addProperty("hiredate", bean.getHiredate()==null?"":bean.getHiredate().getTime()+"");
			arr.add(json);
		}
		res.getWriter().print(arr.toString());
		
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public void add(HttpServletResponse res, @ModelAttribute EmpVo bean) throws Exception {
		empDao.insertOne(bean);
		res.setStatus(HttpServletResponse.SC_OK);
		
	}
	
	@RequestMapping(value = "/emp/{empno}", method = RequestMethod.GET)
	public void detail(HttpServletResponse res, @PathVariable int empno) throws Exception {
		res.setContentType("application/json; charset=utf-8");
		res.setStatus(HttpServletResponse.SC_OK);
		
		EmpVo bean = empDao.findOne(empno);
		
		PrintWriter out = res.getWriter();
		
		JsonObject json = new JsonObject();
		json.addProperty("empno", bean.getEmpno());
		json.addProperty("ename", bean.getEname());
		json.addProperty("sal", bean.getSal());
		json.addProperty("job", bean.getJob());
		json.addProperty("hiredate", bean.getHiredate()==null?"":bean.getHiredate().getTime()+"");
		
		out.print(json.toString());
		
	}
	
	@RequestMapping(value = "/emp/{empno}", method = RequestMethod.PUT)
	public void testApi(@PathVariable int empno, HttpServletRequest req, HttpServletResponse res) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(), StandardCharsets.UTF_8));
		Gson gson = new Gson();
		EmpVo bean = gson.fromJson(br.readLine(), EmpVo.class);
		log.info(bean.toString());
		empDao.updateOne(bean);
		res.setStatus(HttpServletResponse.SC_OK);
		
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.PUT)
	public void testApi(HttpServletResponse res) throws IOException {
		String msg = "";
		
		res.setStatus(HttpServletResponse.SC_OK);
		
	}
	
}
