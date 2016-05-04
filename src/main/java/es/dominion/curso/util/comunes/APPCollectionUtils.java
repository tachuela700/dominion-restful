package es.dominion.curso.util.comunes;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;

public class APPCollectionUtils {
	
	public static String debugPrintCollection(final Collection<?> listado) {
        if (listado == null || listado.isEmpty()) {
            return null;
        }
        
        final StringBuilder stb = new StringBuilder();

        for (Object object : listado) {
        	stb.append(object!=null ? object.toString() : "");
		}
        return stb.toString();
    }

	public static String debugPrintPage(final Page<?> page) {
        if (page == null || page.getContent() == null || page.getContent().isEmpty()) {
            return null;
        }
        
        final StringBuilder stb = new StringBuilder();
        stb.append("Page: [number=");
        stb.append(page.getNumber());
        stb.append(", numberOfElements=");
        stb.append(page.getNumberOfElements());
        stb.append(", size=");
        stb.append(page.getSize());
        stb.append(", totalElements=");
        stb.append(page.getTotalElements());
        stb.append(", totalPages=");
        stb.append(page.getTotalPages());
        stb.append(", content=");
        
        List<?> listado = page.getContent();
        
        for (Object object : listado) {
        	stb.append(object!=null ? object.toString() : "");
		}
        stb.append("]");
        return stb.toString();
    }
}
