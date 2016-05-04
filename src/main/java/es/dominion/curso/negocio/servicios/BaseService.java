package es.dominion.curso.negocio.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BaseService<T, I> {

	List<T> findAll();
	Page<T> findAll(Pageable pageable);
	List<T> findAll(Specification<T> specification);
	Page<T> findAll(Specification<T> specification, Pageable pageable);
	
	Boolean exist(Specification<T> specification);
	
	T findById(I id);

	T create(T entity);

	T update(T entity);

	void delete(T entity);
}