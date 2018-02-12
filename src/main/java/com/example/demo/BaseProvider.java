package com.example.demo;

/*
 * For Facebook, Google and LinkedIn we will create a Provider class which will be used to do authentication
 * and save user details to the UserBean, which can be later displayed on the page.
 * To start off with we will create a BaseProvider which will have a constructor where all the providers will be initialized.

 * This BaseProvider is created by injecting the Facebook, Google, LinkedIn and ConnectionRepository repository.
 * These objects are a reference to Spring Social’s Facebook, Google, LinkedIn and ConnectionRepository API binding.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.google.api.Google;
import org.springframework.social.linkedin.api.LinkedIn;

@Configuration
@Scope(value = "request",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BaseProvider {

	private Facebook facebook;
	private Google google;
	private LinkedIn linkedIn;
	private ConnectionRepository connectionRepository;
	
	public  BaseProvider(Facebook facebook,Google google,  LinkedIn linkedIn, ConnectionRepository connectionRepository) {
		this.facebook = facebook;
		this.connectionRepository = connectionRepository;
		this.google=google; 
		this.linkedIn= linkedIn;
	}

	public Facebook getFacebook() {
		return facebook;
	}

	public void setFacebook(Facebook facebook) {
		this.facebook = facebook;
	}

	public ConnectionRepository getConnectionRepository() {
		return connectionRepository;
	}

	public void setConnectionRepository(ConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
	}

	public Google getGoogle() {
		return google;
	}

	public void setGoogle(Google google) {
		this.google = google;
	}

	public LinkedIn getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(LinkedIn linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	

}
