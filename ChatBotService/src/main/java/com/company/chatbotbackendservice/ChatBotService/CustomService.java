package com.company.chatbotbackendservice.ChatBotService;

import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/chatbotservice/customservice")
public class CustomService extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*try {
			//conn = getConnection();
		} catch (SQLException e) {
			throw new ServletException(e.getMessage(), e);
		}*/
		try (OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8")) {
			
			//if (conn != null) {
				/*writer.write("yes");
				writer.write("\n\nCurrent Hana DB user:\n");
				String userName = "Tejas";
				writer.write(userName);
				writer.write("\n\nCurrent Hana schema:\n");*/
				
				String objectToReturn = "{\"replies\": [{\"type\": \"text\", \"content\": \"custom data\"}],\"conversation\": {\"language\": \"en\",\"memory\": {\"user\": \"Bob\"}}}";
				//String json = new Gson().toJson(objectToReturn);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    writer.write(objectToReturn);
			    				
			    /*response.setContentType("application/json");
	    		response.setCharacterEncoding("UTF-8");
				// Get the printwriter object from response to write the required json object to the output stream      
				PrintWriter out = response.getWriter();
				// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
				out.print(objectToReturn);
				out.flush();*/

				//writer.write(getCurrentSchema(conn));
			//} else {
			//	writer.write("no");
			//}
		}
		/* catch (SQLException e) {
			throw new ServletException(e);
		}*/
	}

}
