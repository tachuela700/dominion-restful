package es.dominion.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class APPInicializadorAplicacionWeb extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Especificación de la/s clase/s de configuracion de la aplicación
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {APPConfiguracionAplicacion.class, APPConfiguracionPersistencia.class};
	}

	/**
	 * Especificación de la/s clase/s de configuracion de la parte Web
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {APPConfiguracionWeb.class};
	}

	/**
	 * Asignar DispatcherServle a /
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
