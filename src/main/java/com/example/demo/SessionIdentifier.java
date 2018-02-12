package com.example.demo;

/*
 * If you test the Spring Facebook example, accessing FB data you will realise that it only supports one user.
 * So when the first users log in to Facebook, only his details will be shared across all new sessions/users and
 * they won’t be asked for any kind of authentication. One of the forum says that this example is supposed
 * to demonstrate what can be done and is not intended for production use.
 *
 * To fix this problem you need to override a method which always returns a string called “anonymous”.
 * The solution is to override the “anonymous” as the UserId for each new user/session.
 * So for each session, we can simply return a SessionID, however, it may not be unique enough to identify users,
 * especially if it’sh being cached or stored somewhere in a connection database.
 * Using a Universally Unique Identifier(UUID) would be a safer bet.So we will store a new UUID in session
 * so it persists between different requests but is alive only till the session is valid.
 * See the below method which does the trick.
 */

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;


@Configuration
public class SessionIdentifier extends SocialConfigurerAdapter
{

    @Override
    public UserIdSource getUserIdSource() {
        return new SessionIdUserIdSource();
    }

    private static final class SessionIdUserIdSource implements UserIdSource {
    	@Override
        public String getUserId() {
            RequestAttributes request = RequestContextHolder.currentRequestAttributes();
            String uuid = (String) request.getAttribute("_socialUserUUID", RequestAttributes.SCOPE_SESSION);
            if (uuid == null) {
                uuid = UUID.randomUUID().toString();
                request.setAttribute("_socialUserUUID", uuid, RequestAttributes.SCOPE_SESSION);
            }
            return uuid;
        }
    }
}