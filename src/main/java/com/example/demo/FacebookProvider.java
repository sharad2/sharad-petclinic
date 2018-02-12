package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.model.UserBean;


@Service
public class FacebookProvider  {

	private static final String FACEBOOK = "facebook";
	private static final String REDIRECT_LOGIN = "redirect:/login";

    	@Autowired
    	BaseProvider baseProvider ;
    	

	public String getFacebookUserData(Model model, UserBean userForm) {

		ConnectionRepository connectionRepository = baseProvider.getConnectionRepository();
		if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
			return REDIRECT_LOGIN;
		}
		populateUserDetailsFromFacebook(userForm);
		model.addAttribute("loggedInUser",userForm);
		return "user";
	}

	protected void populateUserDetailsFromFacebook(UserBean userForm) {
		Facebook facebook = baseProvider.getFacebook();
		/* https://stackoverflow.com/questions/39890885/error-message-is-12-bio-field-is-deprecated-for-versions-v2-8-and-higher */
		String [] fields = 
			{ "id", "about", "age_range", "birthday", "context", "cover", "currency",
					"devices", "education", "email", "favorite_athletes", "favorite_teams",
					"first_name", "gender", "hometown", "inspirational_people", "installed",
					"install_type", "is_verified", "languages", "last_name", "link", "locale",
					"location", "meeting_for", "middle_name", "name", "name_format", "political",
					"quotes", "payment_pricepoints", "relationship_status", "religion", "security_settings",
					"significant_other", "sports", "test_group", "timezone", "third_party_id", "updated_time",
					"verified", "video_upload_limits", "viewer_can_send_gift", "website", "work"};
		//User user = facebook.userOperations().getUserProfile();
		User user = facebook.fetchObject("me", User.class, fields);
		userForm.setEmail(user.getEmail());
		userForm.setFirstName(user.getFirstName());
		userForm.setLastName(user.getLastName());
		userForm.setImage(user.getCover().getSource());
		userForm.setProvider(FACEBOOK);
	}

	 

}
