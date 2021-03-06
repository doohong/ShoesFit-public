package com.doohong.shoesfit.filter;

import com.doohong.shoesfit.error.ErrorCode;
import com.doohong.shoesfit.security.exception.CustomerNotFoundException;
import com.doohong.shoesfit.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {
    private final JwtTokenProvider jwtTokenProvider;

//    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String token = jwtTokenProvider.resolveToken((HttpServletRequest) servletRequest);
        if (token != null && jwtTokenProvider.validateToken(token)) {
            Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
