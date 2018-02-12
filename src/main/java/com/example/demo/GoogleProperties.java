package com.example.demo;

/*
 * this is needed so when we add secret keys in properties file for google. We wont see any error.
 */
import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.social.google")

public class GoogleProperties extends SocialProperties{

	
}
