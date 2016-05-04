package es.dominion.curso.util.comunes;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class APPMapperUtils {

	public static <T, D> List<D> map(final Mapper mapper, final List<T> source, final Class<D> destType) {

		final List<D> dest = new ArrayList<D>();

		for (T element : source) {
			dest.add(mapper.map(element, destType));
		}

		return dest;
	}
	
	public static <T, D> Page<D> map(final Mapper mapper, final Pageable pageable, final Page<T> source, final Class<D> destType) {

		Page<D> dest = null;		
		if (source!=null && source.getContent()!=null && !source.getContent().isEmpty()) {
			List<D> dList = null; 
			List<T> tList = source.getContent();
			if (tList != null && !tList.isEmpty()) {
				dList = new ArrayList<D>();
				for (T element : tList) {
					dList.add(mapper.map(element, destType));
				}
			}
			
			dest = new PageImpl<D>(dList, pageable, source.getTotalElements());
		}
		return dest;
	}
}
