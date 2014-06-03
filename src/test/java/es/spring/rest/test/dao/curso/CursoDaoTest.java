package es.spring.rest.test.dao.curso;


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
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import es.spring.rest.model.curso.Curso;
import es.spring.rest.model.curso.CursoExample;
import es.spring.rest.persistence.curso.CursoMapper;

@ContextConfiguration(locations = { 
        "classpath:applicationContextDaoTest.xml" 
        })
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoDaoTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoDaoTest.class); 
	
	@Autowired
	private CursoMapper cursoMapper;
	
	private Curso curso;
	
	@Before
	public void init(){
		curso = new Curso();
		curso.setId(1);
		curso.setNivel("principal");
		curso.setTitulo("algo");
	}
	
	
	@Test
	public void test1Count(){
		LOGGER.info("------------------------Numero de Cursos en la base de datos ----------------------------------------");
		int valor = cursoMapper.countByExample(new CursoExample());
		LOGGER.info("Numero de cursos : "+valor);
		Assert.assertEquals(valor, 0);
		LOGGER.info("------------------------Numero de Cursos en la base de datos ----------------------------------------");
	}
	
	@Test
	public void test2Insert(){
		LOGGER.info("------------------------Insertar Curso en la base de datos ----------------------------------------");
		int valor  = cursoMapper.insert(curso);
		LOGGER.info("Numero de cursos insertados : "+valor);
		Assert.assertEquals(valor, 1);
		LOGGER.info("------------------------Insertar Curso en la base de datos ----------------------------------------");
	}
	
	@Test
	public void test3Update(){
		LOGGER.info("------------------------Actulizar el Curso en la base de datos ----------------------------------------");
		curso.setTitulo("NADA");
		cursoMapper.updateByPrimaryKey(curso);
		Assert.assertEquals(curso.getTitulo(), "NADA");
		LOGGER.info("Numero de cursos actulizados : 1 ");
		LOGGER.info("------------------------Actulizar el Curso en la base de datos ----------------------------------------");
	}
	
	@Test
	public void test4Delete(){
		LOGGER.info("------------------------Borrar Curso en la base de datos ----------------------------------------");
		cursoMapper.deleteByPrimaryKey(curso.getId());
		CursoExample cursoExample = new CursoExample();
		cursoExample.createCriteria().andIdEqualTo(curso.getId());
		Assert.assertEquals(cursoMapper.countByExample(cursoExample), 0);
		LOGGER.info("Numero de cursos borrados : 1");
		LOGGER.info("------------------------Borrar Curso en la base de datos ----------------------------------------");
	}
	
	@After
	public void end(){
		curso = null;
	}

}
