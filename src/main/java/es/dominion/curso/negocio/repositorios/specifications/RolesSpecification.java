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

import es.dominion.curso.negocio.entidades.Roles;
import es.dominion.curso.negocio.entidades.Roles_;
import es.dominion.curso.util.dtos.RolesDto;



/**
 * <p>Class RolesSpecification.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 20/04/2016.
 */
public class RolesSpecification {

	/**
     * Utility classes should not have a public constructor.
     */
    private RolesSpecification() {
    }
    
    /**
     * Gets AND Specification.
     * @param dto {@link RolesDto}
     * @param searchBasic Text to search
     * @return {@link Specification}
     */
    public static Specification<Roles> getSpecification(final RolesDto dto, final String searchBasic) {
		Specification<Roles> spec = new Specification<Roles>() {
	
		    @Override
		    public Predicate toPredicate(Root<Roles> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		    	return cb.greaterThan(root.get(Roles_.codigoRol).as(Long.class), 0L);
		    }
		};
		
		//WHERE - AND
		if (dto!=null) {
		    Specification<Roles> specAND =  getSpecificationAND(dto);
		    spec = Specifications.where(spec).and(specAND);
		}
	
		//WHERE - OR
		if (StringUtils.isNotEmpty(searchBasic)) {
		    Specification<Roles> specOR =  getSpecificationOR(searchBasic);
		    spec = Specifications.where(spec).and(specOR);
		}
		
		return spec;
    }

    /**
     * Gets AND Specification.
     * @param dto {@link Roles}
     * @return {@link Specification}
     */
    private static Specification<Roles> getSpecificationAND(final RolesDto dto) {
		Specification<Roles> spec = new Specification<Roles>() {
	
		    @Override
		    public Predicate toPredicate(Root<Roles> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				/**
				 * Filtro '=' del campo id
				 */
				if (dto.getCodigoRol() != null) {
				    predicates.add(cb.equal(root.get(Roles_.codigoRol), dto.getCodigoRol()));
				}
				
				/**
				 * Filtro '=' del campo descripcionRol
				 */
				if (StringUtils.isNoneEmpty(dto.getDescripcionRol())) {
				    predicates.add(cb.equal(root.get(Roles_.descripcionRol), dto.getDescripcionRol()));
				}
				/**
				 * Filtro 'like' del campo descripcionRol
				 */
				if (StringUtils.isNoneEmpty(dto.getDescripcionRolLk())) {
				    predicates.add(cb.like(root.get(Roles_.descripcionRol), "%".concat(dto.getDescripcionRolLk().concat("%"))));
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
    private static Specification<Roles> getSpecificationOR(final String searchBasic) {
		Specification<Roles> spec = new Specification<Roles>() {
	
		    @Override
		    public Predicate toPredicate(Root<Roles> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
		
				if (searchBasic != null) {
					predicates.add(cb.like(root.get(Roles_.descripcionRol), "%".concat(searchBasic.concat("%"))));
				}
		
				return cb.or(predicates.toArray(new Predicate[ ] { }));
		    }
		};
		return spec;
    }
}
