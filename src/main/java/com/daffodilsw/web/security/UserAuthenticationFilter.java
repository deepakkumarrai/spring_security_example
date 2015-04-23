package com.daffodilsw.web.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by user on 16/4/15.
 */
public class UserAuthenticationFilter extends GenericFilterBean {

    private AuthenticationManager authenticationManager;

    public UserAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
