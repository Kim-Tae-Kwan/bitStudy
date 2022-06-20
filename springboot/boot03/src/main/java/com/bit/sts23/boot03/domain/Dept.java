package com.bit.sts23.boot03.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
}
