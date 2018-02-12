package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// To make the link to Facebook we need an @EnableOAuth2Sso annotation on our
// main class:
//@EnableOAuth2Client
public class SharadPetclinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharadPetclinicApplication.class, args);
	}
	
}

