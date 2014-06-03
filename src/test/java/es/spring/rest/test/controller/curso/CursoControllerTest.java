package es.spring.rest.test.controller.curso;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.spring.rest.model.curso.Curso;
import es.spring.rest.model.curso.CursoExample;
import es.spring.rest.service.curso.CursoService;

@ContextConfiguration(locations = { "classpath:applicationContextControllerTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoControllerTest {
	private static final String BASE_URI = "/cursos";

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private CursoService cursoService;

	private Curso curso;

	@Before
	public void init() {
		curso = new Curso();
		curso.setId(1);
		curso.setNivel("principal");
		curso.setTitulo("algo");

		reset(cursoService);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
		when(cursoService.getAll(notNull(CursoExample.class))).thenReturn(
				Arrays.asList(new Curso[] { curso }));
	}

	@Test
	public void getAllCursos() throws Exception {
		mockMvc.perform(
				get(BASE_URI + "/all").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].nivel", is("principal")))
				.andExpect(jsonPath("$[0].titulo", is("algo")));

		verify(cursoService, times(1)).getAll(notNull(CursoExample.class));
		verifyZeroInteractions(cursoService);
	}

	@Test
	public void insertCurso() throws Exception {
		mockMvc.perform(
				post(BASE_URI + "/curso")
						.content("{ \"id\": 1, \"nivel\": \"algo\", \"titulo\": \"England\" }")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		verify(cursoService, times(1)).add(notNull(Curso.class));
		verifyZeroInteractions(cursoService);
	}

	@After
	public void end() {
		curso = null;
	}
}
