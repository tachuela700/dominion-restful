package es.dominion.curso.negocio.repositorios.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import es.dominion.curso.negocio.repositorios.BaseRepository;


@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	@PersistenceContext
	private EntityManager entityManager;

	public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		
		// This is the recommended method for accessing inherited class dependencies.
	    this.entityManager = entityManager;
	}
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);		
	}

//	@Override
//	public Page<T> findPageable(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
