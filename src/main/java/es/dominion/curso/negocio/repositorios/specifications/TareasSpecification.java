package es.dominion.curso.negocio.repositorios.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import es.dominion.curso.negocio.entidades.Tareas;
import es.dominion.curso.negocio.entidades.Tareas_;
import es.dominion.curso.util.dtos.TareasDto;



/**
 * <p>Class TareasSpecification.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 20/04/2016.
 */
public class TareasSpecification {

	/**
     * Utility classes should not have a public constructor.
     */
    private TareasSpecification() {
    }
    
    /**
     * Gets AND Specification.
     * @param dto {@link TareasDto}
     * @param searchBasic Text to search
     * @return {@link Specification}
     */
    public static Specification<Tareas> getSpecification(final TareasDto dto, final String searchBasic) {
		Specification<Tareas> spec = new Specification<Tareas>() {
	
		    @Override
		    public Predicate toPredicate(Root<Tareas> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		    	return cb.greaterThan(root.get(Tareas_.codigoTarea).as(Long.class), 0L);
		    }
		};
		
		//WHERE - AND
		if (dto!=null) {
		    Specification<Tareas> specAND =  getSpecificationAND(dto);
		    spec = Specifications.where(spec).and(specAND);
		}
	
		//WHERE - OR
		if (StringUtils.isNotEmpty(searchBasic)) {
		    Specification<Tareas> specOR =  getSpecificationOR(searchBasic);
		    spec = Specifications.where(spec).and(specOR);
		}
		
		return spec;
    }

    /**
     * Gets AND Specification.
     * @param dto {@link Tareas}
     * @return {@link Specification}
     */
    private static Specification<Tareas> getSpecificationAND(final TareasDto dto) {
		Specification<Tareas> spec = new Specification<Tareas>() {
	
		    @Override
		    public Predicate toPredicate(Root<Tareas> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				/**
				 * Filtro '=' del campo id
				 */
				if (dto.getCodigoTarea() != null) {
				    predicates.add(cb.equal(root.get(Tareas_.codigoTarea), dto.getCodigoTarea()));
				}
				
				/**
				 * Filtro '=' del campo descripcionTarea
				 */
				if (StringUtils.isNoneEmpty(dto.getDescripcionTarea())) {
				    predicates.add(cb.equal(root.get(Tareas_.descripcionTarea), dto.getDescripcionTarea()));
				}
				/**
				 * Filtro 'like' del campo descripcionTarea
				 */
				if (StringUtils.isNoneEmpty(dto.getDescripcionTareaLk())) {
				    predicates.add(cb.like(root.get(Tareas_.descripcionTarea), "%".concat(dto.getDescripcionTareaLk().concat("%"))));
				}
				
				/**
				 * Filtro '=' del campo vinculo
				 */
				if (StringUtils.isNoneEmpty(dto.getVinculo())) {
				    predicates.add(cb.equal(root.get(Tareas_.vinculo), dto.getVinculo()));
				}
				/**
				 * Filtro 'like' del campo vinculo
				 */
				if (StringUtils.isNoneEmpty(dto.getVinculoLk())) {
				    predicates.add(cb.like(root.get(Tareas_.vinculo), "%".concat(dto.getVinculoLk().concat("%"))));
				}
				
				return cb.and(predicates.toArray(new Predicate[ ] { }));
		    }
		};
		return spec;
    }
	
    /**
     * Gets OR Specification.
     * @param searchBasic Text to search
     * @return {@link Specification}
     */
    private static Specification<Tareas> getSpecificationOR(final String searchBasic) {
		Specification<Tareas> spec = new Specification<Tareas>() {
	
		    @Override
		    public Predicate toPredicate(Root<Tareas> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
		
				if (searchBasic != null) {
					predicates.add(cb.like(root.get(Tareas_.descripcionTarea), "%".concat(searchBasic.concat("%"))));
					predicates.add(cb.like(root.get(Tareas_.vinculo), "%".concat(searchBasic.concat("%"))));
				}
		
				return cb.or(predicates.toArray(new Predicate[ ] { }));
		    }
		};
		return spec;
    }
}
