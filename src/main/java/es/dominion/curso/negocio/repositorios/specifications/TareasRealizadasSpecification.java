package es.dominion.curso.negocio.repositorios.specifications;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import es.dominion.curso.negocio.entidades.TareasRealizadas;
import es.dominion.curso.negocio.entidades.TareasRealizadas_;
import es.dominion.curso.negocio.entidades.TareasUsuarios_;
import es.dominion.curso.negocio.repositorios.specifications.util.StrDateFunction;
import es.dominion.curso.util.dtos.TareasRealizadasDto;



/**
 * <p>Class TareasRealizadasSpecification.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 20/04/2016.
 */
public class TareasRealizadasSpecification {

	/**
     * Utility classes should not have a public constructor.
     */
    private TareasRealizadasSpecification() {
    }
    
    /**
     * Gets AND Specification.
     * @param dto {@link TareasRealizadasDto}
     * @param searchBasic Text to search
     * @return {@link Specification}
     */
    public static Specification<TareasRealizadas> getSpecification(final TareasRealizadasDto dto, final String searchBasic) {
		Specification<TareasRealizadas> spec = new Specification<TareasRealizadas>() {
	
		    @Override
		    public Predicate toPredicate(Root<TareasRealizadas> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		    	return cb.greaterThan(root.get(TareasRealizadas_.codigoTarearealizada), 0L);
		    }
		};
		
		//WHERE - AND
		if (dto!=null) {
		    Specification<TareasRealizadas> specAND =  getSpecificationAND(dto);
		    spec = Specifications.where(spec).and(specAND);
		}
	
		//WHERE - OR
		if (StringUtils.isNotEmpty(searchBasic)) {
		    Specification<TareasRealizadas> specOR =  getSpecificationOR(searchBasic);
		    spec = Specifications.where(spec).and(specOR);
		}
		
		return spec;
    }

    /**
     * Gets AND Specification.
     * @param dto {@link TareasRealizadas}
     * @return {@link Specification}
     */
    private static Specification<TareasRealizadas> getSpecificationAND(final TareasRealizadasDto dto) {
		Specification<TareasRealizadas> spec = new Specification<TareasRealizadas>() {
	
		    @Override
		    public Predicate toPredicate(Root<TareasRealizadas> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				/**
				 * Filtro '=' del campo id
				 */
				if (dto.getCodigoTarearealizada() != null) {
				    predicates.add(cb.equal(root.get(TareasRealizadas_.codigoTarearealizada), dto.getCodigoTarearealizada()));
				}
				
				if (dto.getTareasUsuariosDto() != null && dto.getTareasUsuariosDto().getCodigoTareausuario() != null) {
				    predicates.add(cb.equal(root.get(TareasRealizadas_.tareasUsuarios), dto.getTareasUsuariosDto().getCodigoTareausuario()));
				}
				
				/**
				 * Filtro '=' del campo usuario
				 */
				if (StringUtils.isNoneEmpty(dto.getUsuario())) {
				    predicates.add(cb.equal(root.get(TareasRealizadas_.usuario), dto.getUsuario()));
				}
				/**
				 * Filtro 'like' del campo usuario
				 */
				if (StringUtils.isNoneEmpty(dto.getUsuarioLk())) {
				    predicates.add(cb.like(root.get(TareasRealizadas_.usuario), "%".concat(dto.getUsuarioLk().concat("%"))));
				}
							
				/**
				 * Filtro ['=' | 'between' | 'greaterThanOrEqualTo' | 'lessThanOrEqualTo'] del campo fechaRealizacion
				 */
				if (dto.getFechaRealizacion() != null) {
				    predicates.add(cb.equal(root.get(TareasRealizadas_.fechaRealizacion), dto.getFechaRealizacion()));
				} else if (dto.getFechaRealizacionFrom() != null) {
					if (dto.getFechaRealizacionTo() != null) {
						predicates.add(cb.between(root.get(TareasRealizadas_.fechaRealizacion), dto.getFechaRealizacionFrom(), dto.getFechaRealizacionTo()));
					} else {
						predicates.add(cb.greaterThanOrEqualTo(root.get(TareasRealizadas_.fechaRealizacion), dto.getFechaRealizacionFrom()));
					}
				} else if (dto.getFechaRealizacionTo() != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get(TareasRealizadas_.fechaRealizacion), dto.getFechaRealizacionTo()));
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
    private static Specification<TareasRealizadas> getSpecificationOR(final String searchBasic) {
		Specification<TareasRealizadas> spec = new Specification<TareasRealizadas>() {
	
		    @Override
		    public Predicate toPredicate(Root<TareasRealizadas> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
		
				if (searchBasic != null) {
				    predicates.add(cb.like(root.get(TareasRealizadas_.tareasUsuarios).get(TareasUsuarios_.descripcionTareausuario), "%".concat(searchBasic.concat("%"))));
				    predicates.add(cb.like(root.get(TareasRealizadas_.usuario), "%".concat(searchBasic.concat("%"))));
					predicates.add(cb.like(new StrDateFunction<Date> (cb, root.get(TareasRealizadas_.fechaRealizacion)), "%".concat(searchBasic.concat("%"))));					
				}
		
				return cb.or(predicates.toArray(new Predicate[ ] { }));
		    }
		};
		return spec;
    }
}
