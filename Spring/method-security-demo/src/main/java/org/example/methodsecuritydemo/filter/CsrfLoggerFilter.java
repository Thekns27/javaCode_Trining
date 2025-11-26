package org.example.methodsecuritydemo.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CsrfLoggerFilter extends OncePerRequestFilter {
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        CsrfToken o = (CsrfToken) request.getAttribute("csrf");
        logger.info("Csrf token: " + o.getToken());
        filterChain.doFilter(request, response);
    }
}
