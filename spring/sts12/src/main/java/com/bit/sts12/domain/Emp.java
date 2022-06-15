package com.bit.sts12.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	private int empno;
	private String ename;
	private int sal;
	private String job;
	private Timestamp hiredate;
}
