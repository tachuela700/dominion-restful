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

import es.dominion.curso.negocio.entidades.Usuarios;
import es.dominion.curso.negocio.entidades.Usuarios_;
import es.dominion.curso.negocio.repositorios.specifications.util.StrDateFunction;
import es.dominion.curso.util.dtos.UsuariosDto;



/**
 * <p>Class UsuariosSpecification.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 20/04/2016.
 */
public class UsuariosSpecification {

	/**
     * Utility classes should not have a public constructor.
     */
    private UsuariosSpecification() {
    }
    
    /**
     * Gets AND Specification.
     * @param dto {@link UsuariosDto}
     * @param searchBasic Text to search
     * @return {@link Specification}
     */
    public static Specification<Usuarios> getSpecification(final UsuariosDto dto, final String searchBasic) {
		Specification<Usuarios> spec = new Specification<Usuarios>() {
	
		    @Override
		    public Predicate toPredicate(Root<Usuarios> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		    	return cb.isNotNull(root.get(Usuarios_.nombreUsuario));
		    }
		};
		
		//WHERE - AND
		if (dto!=null) {
		    Specification<Usuarios> specAND =  getSpecificationAND(dto);
		    spec = Specifications.where(spec).and(specAND);
		}
	
		//WHERE - OR
		if (StringUtils.isNotEmpty(searchBasic)) {
		    Specification<Usuarios> specOR =  getSpecificationOR(searchBasic);
		    spec = Specifications.where(spec).and(specOR);
		}
		
		return spec;
    }

    /**
     * Gets AND Specification.
     * @param dto {@link Usuarios}
     * @return {@link Specification}
     */
    private static Specification<Usuarios> getSpecificationAND(final UsuariosDto dto) {
		Specification<Usuarios> spec = new Specification<Usuarios>() {
	
		    @Override
		    public Predicate toPredicate(Root<Usuarios> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				/**
				 * Filtro '=' del campo id
				 */
				if (dto.getNombreUsuario() != null) {
				    predicates.add(cb.equal(root.get(Usuarios_.nombreUsuario), dto.getNombreUsuario()));
				}
				
				/**
				 * Filtro '=' del campo password
				 */
				if (StringUtils.isNoneEmpty(dto.getPassword())) {
				    predicates.add(cb.equal(root.get(Usuarios_.password), dto.getPassword()));
				}
				/**
				 * Filtro 'like' del campo password
				 */
				if (StringUtils.isNoneEmpty(dto.getPasswordLk())) {
				    predicates.add(cb.like(root.get(Usuarios_.password), "%".concat(dto.getPasswordLk().concat("%"))));
				}
				
				/**
				 * Filtro '=' del campo carpetaDocumentacion
				 */
				if (StringUtils.isNoneEmpty(dto.getCarpetaDocumentacion())) {
				    predicates.add(cb.equal(root.get(Usuarios_.carpetaDocumentacion), dto.getCarpetaDocumentacion()));
				}
				/**
				 * Filtro 'like' del campo carpetaDocumentacion
				 */
				if (StringUtils.isNoneEmpty(dto.getCarpetaDocumentacionLk())) {
				    predicates.add(cb.like(root.get(Usuarios_.carpetaDocumentacion), "%".concat(dto.getCarpetaDocumentacionLk().concat("%"))));
				}
				
				/**
				 * Filtro '=' del campo idioma
				 */
				if (StringUtils.isNoneEmpty(dto.getIdioma())) {
				    predicates.add(cb.equal(root.get(Usuarios_.idioma), dto.getIdioma()));
				}
				/**
				 * Filtro 'like' del campo idioma
				 */
				if (StringUtils.isNoneEmpty(dto.getIdiomaLk())) {
				    predicates.add(cb.like(root.get(Usuarios_.idioma), "%".concat(dto.getIdiomaLk().concat("%"))));
				}
							
				/**
				 * Filtro ['=' | 'between' | 'greaterThanOrEqualTo' | 'lessThanOrEqualTo'] del campo fechaAlta
				 */
				if (dto.getFechaAlta() != null) {
				    predicates.add(cb.equal(root.get(Usuarios_.fechaAlta), dto.getFechaAlta()));
				} else if (dto.getFechaAltaFrom() != null) {
					if (dto.getFechaAltaTo() != null) {
						predicates.add(cb.between(root.get(Usuarios_.fechaAlta), dto.getFechaAltaFrom(), dto.getFechaAltaTo()));
					} else {
						predicates.add(cb.greaterThanOrEqualTo(root.get(Usuarios_.fechaAlta), dto.getFechaAltaFrom()));
					}
				} else if (dto.getFechaAltaTo() != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get(Usuarios_.fechaAlta), dto.getFechaAltaTo()));
				}
							
				/**
				 * Filtro ['=' | 'between' | 'greaterThanOrEqualTo' | 'lessThanOrEqualTo'] del campo fechaBaja
				 */
				if (dto.getFechaBaja() != null) {
				    predicates.add(cb.equal(root.get(Usuarios_.fechaBaja), dto.getFechaBaja()));
				} else if (dto.getFechaBajaFrom() != null) {
					if (dto.getFechaBajaTo() != null) {
						predicates.add(cb.between(root.get(Usuarios_.fechaBaja), dto.getFechaBajaFrom(), dto.getFechaBajaTo()));
					} else {
						predicates.add(cb.greaterThanOrEqualTo(root.get(Usuarios_.fechaBaja), dto.getFechaBajaFrom()));
					}
				} else if (dto.getFechaBajaTo() != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get(Usuarios_.fechaBaja), dto.getFechaBajaTo()));
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
    private static Specification<Usuarios> getSpecificationOR(final String searchBasic) {
		Specification<Usuarios> spec = new Specification<Usuarios>() {
	
		    @Override
		    public Predicate toPredicate(Root<Usuarios> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
		
				if (searchBasic != null) {
					predicates.add(cb.like(root.get(Usuarios_.password), "%".concat(searchBasic.concat("%"))));
					predicates.add(cb.like(new StrDateFunction<Date> (cb, root.get(Usuarios_.fechaAlta)), "%".concat(searchBasic.concat("%"))));					
					predicates.add(cb.like(new StrDateFunction<Date> (cb, root.get(Usuarios_.fechaBaja)), "%".concat(searchBasic.concat("%"))));					
					predicates.add(cb.like(root.get(Usuarios_.carpetaDocumentacion), "%".concat(searchBasic.concat("%"))));
					predicates.add(cb.like(root.get(Usuarios_.idioma), "%".concat(searchBasic.concat("%"))));
				}
		
				return cb.or(predicates.toArray(new Predicate[ ] { }));
		    }
		};
		return spec;
    }
}
