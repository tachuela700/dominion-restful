package es.dominion.curso.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.dominion.curso.util.constantes.ConstantesURL;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = {ConstantesURL.INDEX_URL}, method = RequestMethod.GET)
	public String index() {
		logger.debug("Inicio HomeController#index...");
		logger.debug("redirigiendo a [index]");
		return "index";
	}
	
	@RequestMapping(value = {ConstantesURL.HOME_URL}, method = RequestMethod.GET)
	public String home() {
		logger.debug("Inicio HomeController#home...");
		logger.debug("redirigiendo a [home]");
		return "home";
	}
}
