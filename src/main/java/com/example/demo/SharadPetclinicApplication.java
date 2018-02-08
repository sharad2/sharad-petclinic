package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
//To make the link to Facebook we need an @EnableOAuth2Sso annotation on our main class:
@EnableOAuth2Sso
public class SharadPetclinicApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SharadPetclinicApplication.class, args);
	}
	
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .antMatcher("/**")
	      .authorizeRequests()
	        .antMatchers("/", "/login**", "/webjars/**", "/resources/**")
	        .permitAll()
	      .anyRequest()
	        .authenticated();
	  }

}
