package com.bit.sts22.domain;

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
	private int pay;
	private Timestamp hire_date;
}
