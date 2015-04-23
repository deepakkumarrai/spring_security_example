package com.daffodilsw.web.security;

import com.daffodilsw.core.data.jpa.service.UserService;
import com.daffodilsw.core.data.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by user on 16/4/15.
 */
public class UserAuthenticationProvider implements AuthenticationProvider {

    private UserService userService;

    public UserAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof UserAuthentication) {
            User user = userService.getOneByPrincipleAndCredentials((String) authentication.getPrincipal(),
                    (String) authentication.getCredentials());
            if (user != null) {
                return new UserAuthentication(user);
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UserAuthentication.class.isAssignableFrom(authentication);
    }
}
