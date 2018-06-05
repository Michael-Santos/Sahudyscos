package com.sahudyscos.web.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
 
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
 
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);
        
        boolean admin = false;

        logger.info(String.valueOf(authentication.getAuthorities()));
        
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if ("ADMIN".equals(auth.getAuthority())){
                admin = true;
                logger.info("Admin logged in!");
            }
        }
        
        if(admin){
        	response.sendRedirect("/admin/home");
        }else{
        	response.sendRedirect("/");
        }
	}
}