package es.dominion.curso.negocio.repositorios.specifications;

import java.math.BigDecimal;
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

import es.dominion.curso.negocio.entidades.RegistroUsuarios;
import es.dominion.curso.negocio.entidades.RegistroUsuarios_;
import es.dominion.curso.negocio.repositorios.specifications.util.StrDateFunction;
import es.dominion.curso.negocio.repositorios.specifications.util.StrFunction;
import es.dominion.curso.util.dtos.RegistroUsuariosDto;



/**
 * <p>Class RegistroUsuariosSpecification.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 20/04/2016.
 */
public class RegistroUsuariosSpecification {

	/**
     * Utility classes should not have a public constructor.
     */
    private RegistroUsuariosSpecification() {
    }
    
    /**
     * Gets AND Specification.
     * @param dto {@link RegistroUsuariosDto}
     * @param searchBasic Text to search
     * @return {@link Specification}
     */
    public static Specification<RegistroUsuarios> getSpecification(final RegistroUsuariosDto dto, final String searchBasic) {
		Specification<RegistroUsuarios> spec = new Specification<RegistroUsuarios>() {
	
		    @Override
		    public Predicate toPredicate(Root<RegistroUsuarios> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		    	return cb.greaterThan(root.get(RegistroUsuarios_.codigoRegistro), 0L);
		    }
		};
		
		//WHERE - AND
		if (dto!=null) {
		    Specification<RegistroUsuarios> specAND =  getSpecificationAND(dto);
		    spec = Specifications.where(spec).and(specAND);
		}
	
		//WHERE - OR
		if (StringUtils.isNotEmpty(searchBasic)) {
		    Specification<RegistroUsuarios> specOR =  getSpecificationOR(searchBasic);
		    spec = Specifications.where(spec).and(specOR);
		}
		
		return spec;
    }

    /**
     * Gets AND Specification.
     * @param dto {@link RegistroUsuarios}
     * @return {@link Specification}
     */
    private static Specification<RegistroUsuarios> getSpecificationAND(final RegistroUsuariosDto dto) {
		Specification<RegistroUsuarios> spec = new Specification<RegistroUsuarios>() {
	
		    @Override
		    public Predicate toPredicate(Root<RegistroUsuarios> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				/**
				 * Filtro '=' del campo id
				 */
				if (dto.getCodigoRegistro() != null) {
				    predicates.add(cb.equal(root.get(RegistroUsuarios_.codigoRegistro), dto.getCodigoRegistro()));
				}
				
				/**
				 * Filtro '=' del campo codigoUsuario
				 */
				if (StringUtils.isNoneEmpty(dto.getCodigoUsuario())) {
				    predicates.add(cb.equal(root.get(RegistroUsuarios_.codigoUsuario), dto.getCodigoUsuario()));
				}
				/**
				 * Filtro 'like' del campo codigoUsuario
				 */
				if (StringUtils.isNoneEmpty(dto.getCodigoUsuarioLk())) {
				    predicates.add(cb.like(root.get(RegistroUsuarios_.codigoUsuario), "%".concat(dto.getCodigoUsuarioLk().concat("%"))));
				}
				
				/**
				 * Filtro '=' del campo duracion
				 */
				if (StringUtils.isNoneEmpty(dto.getDuracion())) {
				    predicates.add(cb.equal(root.get(RegistroUsuarios_.duracion), dto.getDuracion()));
				}
				/**
				 * Filtro 'like' del campo duracion
				 */
				if (StringUtils.isNoneEmpty(dto.getDuracionLk())) {
				    predicates.add(cb.like(root.get(RegistroUsuarios_.duracion), "%".concat(dto.getDuracionLk().concat("%"))));
				}
							
				/**
				 * Filtro ['=' | 'between' | 'greaterThanOrEqualTo' | 'lessThanOrEqualTo'] del campo fechaEntrada
				 */
				if (dto.getFechaEntrada() != null) { 
				    predicates.add(cb.equal(root.get(RegistroUsuarios_.fechaEntrada), dto.getFechaEntrada()));
				} else if (dto.getFechaEntradaFrom() != null) {
					if (dto.getFechaEntradaTo() != null) {
						predicates.add(cb.between(root.get(RegistroUsuarios_.fechaEntrada), dto.getFechaEntradaFrom(), dto.getFechaEntradaTo()));
					} else {
						predicates.add(cb.greaterThanOrEqualTo(root.get(RegistroUsuarios_.fechaEntrada), dto.getFechaEntradaFrom()));
					}
				} else if (dto.getFechaEntradaTo() != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get(RegistroUsuarios_.fechaEntrada), dto.getFechaEntradaTo()));
				}
				
				/**
				 * Filtro ['=' | 'between' | 'greaterThanOrEqualTo' | 'lessThanOrEqualTo'] del campo fechaSalida
				 */
				if (dto.getFechaSalida() != null) { 
				    predicates.add(cb.equal(root.get(RegistroUsuarios_.fechaSalida), dto.getFechaSalida()));
				} else if (dto.getFechaSalidaFrom() != null) {
					if (dto.getFechaSalidaTo() != null) {
						predicates.add(cb.between(root.get(RegistroUsuarios_.fechaSalida), dto.getFechaSalidaFrom(), dto.getFechaSalidaTo()));
					} else {
						predicates.add(cb.greaterThanOrEqualTo(root.get(RegistroUsuarios_.fechaSalida), dto.getFechaSalidaFrom()));
					}
				} else if (dto.getFechaSalidaTo() != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get(RegistroUsuarios_.fechaSalida), dto.getFechaSalidaTo()));
				}
				
				/**
				 * Filtro ['=' | 'between' | 'greaterThanOrEqualTo' | 'lessThanOrEqualTo'] del campo ficherosSubidos
				 */
				if (dto.getFicherosSubidos() != null) { 
				    predicates.add(cb.equal(root.get(RegistroUsuarios_.ficherosSubidos), dto.getFicherosSubidos()));
				} else if (dto.getFicherosSubidosFrom() != null) {
					if (dto.getFicherosSubidosTo() != null) {
						predicates.add(cb.between(root.get(RegistroUsuarios_.ficherosSubidos), dto.getFicherosSubidosFrom(), dto.getFicherosSubidosTo()));
					} else {
						predicates.add(cb.greaterThanOrEqualTo(root.get(RegistroUsuarios_.ficherosSubidos), dto.getFicherosSubidosFrom()));
					}
				} else if (dto.getFicherosSubidosTo() != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get(RegistroUsuarios_.ficherosSubidos), dto.getFicherosSubidosTo()));
				}
				
				/**
				 * Filtro ['=' | 'between' | 'greaterThanOrEqualTo' | 'lessThanOrEqualTo'] del campo informacionSubida
				 */
				if (dto.getInformacionSubida() != null) { 
				    predicates.add(cb.equal(root.get(RegistroUsuarios_.informacionSubida), dto.getInformacionSubida()));
				} else if (dto.getInformacionSubidaFrom() != null) {
					if (dto.getInformacionSubidaTo() != null) {
						predicates.add(cb.between(root.get(RegistroUsuarios_.informacionSubida), dto.getInformacionSubidaFrom(), dto.getInformacionSubidaTo()));
					} else {
						predicates.add(cb.greaterThanOrEqualTo(root.get(RegistroUsuarios_.informacionSubida), dto.getInformacionSubidaFrom()));
					}
				} else if (dto.getInformacionSubidaTo() != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get(RegistroUsuarios_.informacionSubida), dto.getInformacionSubidaTo()));
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
    private static Specification<RegistroUsuarios> getSpecificationOR(final String searchBasic) {
		Specification<RegistroUsuarios> spec = new Specification<RegistroUsuarios>() {
	
		    @Override
		    public Predicate toPredicate(Root<RegistroUsuarios> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
		
				if (searchBasic != null) {
					predicates.add(cb.like(root.get(RegistroUsuarios_.codigoUsuario), "%".concat(searchBasic.concat("%"))));
					predicates.add(cb.like(root.get(RegistroUsuarios_.duracion), "%".concat(searchBasic.concat("%"))));
					predicates.add(cb.like(new StrDateFunction<Date> (cb, root.get(RegistroUsuarios_.fechaEntrada)), "%".concat(searchBasic.concat("%"))));					
					predicates.add(cb.like(new StrDateFunction<Date> (cb, root.get(RegistroUsuarios_.fechaSalida)), "%".concat(searchBasic.concat("%"))));
					predicates.add(cb.like(new StrFunction<Short> (cb, root.get(RegistroUsuarios_.ficherosSubidos)), "%".concat(searchBasic.concat("%"))));
					predicates.add(cb.like(new StrFunction<BigDecimal> (cb, root.get(RegistroUsuarios_.informacionSubida)), "%".concat(searchBasic.concat("%"))));
				}
		
				return cb.or(predicates.toArray(new Predicate[ ] { }));
		    }
		};
		return spec;
    }
}
