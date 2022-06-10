package com.bit.sts07.model;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVo {
	private int empno;
	private String ename;
	private int sal;
	private String job;
	private Timestamp hiredate;
}
