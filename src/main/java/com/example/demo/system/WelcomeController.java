package com.example.demo.system;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class WelcomeController {

	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
}
