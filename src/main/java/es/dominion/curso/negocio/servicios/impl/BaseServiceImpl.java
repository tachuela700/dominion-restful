package es.dominion.curso.negocio.servicios.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import es.dominion.curso.negocio.repositorios.BaseRepository;
import es.dominion.curso.negocio.servicios.BaseService;

@Service
@Transactional
public class BaseServiceImpl<T, I extends Serializable> implements BaseService<T, I> {

	private BaseRepository<T, I> repository;
	
	public void setBaseRepository(BaseRepository<T, I> repository) {
		this.repository=repository;
	}
	
	public List<T> findAll() {
		return repository.findAll();
	}
	
	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public List<T> findAll(Specification<T> specification) {
		return repository.findAll(specification);
	}
	
	public Page<T> findAll(Specification<T> specification, Pageable pageable) {
		return repository.findAll(specification, pageable);
	}
	
	public Boolean exist(Specification<T> specification) {
		List<T> l = repository.findAll(specification);
		return l!=null&&!l.isEmpty()?true:false;
	}
	
	public T findById(I id) {
		return (T) repository.findOne(id);		
	}

	public T create(T entity) {
		return (T) repository.saveAndFlush(entity);		
	}

	public T update(T entity) {
		return (T) repository.saveAndFlush(entity);		
	}

	public void delete(T entity) {
		repository.delete(entity);
	}

}
