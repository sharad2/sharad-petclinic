package com.example.demo.system;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.FacebookProvider;
import com.example.demo.model.UserBean;

@Controller
class WelcomeController {

	@Autowired
	FacebookProvider facebookProvider;

	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String loginToFacebook(Model model) {
		String x = facebookProvider.getFacebookUserData(model, new UserBean());
		return x;
	}
}
