package es.spring.rest.persistence;

import java.io.Serializable;
import java.util.List;

import es.spring.rest.model.EntityBase;
import es.spring.rest.model.ExampleBase;

public interface PersistenceBase <T extends EntityBase, D extends ExampleBase> extends Serializable {
	
	List<T> selectByExamplePagination(D example);
	
	void deleteAllData();
}