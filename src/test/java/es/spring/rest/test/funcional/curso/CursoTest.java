package es.spring.rest.test.funcional.curso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import es.spring.rest.model.curso.Curso;


public class CursoTest {
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
		ParameterizedTypeReference<List<Curso>> typeRef = new ParameterizedTypeReference<List<Curso>>() {};
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
