package webapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class authorization.
 * @author Ilmukhametov ZA
 */
@WebServlet(name="authorization", urlPatterns="/authorization")
public class authorization extends HttpServlet {
	
	/** The user pass. */
	public static HashMap<String, String> user_pass = new HashMap<>();
	
	/** The admins. */
	public static HashMap<String, String> admins = new HashMap<>();
	
	/**
	 * Gets the user pass.
	 *
	 * @return the user pass
	 */
	public static HashMap<String, String> getUser_pass() {return user_pass;}
	
	/**
	 * Sets the user pass.
	 *
	 * @param user_pass the user pass
	 */
	public static void setUser_pass(HashMap<String, String> user_pass) {authorization.user_pass = user_pass;}
	
	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (admins.containsKey(username)) {
			if (admins.get(username).equals(password)) {
				try {
					order.initPrices();
				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
				request.setAttribute("type_1", order.getPrice_types("Генеральная"));
				request.setAttribute("type_2", order.getPrice_types("После ремонта"));
				request.setAttribute("type_3", order.getPrice_types("Поддерживающая"));
				
				request.setAttribute("area", order.getArea_ratio());
				
				request.setAttribute("service_1", order.getPrice_services("Мытье окон"));
				request.setAttribute("service_2", order.getPrice_services("Мытье холодильника"));
				request.setAttribute("service_3", order.getPrice_services("Мытье люстр"));
				request.setAttribute("service_4", order.getPrice_services("Мытье микроволновки"));
				request.setAttribute("service_5", order.getPrice_services("Химчистка диванов"));
				request.setAttribute("service_6", order.getPrice_services("Химчистка кресел"));
				request.setAttribute("service_7", order.getPrice_services("Химчистка пуфиков"));
				request.setAttribute("service_8", order.getPrice_services("Химчистка стульев"));
				
				request.getRequestDispatcher("/admin.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Неправильный пароль");
				request.getRequestDispatcher("/authorization.jsp").forward(request, response);
			}
		} else {
			if (user_pass.containsKey(username)) {
				if (user_pass.get(username).equals(password)) {
					request.getRequestDispatcher("/calculator.jsp").forward(request, response);
				} else {
					request.setAttribute("error", "Неправильный пароль");
					request.getRequestDispatcher("/authorization.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", "Неправильный логин");
				request.getRequestDispatcher("/authorization.jsp").forward(request, response);
			}
		}
	}

	/**
	 * Inits the user pass.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void initUserPass() throws URISyntaxException, IOException {
		File file = new File(authorization.class.getResource("/txt/users.txt").toURI());
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String line = reader.readLine();
		int i;
		String username = "";
		String password = "";
		while (line != null) {
			i = 0;
			while (line.charAt(i) != ':') {
				username = username + line.charAt(i);
				i = i + 1;
			}
			i = i + 1;
			while (i < line.length()) {
				password = password + line.charAt(i);
				i = i + 1;
			}
			user_pass.put(username, password);
			username = "";
			password = "";
			line = reader.readLine();
		}
		
		file = new File(authorization.class.getResource("/txt/admin.txt").toURI());
		fileReader = new FileReader(file);
		reader = new BufferedReader(fileReader);
		line = reader.readLine();
		while (line != null) {
			i = 0;
			while (line.charAt(i) != ':') {
				username = username + line.charAt(i);
				i = i + 1;
			}
			i = i + 1;
			while (i < line.length()) {
				password = password + line.charAt(i);
				i = i + 1;
			}
			admins.put(username, password);
			username = "";
			password = "";
			line = reader.readLine();
		}
	}
	
	/**
	 * New user.
	 *
	 * @param username the username
	 * @param password the password
	 * @throws FileNotFoundException the file not found exception
	 * @throws URISyntaxException the URI syntax exception
	 */
	public static void newUser(String username, String password) throws FileNotFoundException, URISyntaxException {
		user_pass.put(username, password);
		PrintWriter pw = new PrintWriter(new File(authorization.class.getResource("/txt/users.txt").toURI()));
		for (String user: user_pass.keySet()) {
			pw.write(user + ":" + user_pass.get(user) + "\n");
		}
		pw.close();
	}
}
