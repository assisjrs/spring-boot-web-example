package work.assisjrs.shipwreck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class HomeControllerTest {
	@Test
	public void deveRetornarHomeAoAcessarOEndpointIndex() {
		HomeController controller = new HomeController();

		final String result = controller.index();

		assertEquals("Home", result);
	}
}
