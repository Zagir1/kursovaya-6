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

// TODO: Auto-generated Javadoc
/**
 * The Class admin.
 * @author Muzafin AR
 */
@WebServlet(name="admin", urlPatterns="/admin")
public class admin extends HttpServlet {
	
	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File(admin.class.getResource("/txt/type_prices.txt").toURI()));
			pw.write("Генеральная:" + request.getParameter("type_1") + "\n");
			pw.write("После ремонта:" + request.getParameter("type_2") + "\n");
			pw.write("Поддерживающая:" + request.getParameter("type_3") + "\n");
			pw.close();
		} catch (FileNotFoundException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		try {
			pw = new PrintWriter(new File(admin.class.getResource("/txt/area_price.txt").toURI()));
			pw.write(request.getParameter("area"));
			pw.close();
		} catch (FileNotFoundException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		try {
			pw = new PrintWriter(new File(admin.class.getResource("/txt/service_prices.txt").toURI()));
			pw.write("Мытье окон:" + request.getParameter("service_1") + "\n");
			pw.write("Мытье холодильника:" + request.getParameter("service_2") + "\n");
			pw.write("Мытье люстр:" + request.getParameter("service_3") + "\n");
			pw.write("Мытье микроволновки:" + request.getParameter("service_4") + "\n");
			pw.write("Химчистка диванов:" + request.getParameter("service_5") + "\n");
			pw.write("Химчистка кресел:" + request.getParameter("service_6") + "\n");
			pw.write("Химчистка пуфиков:" + request.getParameter("service_7") + "\n");
			pw.write("Химчистка стульев:" + request.getParameter("service_8") + "\n");
			pw.close();
		} catch (FileNotFoundException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("message", "Цены изменены");
		
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
	}	
}
