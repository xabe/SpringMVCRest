package es.spring.rest.service.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.spring.rest.model.curso.Curso;
import es.spring.rest.model.curso.CursoExample;
import es.spring.rest.persistence.PaginationContext;
import es.spring.rest.persistence.curso.CursoMapper;

@Service("cursoService")
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoMapper mapper;


	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void add(Curso aCurso) {
		mapper.insert(aCurso);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(Curso aCurso) {
		mapper.updateByPrimaryKey(aCurso);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(Curso aCurso, CursoExample aCursoExample) {
		mapper.updateByExample(aCurso, aCursoExample);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Curso aCurso) {
		CursoExample aCursoExample = new CursoExample();
		aCursoExample.createCriteria().andIdEqualTo(aCurso.getId());
		mapper.deleteByExample(aCursoExample);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(CursoExample aCursoExample) {
		mapper.deleteByExample(aCursoExample);
	}

	public List<Curso> getAll() {
		return mapper.selectByExample(new CursoExample());
	}

	public List<Curso> getAll(CursoExample aCursoExample) {
		return mapper.selectByExample(aCursoExample);
	}

	public int getTotal() {
		return mapper.countByExample(new CursoExample());
	}

	public int getTotal(CursoExample aCursoExample) {
		return mapper.countByExample(aCursoExample);
	}

	// Borra todos los datos de la tabla
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteAllData() {
		mapper.deleteAllData();
	}

	public List<Curso> findSearch(CursoExample example,
			PaginationContext paginationContext, int page) {
		if (page < 1) {
			page = 1;
		}
		if(null == example)
		{
			example = new CursoExample();
		}
		paginationContext.setSkipResults(paginationContext.getMaxResults()
				* (page - 1));
		paginationContext
				.updateTotalCount(mapper.countByExample(example));
		example.setLimit(paginationContext.getSkipResults()
				+ paginationContext.getMaxResults());
		example.setOffset(paginationContext.getSkipResults());
		return mapper.selectByExamplePagination(example);
	}

	public List<Curso> getPaginated(CursoExample example, String operation,
			PaginationContext paginationContext) { // previous,next,first,last,
		List<Curso> pruebas = null;
		if (operation == null) {
			paginationContext.firstPage();
		} else if (operation.equalsIgnoreCase(PREVIOUS)) {
			paginationContext.previousPage();
		} else if (operation.equalsIgnoreCase(NEXT)) {
			paginationContext.nextPage();
		} else if (operation.equalsIgnoreCase(LAST)) {
			paginationContext.lastPage();
		} else {
			paginationContext.firstPage();
		}
		if(null == example)
		{
			example = new CursoExample();
		}
		example.setLimit(paginationContext.getSkipResults()
				+ paginationContext.getMaxResults());
		example.setOffset(paginationContext.getSkipResults());
		paginationContext
				.updateTotalCount(mapper.countByExample(example));
		pruebas = mapper.selectByExamplePagination(example);

		// Imprime los resultados
		String msg = String.format(
				"skipResults %d de un total de %d records, en paginas de %d ",
				paginationContext.getSkipResults(),
				paginationContext.getTotalCount(),
				paginationContext.getMaxResults());
		LOGGER.debug(msg);
		return pruebas;
	}

	@Override
	public List<Curso> getPaginated(CursoExample example) {
		return mapper.selectByExamplePagination(example);
	}
}
