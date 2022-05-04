package webapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class order.
 * @author Dayanov MA
 */
public class order {
	
	/** The price types. */
	public static HashMap<String, Integer> price_types = new HashMap<>();
	
	/** The price services. */
	public static HashMap<String, Integer> price_services = new HashMap<>();
	
	/** The services. */
	public static HashSet<String> services = new HashSet<>();
	
	/** The area ratio. */
	public static int area_ratio;
	
	/** The price. */
	public static int price;
	
	/** The promo price. */
	public static int promo_price = 0;
	
	/** The area. */
	public static int area;
	
	/** The type. */
	public static String type;
	
	/**
	 * Gets the price types.
	 *
	 * @param type the type
	 * @return the price types
	 */
	public static Integer getPrice_types(String type) {return price_types.get(type);}
	
	/**
	 * Sets the price types.
	 *
	 * @param type the type
	 * @param price the price
	 */
	public static void setPrice_types(String type, int price) {price_types.put(type, price);}
	
	/**
	 * Gets the price services.
	 *
	 * @param service the service
	 * @return the price services
	 */
	public static Integer getPrice_services(String service) {return price_services.get(service);}
	
	/**
	 * Sets the price services.
	 *
	 * @param service the service
	 * @param price the price
	 */
	public static void setPrice_services(String service, int price) {price_services.put(service, price);}
	
	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public static HashSet<String> getServices() {return services;}
	
	/**
	 * Sets the services.
	 *
	 * @param service the new services
	 */
	public static void setServices(String service) {services.add(service);}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public static int getPrice() {return price;}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public static void setPrice(int price) {order.price = price;}
	
	/**
	 * Gets the area ratio.
	 *
	 * @return the area ratio
	 */
	public static int getArea_ratio() {return area_ratio;}
	
	/**
	 * Sets the area ratio.
	 *
	 * @param area_ratio the new area ratio
	 */
	public static void setArea_ratio(int area_ratio) {order.area_ratio = area_ratio;}
	
	/**
	 * Gets the promo price.
	 *
	 * @return the promo price
	 */
	public static int getPromo_price() {return promo_price;}
	
	/**
	 * Sets the promo price.
	 *
	 * @param promo_price the new promo price
	 */
	public static void setPromo_price(int promo_price) {order.promo_price = promo_price;}
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public static int getArea() {return area;}
	
	/**
	 * Sets the area.
	 *
	 * @param area the new area
	 */
	public static void setArea(int area) {order.area = area;}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public static String getType() {return type;}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public static void setType(String type) {order.type = type;}
	
	/**
	 * Clear.
	 */
	public static void clear() {
		price_types.clear();
		price_services.clear();
		services.clear();
	}
	
	/**
	 * Calculate.
	 *
	 * @param area the area
	 * @param type the type
	 */
	public static void calculate(int area, String type) {
		price = area*area_ratio + price_types.get(type) - promo_price;
		setArea(area);
		setType(type);
		for (String service: services) {
			if (service != null) {
				price = price + price_services.get(service);
			}
		}
	}
	
	/**
	 * Inits the prices.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void initPrices() throws URISyntaxException, IOException {
		
		File file = new File(order.class.getResource("/txt/service_prices.txt").toURI());
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String line = reader.readLine();
		int i;
		String service = "";
		String price = "";
		while (line != null) {
			i = 0;
			while (line.charAt(i) != ':') {
				service = service + line.charAt(i);
				i = i + 1;
			}
			i = i + 1;
			while (i < line.length()) {
				price = price + line.charAt(i);
				i = i + 1;
			}
			int price_try = Integer.parseInt(price);
			order.setPrice_services(service, price_try);
			service = "";
			price = "";
			line = reader.readLine();
		}
		
		
		file = new File(order.class.getResource("/txt/type_prices.txt").toURI());
		fileReader = new FileReader(file);
		reader = new BufferedReader(fileReader);
		line = reader.readLine();
		String type = "";
		while (line != null) {
			i = 0;
			while (line.charAt(i) != ':') {
				type = type + line.charAt(i);
				i = i + 1;
			}
			i = i + 1;
			while (i < line.length()) {
				price = price + line.charAt(i);
				i = i + 1;
			}
			int price_try = Integer.parseInt(price);
			order.setPrice_types(type, price_try);
			type = "";
			price = "";
			line = reader.readLine();
		}
		
		
		file = new File(order.class.getResource("/txt/area_price.txt").toURI());
		fileReader = new FileReader(file);
		reader = new BufferedReader(fileReader);
		line = reader.readLine();
		while (line != null) {
			order.setArea_ratio(Integer.parseInt(line));
			line = reader.readLine();
		}
	}
	
	/** The times. */
	private static BaseFont times = null;

    /**
     * Generate PDF.
     *
     * @param surname the surname
     * @param name the name
     * @param patronymic the patronymic
     * @param address the address
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void generatePDF(String surname, String name, String patronymic, String address) throws IOException {
      	
    	Document document = new Document();
    	
    	String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) {
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"webapps/kursovaya/order.pdf";
		String fontpath = Objects.requireNonNull(CreatePDF.class.getResource("/fonts/times.ttf")).getPath();
		
		try {	
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
					
		document.open(); 
		
		//BaseFont times = null;
		try {
			times = BaseFont.createFont(fontpath, "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		try {
			document.add(new Paragraph("ООО ФастКлин", new Font(times,18)));
			document.add(new Paragraph("ФИО: " + surname + " " + name + " " + patronymic, new Font(times,14)));
			document.add(new Paragraph("Адрес: " + address, new Font(times,14)));
			document.add(new Paragraph("Площадь помещения: " + area + " м2", new Font(times,14)));
			if (!services.isEmpty()) {
				document.add(new Paragraph("Дополнительные услуги: ", new Font(times,14)));
				for (String service: services) {
					if (!(service == null)) {
						document.add(new Paragraph("* " + service, new Font(times,12)));
					}
				}
			} else {
				document.add(new Paragraph("Дополнительных услуг нет", new Font(times, 14)));
			}
			if (promo_price != 0) {
				document.add(new Paragraph("Скидка по промокоду: " + promo_price, new Font(times,14)));
			}
			document.add(new Paragraph("Стоимость: " + price + " руб.", new Font(times,14)));
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}

	    document.close(); 
    }
	
}
