package work.assisjrs.crud;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import work.assisjrs.TestConfiguration;
import work.assisjrs.crud.HomeController;
import work.assisjrs.crud.Shipwreck;
import work.assisjrs.crud.ShipwreckController;
import work.assisjrs.crud.ShipwreckRepository;

@SpringBootTest(classes = TestConfiguration.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest1 {

	@InjectMocks
	ShipwreckController controller;

	@Mock
	private ShipwreckRepository shipwreckRepository;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		initMocks(this);
		mockMvc = standaloneSetup(controller).build();
	}

	@Test
	public void teste1() {
		HomeController controller = new HomeController();

		final String result = controller.index();

		assertEquals("Home", result);
	}

	@Test
	public void teste2() throws Exception {
		ArrayList<Shipwreck> shipwrecks = new ArrayList<Shipwreck>();

		when(shipwreckRepository.findAll()).thenReturn(shipwrecks);

		mockMvc.perform(get("/api/v1/shipwrecks")).andExpect(status().isOk());
	}
}
