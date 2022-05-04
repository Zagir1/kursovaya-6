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
 * The Class pdfTest.
 * @author Sherstkin AV
 */
public class pdfTest {

	/**
	 * Test.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {
		generatePDF(null, null, null, null);
		String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) {
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"kursovaya-6/order.pdf";
		assertTrue(Files.exists(Paths.get(filepath)));
		
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
		filepath=abspath+"kursovaya-6/order.pdf";
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
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}

	    document.close(); 
	}
}
