package com.daffodilsw.web.security;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by munish on 4/23/2015.
 */
public class EntryPoint implements AuthenticationEntryPoint, InitializingBean {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
        if ("XMLHttpRequest".equals(request.getHeader("X-Request-With"))) {
            response.sendError(HttpStatus.FORBIDDEN.value());
            return;
        }

        String url = request.getContextPath() + "/user/login";
        url += "?redirect=" + request.getRequestURI();

        response.sendRedirect(url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
