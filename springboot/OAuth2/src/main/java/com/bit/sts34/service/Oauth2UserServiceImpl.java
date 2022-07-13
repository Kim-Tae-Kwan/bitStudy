package com.bit.sts34.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class Oauth2UserServiceImpl extends DefaultOAuth2UserService {
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("oauth2 service run...");
		OAuth2User user = super.loadUser(userRequest);
		System.out.println(userRequest);
		System.out.println("==================================");
		System.out.println(userRequest.getAccessToken());
		System.out.println("==================================");
		System.out.println(userRequest.getClientRegistration());
		System.out.println("==================================");
		System.out.println(userRequest.getAdditionalParameters());
		System.out.println("==================================");
		System.out.println(user);
		System.out.println("==================================");
		System.out.println(user.getAttributes());
		System.out.println("==================================");

		
		return user;
	}
}
