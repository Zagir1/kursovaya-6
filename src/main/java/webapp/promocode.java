package webapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
 * The Class promocode.
 * @author Muzafin AR
 */
@WebServlet(name="promocode", urlPatterns="/promocode")
public class promocode extends HttpServlet {
	
	/** The promocodes. */
	public static HashMap<String, Integer> promocodes = new HashMap<>();
	
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
			initPromo();
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		if (promocodes.containsKey(request.getParameter("promo"))) {
			order.setPromo_price(promocodes.get(request.getParameter("promo")));
			request.setAttribute("promotext", "Промокод активирован");
		} else {
			request.setAttribute("promotext", "Не удалось активировать промокод");
		}
		request.getRequestDispatcher("/calculator.jsp").forward(request, response);
	}
	
	/**
	 * Inits the promo.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void initPromo() throws URISyntaxException, IOException {
		File file = new File(getClass().getResource("/txt/promocodes.txt").toURI());
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String line = reader.readLine();
		int i;
		String promo = "";
		String price = "";
		while (line != null) {
			i = 0;
			while (line.charAt(i) != ':') {
				promo = promo + line.charAt(i);
				i = i + 1;
			}
			i = i + 1;
			while (i < line.length()) {
				price = price + line.charAt(i);
				i = i + 1;
			}
			int price_try = Integer.parseInt(price);
			promocodes.put(promo, price_try);
			promo = "";
			price = "";
			line = reader.readLine();
		}
	}
}
