package work.assisjrs.shipwreck;

import static org.mockito.Matchers.eq;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ShipwreckControllerTest {
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
	public void deveRetornarAListaDeTodosOsNavios() throws Exception {
		ArrayList<Shipwreck> shipwrecks = new ArrayList<Shipwreck>();

		when(shipwreckRepository.findAll())
	   .thenReturn(shipwrecks);

		mockMvc.perform(get("/api/v1/shipwrecks"))
	   .andExpect(status().isOk());
	}

	@Test
	public void casoNaoEncontreONavioPorIdLancarIllegalArgumentException() throws Exception {
		when(shipwreckRepository.findOne(eq(1L)))
	   .thenReturn(null);

		mockMvc.perform(get("/api/v1/shipwrecks/1"))
			   .andExpect(status().isNotFound());
	}
}
