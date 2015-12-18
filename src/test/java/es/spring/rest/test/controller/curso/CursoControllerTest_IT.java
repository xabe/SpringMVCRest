package es.spring.rest.test.controller.curso;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import es.spring.rest.model.curso.*;
import es.spring.rest.service.curso.*;

@ContextConfiguration(locations = { "classpath:applicationContextControllerTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoControllerTest_IT {

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
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        when(cursoService.getAll(notNull(CursoExample.class))).thenReturn(Arrays.asList(new Curso[] { curso }));
    }

    @Test
    public void getAllCursos() throws Exception {
        mockMvc.perform(get(BASE_URI + "/all").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nivel", is("principal"))).andExpect(jsonPath("$[0].titulo", is("algo")));

        verify(cursoService, times(1)).getAll(notNull(CursoExample.class));
        verifyZeroInteractions(cursoService);
    }

    @Test
    public void insertCurso() throws Exception {
        mockMvc.perform(
                post(BASE_URI + "/curso").content("{ \"id\": 1, \"nivel\": \"algo\", \"titulo\": \"England\" }")
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(
                status().isCreated());

        verify(cursoService, times(1)).add(notNull(Curso.class));
        verifyZeroInteractions(cursoService);
    }

    @After
    public void end() {
        curso = null;
    }
}
