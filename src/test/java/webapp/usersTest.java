package webapp;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class usersTest.
 * @author Muzafin AR
 */
public class usersTest {

	/**
	 * Test.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {
		authorization.initUserPass();
		String s_i;
		for (int i = 0; i < 11; i++) {
			s_i = String.valueOf(i);
			authorization.newUser(s_i, s_i);
		}
		HashMap<String, String> user_pass = authorization.getUser_pass();
		for (int i = 0; i < 11; i++) {
			s_i = String.valueOf(i);
			if (user_pass.containsKey(s_i)) {
				assertEquals(user_pass.get(s_i), s_i);
			} else {
				fail("Новые пользователи не создались");
			}
		}
	}

}
