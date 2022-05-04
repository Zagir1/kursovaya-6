package webapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class registration.
 * @author Ilmukhametov ZA
 */
@WebServlet(name="registration", urlPatterns="/registration")
public class registration extends HttpServlet {
	
	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			authorization.initUserPass();
			HashMap<String, String> user_pass = authorization.getUser_pass();
			if (user_pass.containsKey(request.getParameter("username"))) {
				request.setAttribute("error", "Такой пользователь уже существует");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			}
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("new_user", "Новый пользователь создан");
		request.getRequestDispatcher("/authorization.jsp").forward(request, response);
	}
	
}
