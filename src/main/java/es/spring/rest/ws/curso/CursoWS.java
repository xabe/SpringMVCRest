package es.spring.rest.ws.curso;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import es.spring.rest.model.curso.Curso;
import es.spring.rest.model.curso.CursoExample;
import es.spring.rest.persistence.PaginationContext;
import es.spring.rest.service.curso.CursoService;
import es.spring.rest.util.Constants;
import es.spring.rest.util.FileUtil;

@Controller
@RequestMapping(value = "/cursos")
public class CursoWS {

	@Autowired
	private CursoService service;

	/**-------------------------------------------------------------------------Metodos GET----------------------------------------------------------------------------------**/
	
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public List<Curso> getCursosPagination(@RequestParam(value = "first", 		defaultValue = "0") Integer first, 
										@RequestParam(value = "pageSize", 	defaultValue = "10") Integer pageSize,
										@RequestParam(value = "sortField",	defaultValue = "id" ) String  sortField,
										@RequestParam(value = "sortOrder", 	defaultValue = "ASC") String sortOrder) {
		
		CursoExample example = new CursoExample();
		example.createCriteria().andActivoEqualTo(true);
		if (sortField != null) 
		{
			example.setOrderByClause(sortField +" "+ sortOrder);
		}
		PaginationContext paginationContext = new PaginationContext();
		paginationContext.setSkipResults(first);
		paginationContext.setMaxResults(pageSize);
		return service.findSearch(example, paginationContext, paginationContext.getCurrentPage());
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public List<Curso> getCursos() {		
		CursoExample example = new CursoExample();
		example.createCriteria().andActivoEqualTo(true);
		return service.getAll(example);
	}
	
	/**-------------------------------------------------------------------------Metodos GET----------------------------------------------------------------------------------**/
	
	/**-------------------------------------------------------------------------Metodos POST----------------------------------------------------------------------------------**/

	@RequestMapping(value = "/curso", method = RequestMethod.POST,  consumes = "application/json", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public void addCurso(@RequestBody Curso curso) {
		service.add(curso);
	}
	
	@RequestMapping(value = "/curso/temario", method = RequestMethod.POST, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> addCurso(MultipartHttpServletRequest request) {
		Iterator<String> itr = request.getFileNames();
	
		MultipartFile mpf = request.getFile(itr.next());
		try 
		{
			String nombreFichero = "";
			if(mpf != null)
			{
				 nombreFichero = Constants.normalizarTextos(mpf.getOriginalFilename()).replaceAll(" ", "_");
		    	 FileUtil.write(new File(Constants.getAbsolutePathFicheros()+File.separator+nombreFichero), mpf.getBytes());
			}			
	    	ObjectMapper mapper = new ObjectMapper();
	    	Curso curso = mapper.readValue(request.getParameter("model"), Curso.class);
	    	curso.setDocumento(nombreFichero);
	    	service.add(curso);
	    	return new ResponseEntity<Object>(HttpStatus.OK);
	    } catch (IOException e) {
	       return new ResponseEntity<String>("Error al crear el curso", HttpStatus.EXPECTATION_FAILED);
	    }

	}
	
	/**-------------------------------------------------------------------------Metodos POST----------------------------------------------------------------------------------**/
	
	/**-------------------------------------------------------------------------Metodos PUT----------------------------------------------------------------------------------**/

	@RequestMapping(value = "/curso", method = RequestMethod.PUT,  consumes = "application/json", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public void updateCurso(@RequestBody Curso curso) {
		service.update(curso);
	}
	
	@RequestMapping(value = "/curso/temario", method = RequestMethod.PUT, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> updateCurso(MultipartHttpServletRequest request) {
		Iterator<String> itr = request.getFileNames();
	
		MultipartFile mpf = request.getFile(itr.next());
		try 
		{
			String nombreFichero = "";
			if(mpf != null)
			{
				 nombreFichero = Constants.normalizarTextos(mpf.getOriginalFilename()).replaceAll(" ", "_");
		    	 FileUtil.write(new File(Constants.getAbsolutePathFicheros()+File.separator+nombreFichero), mpf.getBytes());
			}			
	    	ObjectMapper mapper = new ObjectMapper();
	    	Curso curso = mapper.readValue(request.getParameter("model"), Curso.class);
	    	curso.setDocumento(nombreFichero);
	    	service.add(curso);
	    	return new ResponseEntity<Object>(HttpStatus.OK);
	    } catch (IOException e) {
	       return new ResponseEntity<String>("Error al crear el curso", HttpStatus.EXPECTATION_FAILED);
	    }

	}
	
	/**-------------------------------------------------------------------------Metodos PUT----------------------------------------------------------------------------------**/

	
	/**-------------------------------------------------------------------------Metodos DELETE----------------------------------------------------------------------------------**/

	@RequestMapping(value = "/curso/{id}", method = RequestMethod.DELETE,  consumes = "application/json", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteIdCurso(@PathVariable("id") Integer id) {
		Curso curso = new Curso();
		curso.setId(id);
		service.delete(curso);
	}
	
	@RequestMapping(value = "/curso", method = RequestMethod.DELETE,  consumes = "application/json", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteCurso(@RequestBody Curso curso) {
		service.delete(curso);
	}
	
	/**-------------------------------------------------------------------------Metodos DELETE----------------------------------------------------------------------------------**/
}
