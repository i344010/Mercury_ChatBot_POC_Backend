package com.company.chatbotbackendservice.ChatBotService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.OutputStreamWriter;


import com.sap.xs2.security.container.SecurityContext;
import com.sap.xs2.security.container.UserInfoException;
import com.sap.xs2.security.container.UserInfo;

@WebServlet("/chatbotservice/userinfo")
public class UserInfoService extends HttpServlet{

private static final long serialVersionUID = 1L;

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().println( request.getUserPrincipal());
		//SecurityContext ctx = SecurityContextHolder.getContext();
		
		UserInfo userInfo = null;
		try (OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8")) {
			userInfo = SecurityContext.getUserInfo(); 
			//String objectToReturn = "{\"replies\": [{\"type\": \"text\", \"content\": \"" + userInfo.getGivenName() + " " + userInfo.getLogonName() + "\"}],\"conversation\": {\"language\": \"en\",\"memory\": {\"user\": \"Bob\"}}}";
			String objectToReturn = "{\"username\" : \"" + userInfo.getGivenName() + "\",\"userid\" : \"" + userInfo.getLogonName() + "\"}";
	
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			writer.write(objectToReturn);
			    
		}
		catch(UserInfoException e){
			//writer.write("{\"result\":\"nodata\"}");
		}
	}
}
