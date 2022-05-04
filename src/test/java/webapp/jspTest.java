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
 * The Class jspTest.
 * @author Ilmukhametov ZA
 */
public class jspTest {

	/**
	 * Test.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {
		String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) {
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"kursovaya-6/src/main/webapp/";
		assertTrue(Files.exists(Paths.get(filepath + "admin.jsp")));
		assertTrue(Files.exists(Paths.get(filepath + "authorization.jsp")));
		assertTrue(Files.exists(Paths.get(filepath + "calculator.jsp")));
		assertTrue(Files.exists(Paths.get(filepath + "credentials.jsp")));
		assertTrue(Files.exists(Paths.get(filepath + "developers.jsp")));
		assertTrue(Files.exists(Paths.get(filepath + "index.jsp")));
		assertTrue(Files.exists(Paths.get(filepath + "registration.jsp")));
		assertTrue(Files.exists(Paths.get(filepath + "result.jsp")));
	}
}
