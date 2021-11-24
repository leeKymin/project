package com.it.spring.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
	
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public AuthenticationFailureHandler authenticationFailureHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
			.antMatchers("/css/**", "/js/**", "/img/**").permitAll()
			.antMatchers("/guest/**").permitAll()
			.antMatchers("/member/**").hasAnyRole("USER", "ADMIN")
			.antMatchers("/admin/").hasRole("ADMIN")
			.anyRequest().authenticated();
//			.anyRequest().permitAll();
		
		http.formLogin().loginPage("/loginForm")
		.loginProcessingUrl("/j_spring_security_check")
//		.loginProcessingUrl("/loginauto")
//		.loginProcessingUrl("/aaa")
//		.defaultSuccessUrl("/")
//		.failureUrl("/loginForm?error")
		.failureHandler(authenticationFailureHandler)
		.usernameParameter("j_username")
		.passwordParameter("j_password").permitAll();
		
		http.logout().permitAll();
		
		http.csrf().disable();
	}
	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("123 => " + passwordEncoder().encode("123"));
//		
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("select email as userName, password, enabled from user_list2 where email=?")
//		.authoritiesByUsernameQuery("select email as userName, role from user_list2 where email=?")
//		.passwordEncoder(new BCryptPasswordEncoder());
//	}
//	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
