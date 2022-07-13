package com.bit.sts30.config;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.bit.sts30.domain.LoginUser;

import lombok.Data;

@Data
public class SecureUser extends User {
	private LoginUser loginUser;

	public SecureUser(LoginUser user) {
		super(user.getUsername(), 
				user.getPassword(), 
				AuthorityUtils.createAuthorityList(user.getAuthority()));
		loginUser = user;
	}
	
}
