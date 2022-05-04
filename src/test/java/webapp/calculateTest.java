package webapp;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class calculateTest.
 * @author Dayanov MA
 */
public class calculateTest {

	/**
	 * Test.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {
		int area_ratio = 500;
		HashMap<String, Integer> price_types = new HashMap<>();
		HashMap<String, Integer> price_services = new HashMap<>();
		HashSet<String> services = new HashSet<>();
		int price;
		int promo_price;
		int area;
		String type;
		price_types.put("Генеральная", 5000);
		price_types.put("После ремонта", 10000);
		price_types.put("Поддерживающая", 3000);
		price_services.put("Мытье полов", 500);
		type = "Поддерживающая";
		promo_price = 0;
		area = 10;
		
		price = area*area_ratio + price_types.get(type) - promo_price;
		for (String service: services) {
			if (service != null) {
				price = price + price_services.get(service);
			}
		}
		if (price != 8000) {
			fail("Ошибка в вычислениях");
		}
	}
}
