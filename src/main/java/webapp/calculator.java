package webapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class calculator.
 * @author Dayanov MA
 */
@WebServlet(name="calculator", urlPatterns="/calculator")
public class calculator extends HttpServlet {

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type;
		type = (String) request.getParameter("type");
		String area;
		area = (String) request.getParameter("area");
		int area_try = Integer.parseInt(area);
		order.clear();
		try {
			order.initPrices();
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		
		String[] services = request.getParameterValues("clean_service");
		if (services != null) {
			for (String service: services) {
				if (service != null) {
					order.setServices(service);
				}
			}
		}
		
		order.calculate(area_try, type);
		request.setAttribute("price" ,order.getPrice());
		request.getRequestDispatcher("/credentials.jsp").forward(request, response);
	}
	
}
