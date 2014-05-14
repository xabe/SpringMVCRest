package es.spring.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.spring.rest.model.EntityBase;
import es.spring.rest.model.ExampleBase;
import es.spring.rest.persistence.PaginationContext;

public interface ServiceBase<T extends EntityBase, D extends ExampleBase> {
	public static final Logger LOGGER = LoggerFactory.getLogger(ServiceBase.class);
	public static final String ALL_CRITERIA = "allCriteria";
	public static final String FRIST = "first";
	public static final String NEXT = "next";
	public static final String PREVIOUS = "previous";
	public static final String LAST = "last";

	void add(T t);

	void update(T t);

	void update(T t, D d);

	void delete(T t);

	void delete(D d);

	List<T> getAll();

	List<T> getAll(D d);

	int getTotal();

	int getTotal(D d);

	void deleteAllData();

	List<T> findSearch(D example, PaginationContext paginationContext, int page);

	List<T> getPaginated(D example, String operation, PaginationContext paginationContext);

	List<T> getPaginated(D example);

}