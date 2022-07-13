package com.bit.sts29.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity()
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http
			.authorizeRequests()
			.antMatchers("/", "/home").permitAll();
		http
			.authorizeRequests()
			.anyRequest().authenticated();
		
		http
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.permitAll();
		http
			.logout()
			.logoutUrl("/logout")
			.permitAll();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user =
				 User.builder()//.withDefaultPasswordEncoder()
					.username("user")
					.password(getPasswordEncoder().encode("1234"))
					.roles("USER")
					.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
