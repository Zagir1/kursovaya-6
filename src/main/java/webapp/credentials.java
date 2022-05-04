package webapp;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class credentials.
 * @author Sherstkin AV
 */
@WebServlet(name="credentials", urlPatterns="/credentials")
public class credentials extends HttpServlet {

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		order.generatePDF((String)request.getParameter("surname"), (String)request.getParameter("name"), (String)request.getParameter("patronymic"), (String)request.getParameter("address"));
		order.clear();
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
}
