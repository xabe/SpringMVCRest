package es.spring.rest.test.funcional.curso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import es.spring.rest.model.curso.Curso;


public class CursoIT {
	private static final String BASE_URI = "http://localhost:8080/rest/cursos/";
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
	public void getAllCursos_1() {
		ParameterizedTypeReference<List<Curso>> typeRef = new ParameterizedTypeReference<List<Curso>>() {};
		ResponseEntity<List<Curso>> response = restTemplate.exchange(BASE_URI + "all", HttpMethod.GET, null, typeRef);
		assertNotNull(response.getBody());
		assertEquals(2, response.getBody().size());
	}

	@Test
	public void insertCurso_2() {
		Curso curso = new Curso();
		curso.setId(1);
		curso.setNivel("principal");
		curso.setTitulo("algo");

		ResponseEntity<Curso> entity = restTemplate.postForEntity(BASE_URI + "curso", curso, Curso.class);
		assertEquals(entity.getStatusCode(), HttpStatus.CREATED);
		
	}
	
	@Test
	public void deleteCurso_3() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);
		ResponseEntity<String> responseDelete = restTemplate.exchange(BASE_URI + "curso/1", HttpMethod.DELETE,requestEntity, String.class);
		assertEquals(responseDelete.getStatusCode(), HttpStatus.OK);
		
		ParameterizedTypeReference<List<Curso>> typeRef = new ParameterizedTypeReference<List<Curso>>() {};
		ResponseEntity<List<Curso>> response = restTemplate.exchange(BASE_URI + "curso/1", HttpMethod.GET, null, typeRef);
		assertNotNull(response.getBody());
		assertEquals(0, response.getBody().size());
		
	}

}
