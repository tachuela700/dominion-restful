package es.dominion.curso.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc											//Habilitar Spring MVC
/**
 * @EnableSpringDataWebSupport
 * Anotación para registrar automáticamente los siguientes beans para el uso con Spring MVC.
 * DomainClassConverter - to allow usage of domain types managed by Spring Data repositories as controller method arguments bound with PathVariable or RequestParam.
 * PageableHandlerMethodArgumentResolver - to allow injection of Pageable instances into controller methods automatically created from request parameters.
 * SortHandlerMethodArgumentResolver - to allow injection of Sort instances into controller methods automatically created from request parameters.
 */
@EnableSpringDataWebSupport								
@ComponentScan(basePackages={"es.dominion.curso.web"})	//Habilitar el análisis de componentes
public class APPConfiguracionWeb extends WebMvcConfigurerAdapter {

	/**
	 * Solucionador de vistas JSP
	 
	@Bean
	public ViewResolver viewResolver() {
		//Configurar un solucionador de vistas
		InternalResourceViewResolver viewResolver =  new InternalResourceViewResolver();
		//viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		//Definir si se desea que todos los beans de spring en el contexto de la aplicación sean accesibles como atributos de la petición, 
		//a través de la comprobación perezosa una vez que se accede al atributo.
		//viewResolver.setExposeContextBeansAsAttributes(true);
		return viewResolver;
	}
	/**
	 * Fin solucionador de vistas JSP
	 */
	
	/**
	 * Solucionador de vistas Thymeleaf
	 */
	@Bean(name = "templateResolver")
	public ServletContextTemplateResolver getTemplateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		//templateResolver.setTemplateMode("XHTML");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}

	@Bean(name = "templateEngine")
	public SpringTemplateEngine getTemplateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(getTemplateResolver());
		return templateEngine;
	}

	@Bean(name = "viewResolver")
	public ThymeleafViewResolver getViewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(getTemplateEngine());
		return viewResolver;
	}	
	/**
	 * Fin solucionador de vistas Thymeleaf
	 */
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
//        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/").setCachePeriod(31556926);
//        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/").setCachePeriod(31556926);
//        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/").setCachePeriod(31556926);
        registry.addResourceHandler("/app/**").addResourceLocations("/application/").setCachePeriod(31556926);
        registry.addResourceHandler("/res/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    }
	
	/**
	 * Configurar el procesamiento de contenido estático
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean(name = "messageSource")
	public MessageSource messageSource()
	{
	    ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
	    //Configuración de mensajes en el classpath de la aplicacion (src/main/resources)
	    bean.setBasename("classpath:messages");
	    
	    //Configuración de mensajes en la raíz de la aplicacion Web
	    //bean.setBasename("/WEB-INF/i18n/messages");


	    //Configuración de mensajes en el sistema de archivos
	    //bean.setBasename("file:///opt/messages");
	    //bean.setCacheSeconds(10);

	    bean.setDefaultEncoding("UTF-8");
	    return bean;
	}
	 
	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}
	 
	@Override
	public Validator getValidator()
	{
	    return validator();
	}
}
