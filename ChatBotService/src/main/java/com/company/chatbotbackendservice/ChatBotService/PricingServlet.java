package com.company.chatbotbackendservice.ChatBotService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.company.chatbotbackendservice.config.Bean.UserData;

@WebServlet("/chatbotservice/fetchpricingdetails")
public class PricingServlet extends HttpServlet{
private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8")) {
			
				String data = IOUtils.toString(request.getInputStream(), "UTF-8");
				UserData userData = new Gson().fromJson(data,UserData.class);
				String pricing = "0";
				if(userData.getUserid().toLowerCase().contains("punitha")){
					pricing = "1500";
				}else if(userData.getUserid().toLowerCase().contains("ankur")){
					pricing = "2200";
				}else if(userData.getUserid().toLowerCase().contains("tejas")){
					pricing = "1000";
				}else if(userData.getUserid().toLowerCase().contains("shivani")){
					pricing = "5200";
				}
				
				String objectToReturn = "{\"replies\": [{\"type\": \"text\", \"content\": \"Pricing : $ " +
				pricing + "\"}]}";
				//String json = new Gson().toJson(objectToReturn);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    writer.write(objectToReturn);
		}
		/* catch (SQLException e) {
			throw new ServletException(e);
		}*/
	}
}
