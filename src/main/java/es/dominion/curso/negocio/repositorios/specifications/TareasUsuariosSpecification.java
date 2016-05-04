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

import es.dominion.curso.negocio.entidades.TareasUsuarios;
import es.dominion.curso.negocio.entidades.TareasUsuarios_;
import es.dominion.curso.util.dtos.TareasUsuariosDto;



/**
 * <p>Class TareasUsuariosSpecification.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 20/04/2016.
 */
public class TareasUsuariosSpecification {

	/**
     * Utility classes should not have a public constructor.
     */
    private TareasUsuariosSpecification() {
    }
    
    /**
     * Gets AND Specification.
     * @param dto {@link TareasUsuariosDto}
     * @param searchBasic Text to search
     * @return {@link Specification}
     */
    public static Specification<TareasUsuarios> getSpecification(final TareasUsuariosDto dto, final String searchBasic) {
		Specification<TareasUsuarios> spec = new Specification<TareasUsuarios>() {
	
		    @Override
		    public Predicate toPredicate(Root<TareasUsuarios> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		    	return cb.greaterThan(root.get(TareasUsuarios_.codigoTareausuario), 0L);
		    }
		};
		
		//WHERE - AND
		if (dto!=null) {
		    Specification<TareasUsuarios> specAND =  getSpecificationAND(dto);
		    spec = Specifications.where(spec).and(specAND);
		}
	
		//WHERE - OR
		if (StringUtils.isNotEmpty(searchBasic)) {
		    Specification<TareasUsuarios> specOR =  getSpecificationOR(searchBasic);
		    spec = Specifications.where(spec).and(specOR);
		}
		
		return spec;
    }

    /**
     * Gets AND Specification.
     * @param dto {@link TareasUsuarios}
     * @return {@link Specification}
     */
    private static Specification<TareasUsuarios> getSpecificationAND(final TareasUsuariosDto dto) {
		Specification<TareasUsuarios> spec = new Specification<TareasUsuarios>() {
	
		    @Override
		    public Predicate toPredicate(Root<TareasUsuarios> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				/**
				 * Filtro '=' del campo id
				 */
				if (dto.getCodigoTareausuario() != null) {
				    predicates.add(cb.equal(root.get(TareasUsuarios_.codigoTareausuario), dto.getCodigoTareausuario()));
				}
				
				/**
				 * Filtro '=' del campo descripcionTareausuario
				 */
				if (StringUtils.isNoneEmpty(dto.getDescripcionTareausuario())) {
				    predicates.add(cb.equal(root.get(TareasUsuarios_.descripcionTareausuario), dto.getDescripcionTareausuario()));
				}
				/**
				 * Filtro 'like' del campo descripcionTareausuario
				 */
				if (StringUtils.isNoneEmpty(dto.getDescripcionTareausuarioLk())) {
				    predicates.add(cb.like(root.get(TareasUsuarios_.descripcionTareausuario), "%".concat(dto.getDescripcionTareausuarioLk().concat("%"))));
				}
				
				/**
				 * Filtro '=' del campo estadoTarea
				 */
				if (StringUtils.isNoneEmpty(dto.getEstadoTarea())) {
				    predicates.add(cb.equal(root.get(TareasUsuarios_.estadoTarea), dto.getEstadoTarea()));
				}
				/**
				 * Filtro 'like' del campo estadoTarea
				 */
				if (StringUtils.isNoneEmpty(dto.getEstadoTareaLk())) {
				    predicates.add(cb.like(root.get(TareasUsuarios_.estadoTarea), "%".concat(dto.getEstadoTareaLk().concat("%"))));
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
    private static Specification<TareasUsuarios> getSpecificationOR(final String searchBasic) {
		Specification<TareasUsuarios> spec = new Specification<TareasUsuarios>() {
	
		    @Override
		    public Predicate toPredicate(Root<TareasUsuarios> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
		
				if (searchBasic != null) {
					predicates.add(cb.like(root.get(TareasUsuarios_.descripcionTareausuario), "%".concat(searchBasic.concat("%"))));
					predicates.add(cb.like(root.get(TareasUsuarios_.estadoTarea), "%".concat(searchBasic.concat("%"))));
				}
		
				return cb.or(predicates.toArray(new Predicate[ ] { }));
		    }
		};
		return spec;
    }
}
