package es.spring.rest.test.funcional.curso;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.springframework.core.*;
import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.*;
import org.springframework.http.converter.xml.*;
import org.springframework.web.client.*;

import es.spring.rest.model.curso.*;

public class CursoTest_FT {

    private static final String BASE_URI = "http://localhost:9080/SpringMVCRest/rest/cursos/";

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setup() {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(new Jaxb2RootElementHttpMessageConverter());
        restTemplate.setMessageConverters(converters);
    }

    @Test
    public void getAllCursos() {
        ParameterizedTypeReference<List<Curso>> typeRef = new ParameterizedTypeReference<List<Curso>>() {
        };
        ResponseEntity<List<Curso>> response = restTemplate.exchange(BASE_URI + "all", HttpMethod.GET, null, typeRef);
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void insertCurso() {
        Curso curso = new Curso();
        curso.setId(1);
        curso.setNivel("principal");
        curso.setTitulo("algo");

        ResponseEntity<Curso> entity = restTemplate.postForEntity(BASE_URI + "curso", curso, Curso.class);
        assertEquals(entity.getStatusCode(), HttpStatus.CREATED);

    }

}
