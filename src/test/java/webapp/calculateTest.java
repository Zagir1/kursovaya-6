package webapp;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
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
		order.initPrices();
		order.calculate(10, "Генеральная");
		if (order.getPrice() != 10000) {
			fail("Ошибка в вычислениях");
		}
		order.clear();
		order.initPrices();
		order.calculate(10, "После ремонта");
		if (order.getPrice() != 15000) {
			fail("Ошибка в вычислениях");
		}
		order.clear();
		order.initPrices();
		order.calculate(10, "Поддерживающая");
		if (order.getPrice() != 8000) {
			fail("Ошибка в вычислениях");
		}
		order.clear();
		order.initPrices();
		order.setServices("Мытье окон");
		order.setServices("Мытье холодильника");
		order.setServices("Мытье люстр");
		order.setServices("Мытье микроволновки");
		order.setServices("Химчистка диванов");
		order.setServices("Химчистка кресел");
		order.setServices("Химчистка пуфиков");
		order.setServices("Химчистка стульев");
		order.calculate(10, "Поддерживающая");
		if (order.getPrice() != 12000) {
			fail("Ошибка в вычислениях");
		}
		order.clear();
		order.initPrices();
		order.setPromo_price(1000);
		order.calculate(10, "Поддерживающая");
		if (order.getPrice() != 7000) {
			fail("Ошибка в вычислениях");
		}
	}
}
