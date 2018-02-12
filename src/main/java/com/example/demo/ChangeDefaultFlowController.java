package com.example.demo;

/*
 * Spring Social is quick and easy to start but it needs some configuring before it can be used for production.
 * The default flow for The Views are predefined so the user flow is
 *  login.html -> connect/facebookConnected.html by default,
 * irrespective of what our submit URL is, the facebook will override the flow and redirect you to connect/facebookConnected.html.
 *
 * We will add a ChangeDefaultFlowController  which will override the connectedView method and redirect
 * the flow to “/facebook”, “/google” or “/LinkedIn”
 */
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/connect")
public class ChangeDefaultFlowController extends ConnectController {

	public ChangeDefaultFlowController(ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository) {
		super(connectionFactoryLocator, connectionRepository);
	}
	
	@Override
    protected String connectedView(String providerId) {
        return "redirect:/"+providerId;
    }

}
