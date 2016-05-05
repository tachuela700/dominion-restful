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

import es.dominion.curso.negocio.entidades.Pais;
import es.dominion.curso.negocio.entidades.Pais_;
import es.dominion.curso.negocio.repositorios.specifications.util.StrFunction;
import es.dominion.curso.util.dtos.PaisDto;



/**
 * <p>Class PaisSpecification.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 20/04/2016.
 */
public class PaisSpecification {

	/**
     * Utility classes should not have a public constructor.
     */
    private PaisSpecification() {
    }
    
    /**
     * Gets AND Specification.
     * @param dto {@link PaisDto}
     * @param searchBasic Text to search
     * @return {@link Specification}
     */
    public static Specification<Pais> getSpecification(final PaisDto dto, final String searchBasic) {
		Specification<Pais> spec = new Specification<Pais>() {
	
		    @Override
		    public Predicate toPredicate(Root<Pais> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		    	return cb.greaterThan(root.get(Pais_.codigoPais), 0L);
		    }
		};
		
		//WHERE - AND
		if (dto!=null) {
		    Specification<Pais> specAND =  getSpecificationAND(dto);
		    spec = Specifications.where(spec).and(specAND);
		}
	
		//WHERE - OR
		if (StringUtils.isNotEmpty(searchBasic)) {
		    Specification<Pais> specOR =  getSpecificationOR(searchBasic);
		    spec = Specifications.where(spec).and(specOR);
		}
		
		return spec;
    }

    /**
     * Gets AND Specification.
     * @param dto {@link Pais}
     * @return {@link Specification}
     */
    private static Specification<Pais> getSpecificationAND(final PaisDto dto) {
		Specification<Pais> spec = new Specification<Pais>() {
	
		    @Override
		    public Predicate toPredicate(Root<Pais> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				/**
				 * Filtro '=' del campo id
				 */
				if (dto.getCodigoPais() != null) {
				    predicates.add(cb.equal(root.get(Pais_.codigoPais), dto.getCodigoPais()));
				}
				
				/**
				 * Filtro '=' del campo paisIso2
				 */
				if (StringUtils.isNoneEmpty(dto.getPaisIso2())) {
				    predicates.add(cb.equal(root.get(Pais_.paisIso2), dto.getPaisIso2()));
				}
				/**
				 * Filtro 'like' del campo paisIso2
				 */
				if (StringUtils.isNoneEmpty(dto.getPaisIso2Lk())) {
				    predicates.add(cb.like(root.get(Pais_.paisIso2), "%".concat(dto.getPaisIso2Lk().concat("%"))));
				}
				
				/**
				 * Filtro '=' del campo paisIso3
				 */
				if (StringUtils.isNoneEmpty(dto.getPaisIso3())) {
				    predicates.add(cb.equal(root.get(Pais_.paisIso3), dto.getPaisIso3()));
				}
				/**
				 * Filtro 'like' del campo paisIso3
				 */
				if (StringUtils.isNoneEmpty(dto.getPaisIso3Lk())) {
				    predicates.add(cb.like(root.get(Pais_.paisIso3), "%".concat(dto.getPaisIso3Lk().concat("%"))));
				}
				
				/**
				 * Filtro '=' del campo paisNombre
				 */
				if (StringUtils.isNoneEmpty(dto.getPaisNombre())) {
				    predicates.add(cb.equal(root.get(Pais_.paisNombre), dto.getPaisNombre()));
				}
				/**
				 * Filtro 'like' del campo paisNombre
				 */
				if (StringUtils.isNoneEmpty(dto.getPaisNombreLk())) {
				    predicates.add(cb.like(root.get(Pais_.paisNombre), "%".concat(dto.getPaisNombreLk().concat("%"))));
				}
							
				/**
				 * Filtro ['=' | 'between' | 'greaterThanOrEqualTo' | 'lessThanOrEqualTo'] del campo col2
				 */
				if (dto.getPaisIsonum() != null) {
				    predicates.add(cb.equal(root.get(Pais_.paisIsonum), dto.getPaisIsonum()));
				} else if (dto.getPaisIsonumFrom() != null) {
					if (dto.getPaisIsonumTo() != null) {
						predicates.add(cb.between(root.get(Pais_.paisIsonum), dto.getPaisIsonumFrom(), dto.getPaisIsonumTo()));
					} else {
						predicates.add(cb.greaterThanOrEqualTo(root.get(Pais_.paisIsonum), dto.getPaisIsonumFrom()));
					}
				} else if (dto.getPaisIsonumTo() != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get(Pais_.paisIsonum), dto.getPaisIsonumTo()));
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
    private static Specification<Pais> getSpecificationOR(final String searchBasic) {
		Specification<Pais> spec = new Specification<Pais>() {
	
		    @Override
		    public Predicate toPredicate(Root<Pais> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
		
				if (searchBasic != null) {
					predicates.add(cb.like(cb.upper(root.get(Pais_.paisIso2)), "%".concat(StringUtils.upperCase(searchBasic).concat("%"))));
					predicates.add(cb.like(cb.upper(root.get(Pais_.paisIso3)), "%".concat(StringUtils.upperCase(searchBasic).concat("%"))));
					predicates.add(cb.like(cb.upper(root.get(Pais_.paisNombre)), "%".concat(StringUtils.upperCase(searchBasic).concat("%"))));
					predicates.add(cb.like(new StrFunction<Integer> (cb, root.get(Pais_.paisIsonum)), "%".concat(StringUtils.upperCase(searchBasic).concat("%"))));					
				}
		
				return cb.or(predicates.toArray(new Predicate[ ] { }));
		    }
		};
		return spec;
    }
}
