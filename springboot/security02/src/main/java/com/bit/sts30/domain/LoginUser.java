package com.bit.sts30.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
	private String username;
	private String password;
	private int enabled;
	private String authority;
}
