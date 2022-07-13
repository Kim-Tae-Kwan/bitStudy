package com.bit.sts30.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bit.sts30.config.SecureUser;
import com.bit.sts30.domain.LoginUser;
import com.bit.sts30.repository.LoginMapper;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoginUser user = loginMapper.findUser(username);
		return new SecureUser(user);
	}

}
