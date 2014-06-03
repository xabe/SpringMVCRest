package es.spring.rest.test.service.curso;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.spring.rest.model.curso.Curso;
import es.spring.rest.model.curso.CursoExample;
import es.spring.rest.persistence.curso.CursoMapper;
import es.spring.rest.service.curso.CursoService;


@ContextConfiguration(locations = { 
        "classpath:applicationContextServiceTest.xml" 
        })
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoServiceTest {
private static final Logger LOGGER = LoggerFactory.getLogger(CursoServiceTest.class); 
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private CursoMapper cursoMapper;
	
	private CursoExample cursoExample;
	private Curso curso;
	
	@Before
	public void init(){
		curso = new Curso();
		curso.setId(1);
		curso.setNivel("principal");
		curso.setTitulo("algo");
		
		cursoExample = new CursoExample();
		
		when(cursoMapper.selectByExample(cursoExample)).thenReturn(Arrays.asList(new Curso[]{curso}));
	}	
	
	@Test
	public void test1Count(){
		LOGGER.info("------------------------Numero de Cursos en la base de datos ----------------------------------------");
        List<Curso> cursos = cursoService.getAll(cursoExample);
        LOGGER.info("Numero de cursos : "+cursos.size());
        Assert.assertEquals(cursos.size(), 1);
        verify(cursoMapper,times(1)).selectByExample(cursoExample);
        verifyZeroInteractions(cursoMapper);
		LOGGER.info("------------------------Numero de Cursos en la base de datos ----------------------------------------");
	}
	
	@Test
	public void test2Insert(){
		LOGGER.info("------------------------Insertar Curso en la base de datos ----------------------------------------");
		reset(cursoMapper);
		when(cursoMapper.insert(curso)).thenReturn(1);
		int valor = cursoService.add(curso);
        LOGGER.info("Numero de cursos : "+valor);
        Assert.assertEquals(valor, 1);
        verify(cursoMapper,times(1)).insert(curso);
        verifyZeroInteractions(cursoMapper);
        LOGGER.info("------------------------Insertar Curso en la base de datos ----------------------------------------");
	}
	
	@After
	public void end(){
		curso = null;
	}

}
