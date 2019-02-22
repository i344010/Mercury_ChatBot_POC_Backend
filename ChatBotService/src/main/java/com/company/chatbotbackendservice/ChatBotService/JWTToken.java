package com.company.chatbotbackendservice.ChatBotService;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;*/


@WebServlet("/chatbotservice/jwttoken")
public class JWTToken extends HttpServlet {

@Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response )
            throws ServletException, IOException
    {
        response.setContentType("text/plain");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
 
            response.getOutputStream().println(key+" : "+value);
        }
    
    	
/*    	String accessToken = null;
		SecurityContext ctx = SecurityContextHolder.getContext();
		if (ctx != null) {
			Authentication auth = ctx.getAuthentication();
			if (auth != null) {
				OAuth2AuthenticationDetails authDetails = (OAuth2AuthenticationDetails) auth.getDetails();
				accessToken = authDetails.getTokenValue();
			}
		}
		response.getOutputStream().println(" : "+ "Bearer " + accessToken);*/
    }
    
}
