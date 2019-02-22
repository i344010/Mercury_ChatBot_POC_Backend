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
import com.company.chatbotbackendservice.config.Bean.CustomerData;

@WebServlet("/chatbotservice/gas")
public class GasServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8")) {
			
				String data = IOUtils.toString(request.getInputStream(), "UTF-8");
				CustomerData customerData = new Gson().fromJson(data,CustomerData.class);
				String duration1 = "between 11am and 12pm";
				String duration2 = "between 12pm and 2pm";
				String duration3 = "between 2pm and 4pm";
				String duration4 = "between 4pm and 6pm";
				String duration5 = "between 6pm and 8pm";
				
				String representative = null;
				
				if(customerData.getTimeToCall().matches(duration1)) {
					representative = "Rakesh Varma";
				} else if(customerData.getTimeToCall().matches(duration2)) {
					representative = "Kavitha Krishna";
				} else if(customerData.getTimeToCall().matches(duration3)) {
					representative = "Lalith Singh";
				} else if(customerData.getTimeToCall().matches(duration4)) {
					representative = "Pramoth Patel";
				} else if(customerData.getTimeToCall().matches(duration5)) {
					representative = "Megna Kapur";
				}
				
				String objectToReturn = "{\"replies\": [{\"type\": \"text\", \"content\": \"Mercury representative " +
				representative + " will be in touch soon. \"}]}";
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
