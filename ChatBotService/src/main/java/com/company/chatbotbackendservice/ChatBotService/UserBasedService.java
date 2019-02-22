package com.company.chatbotbackendservice.ChatBotService;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.company.chatbotbackendservice.config.Bean.UserData;

@WebServlet("/chatbotservice/userbasedservice")
public class UserBasedService extends HttpServlet{


	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				//String user = request.getParameter("userid");
				String data = IOUtils.toString(request.getInputStream(), "UTF-8");
				UserData userData = new Gson().fromJson(data,UserData.class);
				
				/*if("tejas".equals(user)){
					
				}else if("ankur".equals(user)){
					
				}else if("punitha".equals(user)){
					
				}*/
				String objectToReturn = "{\"replies\": [{\"type\": \"text\", \"content\": \"Hi " + userData.getUserid() + 
				"\"}]}";
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
